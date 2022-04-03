package ru.netology.attachment

data class EventAttachment(
    val event: Event,
    override val type: String = "event",
) : Attachment() {
}