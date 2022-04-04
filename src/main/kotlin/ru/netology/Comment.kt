package ru.netology

import java.time.LocalDateTime

data class Comment(
    val id: Int,
    val fromId: Int,
    val date: LocalDateTime = LocalDateTime.now(),
    val text: String,
    val parentComment: Comment?,
    val parentPost: Post?,

) {
    var reports = emptyArray<Int>()
    var attachment = emptyArray<Attachment>()

    var replyToUser: Int? = null
        set(value) {
            if (value != null) {
                if (value < 0) return
            } else field = value
        }
        get() = parentComment?.fromId?: parentPost?.fromId


    var replyToComment: Int? = null
        set(value) {
            if (value != null) {
                if (value < 0) return
            } else field = value
        }
    get() = parentComment?.fromId?: null

    var parentId: Int? = 0
        get() = parentPost?.id?: parentComment?.id

    var parentsStack = emptyArray<Int>()



    override fun toString(): String {
        return "Comment id $id\nFrom user $fromId\n$date\n$text\n$replyToUser $replyToComment"
    }
}