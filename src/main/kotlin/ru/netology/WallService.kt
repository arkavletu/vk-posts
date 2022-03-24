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

    fun makeId(post: Post): Post{
        val postWithId = post.copy(id = posts.indexOf(post) + 1)
        return postWithId
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
}
