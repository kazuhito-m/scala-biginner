package samples

import org.specs2.mutable.Specification

class OperatorsPrecedenceTest extends Specification {

  "演算子の優先順位" should {

    "和と積" in {
      (2 + 2) * 7 must equalTo(28)
    }

    "不等号始まりよりプラマイの方が優先される" in {
      2 << 2 + 2 must equalTo(32)
    }

    "不等号始まりよりプラマイの方が優先されるその２" in {
      2 + 2 << 2 must equalTo(16)
    }

    "代入演算子は比較演算子より優先度は低くなる" in {
      val y = 3
      var x = 4
      x *= y + 1
      x must equalTo(16)
    }

  }

}