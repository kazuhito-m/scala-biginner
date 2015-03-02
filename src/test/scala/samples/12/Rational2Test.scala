package samples

import org.specs2.mutable.Specification

class Rational2Test extends Specification {

  "Orderdトレイト(12.4)" should {

    "Orderdトレイトを装備するだけで比較が可能になる" in {
      val half = new Rational2(1, 2)
      val third = new Rational2(1,3)

      half < third must equalTo(false)
      half > third must equalTo(true)
    }

  }

}



