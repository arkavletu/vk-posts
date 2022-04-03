package ru.netology.attachment

data class PhotoAttachment(
    val photo: Photo,
    override val type: String = "photo",
) : Attachment() {

}