package samples

import scala.collection.mutable.Map

// まずコンパニオンクラス
class ChecksumAccumlator {
  private var sum = 0
  def add(b:Byte) { sum += b }
  def checksum(): Int = ~(sum & 0xFF) + 1
}

// 次にシングルトンオブジェクト
object ChecksumAccumlator {
  private val cache = Map[String,Int]()
  def calculate(s:String): Int =
    if (cache.contains(s))
      cache(s)
    else {
      val acc = new ChecksumAccumlator
      for (c <- s)
        acc.add(c.toByte)
      val cs = acc.checksum()
      cache += (s -> cs)
      cs
    }
}
