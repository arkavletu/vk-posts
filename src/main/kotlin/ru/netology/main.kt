package ru.netology


fun main() {
    val postToBeOriginal = Post("updated", null, friendsOnly = true, ownerId = 2)
    WallService.add(postToBeOriginal)
    WallService.add(Post("first post", null))
    WallService.add(Post("second post", postToBeOriginal))
    WallService.add(Post("need to update", null))


    println(WallService.posts[2])


}