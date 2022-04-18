package io.fynarfin.connector.dmt.camel.config

import org.apache.camel.CamelContext
import org.apache.camel.spi.RestConfiguration
import org.apache.camel.spring.boot.CamelContextConfiguration
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class CamelContextConfig {

    @Value("\${camel.server-port}")
    private lateinit var serverPort: Number

    @Bean
    fun contextConfiguration(): CamelContextConfiguration {
        return object : CamelContextConfiguration {
            override fun beforeApplicationStart(camelContext: CamelContext) {
                camelContext.isTracing = false
                camelContext.isMessageHistory = false
                camelContext.isStreamCaching = true
                camelContext.disableJMX()
                val rest = RestConfiguration()
                camelContext.restConfiguration = rest
                rest.component = "undertow"
                rest.producerComponent = "undertow"
                rest.port = serverPort.toInt()
                rest.bindingMode = RestConfiguration.RestBindingMode.json
                rest.dataFormatProperties = HashMap()
                rest.dataFormatProperties["prettyPrint"] = "true"
                rest.scheme = "http"
            }

            override fun afterApplicationStart(camelContext: CamelContext) {
                // empty
            }
        }
    }
}
