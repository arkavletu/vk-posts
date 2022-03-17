package ru.netology.attachment

class EventAttachment(event: Event): Attachment() {
    override val type: String = "event"

    override val objectType: Any = event

    override fun toString(): String {
        return objectType.toString()
    }
}