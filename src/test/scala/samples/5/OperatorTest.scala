package samples

import org.specs2.mutable.Specification

class OperatorTest  extends Specification {

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

}
