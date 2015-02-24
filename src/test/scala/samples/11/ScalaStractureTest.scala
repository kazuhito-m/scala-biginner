package samples

import org.specs2.mutable.Specification

class ScalaStractureTest extends Specification {

  "Scalaのクラス階層(11.1)" should {

    "Anyを継承している型の確認" in {
      42.toString must equalTo("42")
      42.hashCode must equalTo(42)
      42 must equalTo(42)
    }

  }

}
