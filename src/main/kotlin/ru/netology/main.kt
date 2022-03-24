package ru.netology


import java.time.LocalDateTime
import ru.netology.Attachment.*

fun main() {
    val postToUpdate = Post("updated", null, friendsOnly = true, ownerId = 2)
    WallService.add(postToUpdate)
    WallService.add(Post("first post", null))
    WallService.add(Post("second post", postToUpdate))
    WallService.add(Post("need to update", null))

    println(postToUpdate)

    WallService.update(Post(id = 1,text = "text updated", original = null))
    println(postToUpdate)


}