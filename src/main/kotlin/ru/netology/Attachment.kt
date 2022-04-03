package ru.netology



sealed class Attachment () {
    abstract val type: String

    data class AudioAttachment(val audio: Audio, override val type: String = "Audio") : Attachment()
    data class DocumentAttachment(val doc: Document, override val type: String = "Doc") : Attachment()
    data class EventAttachment(val event: Event, override val type: String = "Event") : Attachment()
    data class NoteAttachment(val note: Note, override val type: String = "Note") : Attachment()
    data class PhotoAttachment(val photo: Photo, override val type: String = "Photo") : Attachment()


}










