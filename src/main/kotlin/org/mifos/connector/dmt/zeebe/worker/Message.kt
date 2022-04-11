package org.mifos.connector.dmt.zeebe.worker

sealed class Message(val messageName: String) {
    object SenderInfo: Message("sender_info")
    object Otp: Message("otp")
    object BeneficiaryDetails: Message("beneficiary_details")
    data class Custom(val customMessageName: String): Message(customMessageName)
}
