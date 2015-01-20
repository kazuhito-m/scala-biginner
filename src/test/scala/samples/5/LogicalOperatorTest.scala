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

    "含むの不等号の比較" in {
      val value = 1.0 <= 1.0
      value must equalTo(true)
      val value2 = 3.5f >= 3.6f
      value2 must equalTo(false)
    }

    "文字型での比較" in {
      val value = 'a' >= 'A'
      value must equalTo(true)
    }

    "否定の論理演算子" in {
      val value = !true
      value must equalTo(false)
    }

  }

  "論理演算子" should {

    "論理和" in {
      val toBe = true
      toBe must equalTo(true)
      // or条件
      val question = toBe || !toBe
      question must equalTo(true)
    }


    "論理積" in {
      val toBe = true
      toBe must equalTo(true)
      // or条件
      val paradox = toBe && !toBe
      paradox must equalTo(false)
    }

  }

}