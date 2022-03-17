package ru.netology.attachment

class Audio (
    val id: Int,
    val ownerId: Int,
    val artist: String,
    val title: String,
    val duration: Int, //sec
    val url: String,
    val text: String?,
    val album: String?,
    val date: Int,
    val genre: String, // enum
    val canSearch: Boolean = true
        ) {

    override fun toString(): String{
        return "audio"//"audio id $id\nartist $artist\ntitle $title"
    }
//TODO сделать поля чтобы отображались в зависимости от того откуда аудио
}