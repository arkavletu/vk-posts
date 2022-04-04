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
        assertTrue(result != 0 && WallService.posts.isNotEmpty())
    }

    @Test
    fun addRepost() {
        WallService.emptySingleton()

        val postForTest = Post("test", null)
        WallService.add(postForTest)
        WallService.add(Post("second post", postForTest))

        val result = postForTest.id
        val reposts = postForTest.reposts
        assertTrue(result != 0 && reposts == 1)
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
    fun attachPostTest(){
        WallService.emptySingleton()

        WallService.add(Post("test",null))
        val photoTest: Attachment = Attachment.PhotoAttachment(Photo(22, 1, 65, 65,
            LocalDateTime.now(), null, null))
        WallService.attach(WallService.posts[0], photoTest)

        val result = WallService.posts[0].attachment.isNotEmpty()
        assertTrue(result)

    }

    @Test
    fun attachCommentTest(){
        WallService.emptySingleton()

        WallService.add(Post("test",null))


        WallService.createComment(Comment(23,3, text = "test comment",
            parentComment = null, parentPost = WallService.posts[0]))

        val photoTest: Attachment = Attachment.PhotoAttachment(Photo(22, 1, 65, 65,
            LocalDateTime.now(), null, null))
        WallService.attach(WallService.comments[0], photoTest)

        assertTrue(WallService.comments[0].attachment.isNotEmpty())

    }

    @Test(expected = PostOrCommentNotFoundException::class)
    fun attachError(){
        WallService.emptySingleton()

        WallService.add(Post("test",null))
        val notAPost = Event(22,"www","nothing")
        val photoTest: Attachment = Attachment.PhotoAttachment(Photo(22, 1, 65, 65,
            LocalDateTime.now(), null, null))
        WallService.attach(notAPost, photoTest)
    }

    @Test
    fun addComment(){
        WallService.emptySingleton()

        WallService.add(Post("test",null))
        WallService.add(Post("test2",null))

        val comment = Comment(12,2, LocalDateTime.now(),"nope",null,WallService.posts[1])
        WallService.createComment(comment)

        val added = WallService.createComment(Comment(23,3, text = "test comment",
            parentComment = comment, parentPost = null))



        assertTrue(added)

    }

    @Test(expected = PostOrCommentNotFoundException::class)
    fun addCommentError(){
        WallService.emptySingleton()

        WallService.add(Post("test",null))
        WallService.add(Post("test2",null))
        val postToComment = Post("updated", original = WallService.posts[0], id = 3)
        WallService.createComment(Comment(23,3, text = "test comment",
            parentComment = null, parentPost = postToComment))
    }

    @Test
    fun reportCommentTrue(){
        WallService.emptySingleton()

        WallService.add(Post("test",null))

        WallService.createComment(Comment(23,3, text = "test comment",
            parentComment = null, parentPost = WallService.posts[0]))

        WallService.reportComment(WallService.comments[0],2)

        assertTrue(WallService.comments[0].reports.isNotEmpty())
    }

}