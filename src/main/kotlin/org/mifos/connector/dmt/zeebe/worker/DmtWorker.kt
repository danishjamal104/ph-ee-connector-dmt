package org.mifos.connector.dmt.zeebe.worker

import org.apache.camel.CamelContext
import org.apache.camel.Exchange
import org.apache.camel.ProducerTemplate
import org.apache.camel.support.DefaultExchange
import org.mifos.connector.dmt.utility.getCameDirectEndpoint
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import javax.annotation.PostConstruct

@Component
class DmtWorker {

    @Autowired
    private lateinit var producerTemplate: ProducerTemplate

    @Autowired
    private lateinit var camelContext: CamelContext
    
    @Autowired
    private lateinit var zeebeWorkerHelper: ZeebeWorkerHelper

    @PostConstruct
    fun setupWorkers() {
        
        zeebeWorkerHelper.scheduleWorker(Worker.SenderLookup) { variable ->
            val newVariable = HashMap<String, Any>()
            val exchange = DefaultExchange(camelContext)
            producerTemplate.send(Worker.SenderLookup.id.getCameDirectEndpoint(), exchange)
            return@scheduleWorker newVariable
        }

        zeebeWorkerHelper.scheduleWorker(Worker.AddSender) { variable ->
            val newVariable = HashMap<String, Any>()
            val exchange = DefaultExchange(camelContext)
            producerTemplate.send(Worker.AddSender.id.getCameDirectEndpoint(), exchange)
            return@scheduleWorker newVariable
        }

        zeebeWorkerHelper.scheduleWorker(Worker.VerifySender) { variable ->
            val newVariable = HashMap<String, Any>()
            val exchange = DefaultExchange(camelContext)
            producerTemplate.send(Worker.VerifySender.id.getCameDirectEndpoint(), exchange)
            return@scheduleWorker newVariable
        }

        zeebeWorkerHelper.scheduleWorker(Worker.ResendOtp) { variable ->
            val newVariable = HashMap<String, Any>()
            val exchange = DefaultExchange(camelContext)
            producerTemplate.send(Worker.ResendOtp.id.getCameDirectEndpoint(), exchange)
            return@scheduleWorker newVariable
        }

        zeebeWorkerHelper.scheduleWorker(Worker.BeneficiaryLookup) { variable ->
            val newVariable = HashMap<String, Any>()
            val exchange = DefaultExchange(camelContext)
            producerTemplate.send(Worker.BeneficiaryLookup.id.getCameDirectEndpoint(), exchange)
            return@scheduleWorker newVariable
        }

        zeebeWorkerHelper.scheduleWorker(Worker.AddBeneficiary) { variable ->
            val newVariable = HashMap<String, Any>()
            val exchange = DefaultExchange(camelContext)
            producerTemplate.send(Worker.AddBeneficiary.id.getCameDirectEndpoint(), exchange)
            return@scheduleWorker newVariable
        }

        zeebeWorkerHelper.scheduleWorker(Worker.TransferFund) { variable ->
            val newVariable = HashMap<String, Any>()
            val exchange = DefaultExchange(camelContext)
            producerTemplate.send(Worker.TransferFund.id.getCameDirectEndpoint(), exchange)
            return@scheduleWorker newVariable
        }

        zeebeWorkerHelper.scheduleWorker(Worker.GetTransactionStatus) { variable ->
            val newVariable = HashMap<String, Any>()
            val exchange = DefaultExchange(camelContext)
            producerTemplate.send(Worker.GetTransactionStatus.id.getCameDirectEndpoint(), exchange)
            return@scheduleWorker newVariable
        }
    }
}
