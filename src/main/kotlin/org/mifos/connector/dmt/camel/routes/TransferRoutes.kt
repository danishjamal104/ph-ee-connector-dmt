package org.mifos.connector.dmt.camel.routes

import org.apache.camel.LoggingLevel
import org.apache.camel.builder.RouteBuilder
import org.mifos.connector.dmt.utility.getCameDirectEndpoint
import org.mifos.connector.dmt.zeebe.worker.Worker
import org.springframework.stereotype.Component

@Component
class TransferRoutes : RouteBuilder() {

    override fun configure() {

        /**
         * todo implementation
         * 1. Build the transfer payload using zeebe variable
         * 2. Call the BillAvenue transfer endpoint
         * 3. Return the result
         */
        from(Worker.TransferFund.id.getCameDirectEndpoint())
            .id(Worker.TransferFund.id)
            .log(LoggingLevel.INFO, "### Starting ${Worker.TransferFund.id} route")

        /**
         * todo implementation
         * 1. Build the transfer payload using zeebe variable
         * 2. Call the BillAvenue transaction status endpoint
         * 3. Return the result
         */
        from(Worker.GetTransactionStatus.id.getCameDirectEndpoint())
            .id(Worker.GetTransactionStatus.id)
            .log(LoggingLevel.INFO, "### Starting ${Worker.GetTransactionStatus.id} route")


    }
}
