package ru.netology.attachment

data class NoteAttachment(
    val note: Note,
    override val type: String = "note",
) : Attachment() {
}