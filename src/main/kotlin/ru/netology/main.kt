package ru.netology


import java.time.LocalDateTime
import ru.netology.Attachment.*

fun main() {
    val postToUpdate = Post("updated", null, friendsOnly = true, ownerId = 2)
    WallService.add(postToUpdate)
    WallService.add(Post("first post", null))
    WallService.add(Post("second post", postToUpdate))
    WallService.add(Post("need to update", null))


    val photoTest: Attachment = PhotoAttachment(Photo(22, 1, 65, 65,
        LocalDateTime.now(), null, null))
    WallService.attach(postToUpdate, photoTest)

    println(WallService.posts[0])
    WallService.printAttachment(WallService.posts[0])


}