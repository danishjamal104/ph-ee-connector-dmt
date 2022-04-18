package io.fynarfin.connector.dmt.camel.routes

import org.apache.camel.LoggingLevel
import org.apache.camel.builder.RouteBuilder
import io.fynarfin.connector.dmt.utility.getCameDirectEndpoint
import io.fynarfin.connector.dmt.zeebe.worker.Worker
import org.springframework.stereotype.Component

@Component
class SenderRoutes : RouteBuilder() {

    override fun configure() {

        /**
         * todo implementation
         * 1. Parse the sender info
         * 2. Call the BillAvenue sender enquiry endpoint
         * 3. Return the result
         */
        from(Worker.SenderLookup.id.getCameDirectEndpoint())
            .id(Worker.SenderLookup.id)
            .log(LoggingLevel.INFO, "### Starting ${Worker.SenderLookup.id} route")

        /**
         * todo implementation
         * 1. Parse the sender info
         * 2. Call the BillAvenue add sender endpoint
         * 3. Return the result and wait for otp
         */
        from(Worker.AddSender.id.getCameDirectEndpoint())
            .id(Worker.AddSender.id)
            .log(LoggingLevel.INFO, "### Starting ${Worker.AddSender.id} route")

        /**
         * todo implementation
         * 1. Parse the sender info
         * 2. Call the BillAvenue verify sender endpoint
         * 3. Return the result
         */
        from(Worker.VerifySender.id.getCameDirectEndpoint())
            .id(Worker.VerifySender.id)
            .log(LoggingLevel.INFO, "### Starting ${Worker.VerifySender.id} route")

        /**
         * todo implementation
         * 1. Parse the sender info
         * 2. Call the BillAvenue resend otp endpoint
         * 3. Return the result and wait for otp
         */
        from(Worker.ResendOtp.id.getCameDirectEndpoint())
            .id(Worker.ResendOtp.id)
            .log(LoggingLevel.INFO, "### Starting ${Worker.ResendOtp.id} route")

    }
}
