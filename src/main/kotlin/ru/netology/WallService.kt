package ru.netology


object WallService {

    var posts = emptyArray<Post>()

    fun add(post: Post): Post {

        if (!posts.contains(post)) {
            posts += post
            posts[posts.indexOf(post)] = makeId(post)
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
                post.ownerId == Post.ownerId
                post.date == Post.date
                posts[posts.indexOf(Post)] = post
                return true
            }
        }

        return false
    }

    fun emptySingleton() {
        posts = emptyArray()
    }

    fun attach(post: Post, attachment: Attachment) {
        post.attachment += attachment
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

    fun printAttachment(post: Post) {
        if (post.attachment.isNotEmpty()) {
            for (element in post.attachment) {
                println(print(element))
            }
        } else {
            println("No attachments")
        }
    }
}