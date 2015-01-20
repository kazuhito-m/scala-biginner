package samples

import org.specs2.mutable.Specification

class LogicalOperatorTest extends Specification {

  "関係演算子" should {

    "不等号の比較" in {
      val value = 1 > 2
      value must equalTo(false)
      // メソッドとして呼ぶ
      val value2 = (1).>(2)
      value2 must equalTo(false)
    }

    "不等号の比較その２" in {
      val value = 1 < 2
      value must equalTo(true)
      // メソッドとして呼ぶ
      val value2 = (1).<(2)
      value2 must equalTo(true)
    }

  }

}
