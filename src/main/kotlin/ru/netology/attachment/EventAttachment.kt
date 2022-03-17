package ru.netology.attachment

class EventAttachment(event: Event): Attachment() {
    override val type: String = "event"

    override val objectType: Any = event


}