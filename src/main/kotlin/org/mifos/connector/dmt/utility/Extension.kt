package org.mifos.connector.dmt.utility

fun String.getCameDirectEndpoint(): String {
    return "direct:${this}"
}
