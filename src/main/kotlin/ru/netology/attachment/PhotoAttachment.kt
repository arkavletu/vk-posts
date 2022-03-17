package ru.netology.attachment

class PhotoAttachment(val photo: Photo): Attachment() {
    override val type = "photo"

    override val objectType = photo

}