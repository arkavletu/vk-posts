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
    fun attachTest(){
        WallService.emptySingleton()

        WallService.add(Post("test",null))
        val photoTest: Attachment = Attachment.PhotoAttachment(Photo(22, 1, 65, 65,
            LocalDateTime.now(), null, null))
        WallService.attach(WallService.posts[0], photoTest)

        val result = WallService.posts[0].attachment.isNotEmpty()
        assertTrue(result)

    }

}