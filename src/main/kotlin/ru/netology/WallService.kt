package ru.netology


object WallService {

    var posts = emptyArray<Post>()
    var comments = emptyArray<Comment>()

    fun add(post: Post): Post {

        if (!posts.contains(post)) {
            posts += post
            posts[posts.indexOf(post)] = makeId(post)
            if (post.original != null) {
                post.original.reposts++
            }
        }
        return posts.last()
    }

    fun makeId(post: Post): Post {
        post.id = posts.indexOf(post) + 1
        return post
    }

    fun update(post: Post): Boolean {
        for (Post in posts) {
            if (post.id == Post.id) {
                post.ownerId = Post.ownerId
                post.date = Post.date
                posts[posts.indexOf(Post)] = post
                return true
            }
        }

        return false
    }

    fun emptySingleton() {
        posts = emptyArray()
        comments = emptyArray()
    }

    fun attach(any: Any, attachment: Attachment) {
        when (any) {
            is Post -> any.attachment += attachment
            is Comment -> any.attachment += attachment
            else -> throw PostOrCommentNotFoundException()
        }

    }

    fun print(attachment: Attachment): String {
        return when (attachment) {
            is Attachment.AudioAttachment -> "${attachment.type}\n${attachment.audio}"
            is Attachment.DocumentAttachment -> "${attachment.type}\n${attachment.doc}"
            is Attachment.EventAttachment -> "${attachment.type}\n${attachment.event}"
            is Attachment.NoteAttachment -> "${attachment.type}\n${attachment.note}"
            is Attachment.PhotoAttachment -> "${attachment.type}\n${attachment.photo}"
        }
    }

    fun printAttachment(any: Any) {
        when (any) {
            is Post -> if (any.attachment.isNotEmpty()) {
                for (element in any.attachment) {
                    println(print(element))
                }
            } else {
                println("No attachments")
            }
            is Comment -> if (any.attachment.isNotEmpty()) {
                for (element in any.attachment) {
                    println(print(element))
                }
            } else {
                println("No attachments")
            }
            else -> throw PostOrCommentNotFoundException()
        }
    }

    fun createComment(comment: Comment): Boolean {
        for (post in posts) {
            if (post.id == comment.parentId||post.id == comment.parentComment?.parentId) {
                comments += comment
                comment.parentsStack += comment.parentId!! // до проверки !! не дойдет
                if(comment.parentComment?.parentId != null) comment.parentsStack += comment.parentComment.parentId!!
                return true
            } else throw PostOrCommentNotFoundException()
        }

        return false
    }

    fun reportComment(comment: Comment, reason: Int) {
        for (element in comments) {
            if (comment.id == element.id) {
                if (Report.values().contains(Report.values().get(reason))) {
                    comment.reports += reason
                }
            }
        }
    }
}