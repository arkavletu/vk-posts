package ru.netology.attachment

class Document(
    val id: Int,
    val ownerId: Int,
    val title: String,
    val size: Int,//байты
    val ext: String,
    val url: String,
    val date: Int,
    val type: Int
    //val preview: Any
) {
    fun typeOfDoc(digit: Int): String {
        val types = arrayOf("text","archive","gif","picture","audio","video","eBook","неизвестный формат")
        return when (digit) {
            in 0..types.size -> types[digit - 1]
            else -> {"error"}
        }
    }

    override fun toString(): String {
        return "doc"//"Doc id $id, owner $ownerId\n$title.$ext\n$date\n${typeOfDoc(type)} $size bites"
    }
}