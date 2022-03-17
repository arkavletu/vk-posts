package ru.netology.attachment

class DocumentAttachment(document: Document): Attachment() {
    override val type: String = "doc"

    override val objectType: Any = document

    override fun toString(): String {
        return objectType.toString()
    }
}