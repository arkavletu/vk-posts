package ru.netology



fun main() {

   println( WallService.add(Post("first post")))
   println( WallService.add(Post("second post")))
   println(WallService.add(Post("need to update")))



   val postToUpdate = Post("updated", friendsOnly = true, likes = 1, id = 6)

   println(WallService.update(postToUpdate))








}