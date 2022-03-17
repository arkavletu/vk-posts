package ru.netology

import org.junit.Assert.*
import org.junit.Test
import ru.netology.attachment.*
import ru.netology.attachment.Photo

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
        val photoTest = Photo(1, 1, 1, 3, text = "text", albumId = 0)
        WallService.attach(WallService.posts[0], PhotoAttachment(photoTest))

        val result = WallService.posts[0].attachment.isNotEmpty()
        assertTrue(result)

    }

}