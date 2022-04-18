package io.fynarfin.connector.dmt.zeebe.worker

sealed class Worker(val id: String) {
    object SenderLookup: Worker("sender-lookup")
    object AddSender: Worker("add-sender")
    object VerifySender: Worker("verify-sender")
    object ResendOtp: Worker("resend-otp")
    object BeneficiaryLookup: Worker("beneficiary-lookup")
    object AddBeneficiary: Worker("add-beneficiary")
    object TransferFund: Worker("transfer-fund")
    object GetTransactionStatus: Worker("get-transaction-status")
    data class Custom(val customWorkerId: String): Worker(customWorkerId)
}
