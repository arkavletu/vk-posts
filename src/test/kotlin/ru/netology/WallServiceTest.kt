package ru.netology

import org.junit.Assert.*
import org.junit.Test
import java.time.LocalDateTime


class WallServiceTest {


    @Test
    fun add() {
        WallService.emptySingleton()

        val postForTest = Post("test", null)
        WallService.add(postForTest)

        val result = postForTest.id
        assertNotNull(result)


    }

    @Test
    fun updateReturnFalse() {
        WallService.emptySingleton()

        WallService.add(Post("test", null))
        WallService.add(Post("another test", null))

        val postToUpdate = Post("no thanks", null, id = 4)
        val result = WallService.update(postToUpdate)

        assertFalse(result)
    }

    @Test
    fun updateReturnTrue() {
        WallService.emptySingleton()

        WallService.add(Post("test",null))
        WallService.add(Post("need to update",null))

        val postToUpdate = Post("updated", original = WallService.posts[0], id = 2)
        val result = WallService.update(postToUpdate)

        assertTrue(result)
    }
    @Test
    fun attachTest(){
        WallService.emptySingleton()

        WallService.add(Post("test",null))
        val photoTest: Attachment = Attachment.PhotoAttachment(Photo(22, 1, 65, 65,
            LocalDateTime.now(), null, null))
        WallService.attach(WallService.posts[0], photoTest)

        val result = WallService.posts[0].attachment.isNotEmpty()
        assertTrue(result)

    }

    @Test
    fun addComment(){
        WallService.emptySingleton()

        WallService.add(Post("test",null))

        WallService.createComment(Comment(23,3, text = "test comment",
            parentComment = null, parentPost = WallService.posts[0]))

        val result = WallService.comments

        assertTrue(result.isNotEmpty())

    }

    @Test(expected = PostOrCommentNotFoundException::class)
    fun addCommentError(){
        WallService.emptySingleton()

        WallService.add(Post("test",null))
        val postToComment = Post("updated", original = WallService.posts[0], id = 2)
        WallService.createComment(Comment(23,3, text = "test comment",
            parentComment = null, parentPost = postToComment))
    }

}