package samples

import org.specs2.mutable.Specification

class OperatorTest extends Specification {

  "演算子とその演算で決まる左辺型" should {

    "Doubleに成る場合" in {
      val value = 1.2 + 2.3
      value must equalTo(Double.box(3.5d))
    }

    "Intに成る場合" in {
      val value = 3 - 1
      value must equalTo(Int.box(2))
    }

    "Longになる場合" in {
      val value = 2L * 3L
      value must equalTo(Long.box(6L))
    }

    "Intで除算の場合" in {
      val value = 11 / 4
      value must equalTo(Int.box(2))
    }

    "Intで剰余算の場合" in {
      val value = 11 % 4
      value must equalTo(Int.box(3))
    }

    "Floatの除算の場合" in {
      val value = 11.0f / 4.0f
      value must equalTo(Float.box(2.75f))
    }

    "小数点の除算だがDoubleになる場合" in {
      val value = 11.0 % 4.0
      value must equalTo(Double.box(3.0))
    }

  }

  "特殊な演算" should {

    "IEEE754による計算" in {
      val value = Math.IEEEremainder(11.0, 4.0)
      value must equalTo(Double.box(-1.0))
    }

  }

  "単項前置演算子" should {
    "unary_-メソッドの例" in {
      val value = 1 + -3
      value must equalTo(Int.box(-2))
      // 前置演算子を自分で書く例。
      val value2 = 1 + 3.unary_-
      value2 must equalTo(Int.box(-2))
    }

    "unary_+メソッドの例" in {
      val value = +3
      value must equalTo(Int.box(3))
      // 前置演算子を自分で書く例。
      val value2 = 3.unary_+
      value2 must equalTo(Int.box(3))
    }

  }

}
