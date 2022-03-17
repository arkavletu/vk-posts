package ru.netology.attachment

class AudioAttachment(val audio: Audio): Attachment() {
    override val type: String = "audio"

    override val objectType = audio





}