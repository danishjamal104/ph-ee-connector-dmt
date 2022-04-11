package org.mifos.connector.dmt.zeebe.worker

import io.camunda.zeebe.client.ZeebeClient
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.time.Duration

@Component
class ZeebeWorkerHelper {

    @Autowired
    private lateinit var zeebeClient: ZeebeClient

    @Value("\${zeebe.client.evenly-allocated-max-jobs}")
    private lateinit var workerMaxJobs: Number

    @Value("\${zeebe.client.ttl}")
    private lateinit var timeToLive: Number

    fun scheduleWorker(worker: Worker, task: (variable: Map<String, Any>) -> Map<String, Any>) {
        zeebeClient.newWorker()
            .jobType(worker.id)
            .handler { client, job ->
                val variables = job.variablesAsMap
                val newVariables = task.invoke(variables)
                variables.putAll(newVariables)
                client.newCompleteCommand(job.key)
                    .variables(variables)
                    .send()
                    .join()
            }
            .name(worker.id)
            .maxJobsActive(workerMaxJobs.toInt())
            .open()
    }

    fun publishMessage(message: Message, correlationId: String, variables: Map<String, Any>) {
        zeebeClient.newPublishMessageCommand()
            .messageName(message.messageName)
            .correlationKey(correlationId)
            .timeToLive(Duration.ofMillis(timeToLive.toLong()))
            .variables(variables)
            .send()
            .join();
    }

}
