package ru.netology


import java.time.LocalDateTime
import ru.netology.Attachment.*

fun main() {
    val postToUpdate = Post("updated", null, friendsOnly = true, ownerId = 2)
    WallService.add(postToUpdate)
    WallService.add(Post("first post", null))
    WallService.add(Post("second post", postToUpdate))
    WallService.add(Post("need to update", null))

    val comment = Comment(12,2, LocalDateTime.now(),"nope",null,WallService.posts[0])
    WallService.createComment(comment)

    WallService.createComment(Comment(23,3, text = "test comment",
        parentComment = comment, parentPost = null))

    println(comment.parentsStack.contentToString())
    println(WallService.comments[1].parentsStack.contentToString())



}