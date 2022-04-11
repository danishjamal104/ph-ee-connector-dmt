package org.mifos.connector.dmt.camel.routes

import org.apache.camel.Exchange
import org.apache.camel.LoggingLevel
import org.apache.camel.builder.RouteBuilder
import org.mifos.connector.dmt.utility.getCameDirectEndpoint
import org.mifos.connector.dmt.zeebe.worker.Worker
import org.springframework.stereotype.Component

@Component
class BeneficiaryRoutes : RouteBuilder() {

    override fun configure() {

        /**
         * todo implementation
         * 1. Parse the beneficiary info
         * 2. Call the BillAvenue get beneficiary endpoint
         * 3. Return the result
         */
        from(Worker.BeneficiaryLookup.id.getCameDirectEndpoint())
            .id(Worker.BeneficiaryLookup.id)
            .log(LoggingLevel.INFO, "### Starting ${Worker.BeneficiaryLookup.id} route")

        /**
         * todo implementation
         * 1. Parse the sender info
         * 2. Call the BillAvenue add beneficiary endpoint
         * 3. Return the result
         */
        from(Worker.AddBeneficiary.id.getCameDirectEndpoint())
            .id(Worker.AddBeneficiary.id)
            .log(LoggingLevel.INFO, "### Starting ${Worker.AddBeneficiary.id} route")


    }
}
