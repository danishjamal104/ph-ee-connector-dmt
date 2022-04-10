package org.mifos.connector.dmt

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import org.apache.camel.Exchange
import org.apache.camel.Processor
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class DmtConnectorApplication {

	@Bean
	fun objectMapper(): ObjectMapper? {
		val objectMapper = ObjectMapper()
		objectMapper.registerModule(JavaTimeModule())
		objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
		return objectMapper
			.setSerializationInclusion(JsonInclude.Include.NON_NULL)
			.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true)
			.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
	}

	@Bean
	fun pojoToString(objectMapper: ObjectMapper): Processor? {
		return Processor { exchange: Exchange ->
			exchange.getIn().body = objectMapper.writeValueAsString(exchange.getIn().body)
		}
	}
}

fun main(args: Array<String>) {
	runApplication<DmtConnectorApplication>(*args)
}
