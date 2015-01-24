package samples

import org.specs2.mutable.Specification

class RationalTest extends Specification {

  "Rationalクラスのテスト" should {

    "まずは作れること" in {
      val oneThirds = new Rational(1,2)
      oneThirds must not(equalTo(null))
    }

    "標準出力に出力していること" in {
      // 準備っとして、標準出力ぶん取っとく。
      val stream = new java.io.ByteArrayOutputStream()
      Console.setOut(stream)

      // 作成
      val sut = new Rational(1,2)

      // 標準出力をアサーション
      val actual = stream.toString ; stream.close()
      actual must equalTo("Created 1 / 2\n")
    }

  }

}

