package ru.netology.attachment

import ru.netology.Post

abstract class Attachment() {
   abstract val type: String
   abstract val objectType: Any

   override fun toString(): String{
      return "\n$type, ${objectType.toString()}"
   }





}