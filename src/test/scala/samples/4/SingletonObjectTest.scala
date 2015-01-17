package samples

import org.specs2.mutable.Specification
import scala.collection.mutable.Map

/**
 * コップ本4.3のサンプル
 */
class SingletonObjectTest extends Specification {

    "ChecksumAccumlatorクラスとChecksumAccumlatorシングルトンオブジェクト" in {

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

      // まず一度目。
      val checkTarget = "Every value is an object."
      ChecksumAccumlator.calculate(checkTarget) must equalTo(-248)

      // それ以降も同じ値を返す。（キャッシュされているからそっから結果を出している…はず)
      ChecksumAccumlator.calculate(checkTarget) must equalTo(-248)
      ChecksumAccumlator.calculate(checkTarget) must equalTo(-248)

    }

  }