package ru.netology.attachment

import ru.netology.Post

abstract class Attachment() {
   abstract val type: String

   override fun toString(): String{
      return "\n\n$type"
   }





}