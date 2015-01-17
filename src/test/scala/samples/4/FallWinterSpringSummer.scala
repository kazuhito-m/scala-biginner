package samples

import samples.ChecksumAccumlator.calculate

object FallWinterSpringSummer extends App {
  for (season <- List("fall" , "winter" , "spling"))
    println(season + ": " + calculate(season))

}
