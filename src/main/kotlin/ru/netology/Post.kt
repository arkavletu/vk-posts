package ru.netology


import ru.netology.attachment.Attachment
import java.time.LocalDateTime

class Post internal constructor(

    private val text: String,
    val original: Post?,
    //fromId: Int?, //от кого запись
    //replyOwnerId: Int?, // чью запись репостнули

    private val ownerId: Int = 1, //чья стена
    private val friendsOnly: Boolean = false,
    private val likes: Int = 0,
    private val reposts: Int = 0,
    internal var id: Int = 0,
    private val date: LocalDateTime? = LocalDateTime.now(), // unixtime!


    // createdBy кто админ, isPinned закреплена ли

) {

    var fromId: Int? = 0
        set(value) {
            if (value != null) {
                if (value < 0) return
            } else field = value
        }
        get() = original?.fromId ?: this.ownerId // одинаковые

    var replyOwnerId: Int? = 0
        set(value) {
            if (value != null) {
                if (value < 0) return
            } else field = value
        }
        get() = original?.fromId
            ?: this.ownerId //Suspicious 'var' property: its setter does not influence its getter result



    override fun toString(): String {
        return "$id owner $ownerId\n$date\nAuthor $fromId\n$text\n$likes " +
                "likes $reposts reposts\n${original?.id} $fromId $replyOwnerId"
    }


}
