package ru.netology



sealed class Attachment (val type: String) {


    data class AudioAttachment(val audio: Audio) : Attachment("Audio")
    data class DocumentAttachment(val doc: Document) : Attachment("Doc")
    data class EventAttachment(val event: Event) : Attachment("Event")
    data class NoteAttachment(val note: Note) : Attachment("Note")
    data class PhotoAttachment(val photo: Photo) : Attachment("Photo")


}










