package samples

import org.specs2.mutable.Specification

class EqualOperatorTest extends Specification {

  "オブジェクトの等価性" should {

    "等号と不等号" in {
      1 == 2 must equalTo(false)
      1 != 2 must equalTo(true)
      2 == 2 must equalTo(true)
    }

    "オブジェクトの比較での等号" in {
      List(1, 2, 3) == List(4, 5, 6) must equalTo(false)
      List(1, 2, 3) == List(1, 2, 3) must equalTo(true)
    }

  }

}