package ru.netology.attachment

class NoteAttachment(note: Note): Attachment() {
    override val type: String = "note"

    override val objectType = note

}