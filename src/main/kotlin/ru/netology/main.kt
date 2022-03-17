package ru.netology

import ru.netology.attachment.*



fun main() {
   val postToUpdate = Post("updated",null, friendsOnly = true, ownerId = 2)
   WallService.add(postToUpdate)
  WallService.add(Post("first post",null))
   WallService.add(Post("second post",postToUpdate))
   WallService.add(Post("need to update",null))




    val photoTest = Photo(1,1,1,3, text = "text", albumId = 0)
    val noteTest = Note(43,1,"do homework")
    WallService.attach(WallService.posts[2], PhotoAttachment(photoTest))
    WallService.attach(WallService.posts[2],NoteAttachment(noteTest))
    println(WallService.posts[2])
    //println(photoTest)
//  // println(WallService.update(postToUpdate))








}