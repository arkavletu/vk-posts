package ru.netology


import java.time.LocalDateTime
import ru.netology.Attachment.*

fun main() {
    val postToUpdate = Post("updated", null, friendsOnly = true, ownerId = 2)
    WallService.add(postToUpdate)
    WallService.add(Post("first post", null))
    WallService.add(Post("second post", postToUpdate))
    WallService.add(Post("need to update", null))


    val comment1 = Comment(1, 1, text = "comment", parentPost = postToUpdate, parentComment = null)
    WallService.attach(comment1, PhotoAttachment(Photo(111,222,345,456, LocalDateTime.now(),null,null)))
    println(WallService.createComment(comment1))
    WallService.reportComment(comment1, 3)


}