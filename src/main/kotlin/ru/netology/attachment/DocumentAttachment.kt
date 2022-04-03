package ru.netology.attachment

data class DocumentAttachment(
    val document: Document,
    override val type: String = "doc",
) : Attachment() {
}