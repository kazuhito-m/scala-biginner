package samples

import org.specs2.mutable.Specification

class RationalTest extends Specification {

  "Rationalクラスのテスト" should {

    "まずは作れること" in {
      val oneThirds = new Rational(1,2)
      oneThirds must not(equalTo(null))
    }

  }

}