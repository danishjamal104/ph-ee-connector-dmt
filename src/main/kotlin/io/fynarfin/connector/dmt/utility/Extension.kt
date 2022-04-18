package io.fynarfin.connector.dmt.utility

fun String.getCameDirectEndpoint(): String {
    return "direct:${this}"
}
