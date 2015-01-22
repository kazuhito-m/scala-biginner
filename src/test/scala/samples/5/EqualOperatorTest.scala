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

  }

}