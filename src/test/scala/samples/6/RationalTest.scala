package samples

import org.specs2.mutable.Specification

class RationalTest extends Specification {

  /**
   * 標準出力をMockingsするためのトレイト。
   */
  trait MockOutput extends Output {
    var messages: Seq[String] = Seq()
    override def println(s: String) { messages = messages :+ s }
  }


  "Rationalクラスのテスト" should {

    "まずは作れること" in {
      val oneThirds = new Rational(1,2)
      oneThirds must not(equalTo(null))
    }



  }

}

