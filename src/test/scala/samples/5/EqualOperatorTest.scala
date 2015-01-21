package samples

import org.specs2.mutable.Specification

class EqualOperatorTest extends Specification {

  "オブジェクトの等価性" should {

    "等号と不等号" in {
      1 == 2 must equalTo(false)
    }

  }

}