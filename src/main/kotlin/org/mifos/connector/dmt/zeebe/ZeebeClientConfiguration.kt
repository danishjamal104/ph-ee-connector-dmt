package org.mifos.connector.dmt.zeebe

import io.camunda.zeebe.client.ZeebeClient
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ZeebeClientConfiguration {

    @Value("\${zeebe.broker.contactpoint}")
    private val zeebeBrokerContactpoint: String? = null

    @Value("\${zeebe.client.max-execution-threads}")
    private val zeebeClientMaxThreads = 0
    @Bean
    fun setup(): ZeebeClient {
        return ZeebeClient.newClientBuilder()
            .gatewayAddress(zeebeBrokerContactpoint)
            .usePlaintext()
            .numJobWorkerExecutionThreads(zeebeClientMaxThreads)
            .build()
    }
}
