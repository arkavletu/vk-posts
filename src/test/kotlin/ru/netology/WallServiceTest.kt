package ru.netology

import org.junit.Test

import org.junit.Assert.*

class WallServiceTest {


    @Test
    fun add() {
        WallService.emptySingleton()

        val postForTest = Post("test")
        WallService.add(postForTest)

        val result = postForTest.id
        assertNotNull(result)


    }

    @Test
    fun updateReturnFalse() {
        WallService.emptySingleton()

        WallService.add(Post("test"))
        WallService.add(Post("another test"))

        val postToUpdate = Post("no thanks", id = 4)
        val result = WallService.update(postToUpdate)

        assertFalse(result)
    }

    @Test
    fun updateReturnTrue() {
        WallService.emptySingleton()

        WallService.add(Post("test"))
        WallService.add(Post("need to update"))

        val postToUpdate = Post("updated", id = 2)
        val result = WallService.update(postToUpdate)

        assertTrue(result)
    }

}