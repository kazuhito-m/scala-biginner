package samples

import org.specs2.mutable.Specification

class ScalaStractureTest extends Specification {

  "Scalaのクラス階層(11.1)" should {

    "Anyを継承している型の確認" in {
      42.toString must equalTo("42")
      42.hashCode must equalTo(42)
      42 must equalTo(42)
    }

    "AnyValの継承型Intの確認" in {
      42 max 43 must equalTo(43)
      42 min 43 must equalTo(42)
      1 until 5 must equalTo(Range(1, 5, 1))
      1 to 5 must equalTo(Range(1, 6, 1))
      3.abs must equalTo(3)
      (-3).abs must equalTo(3)
    }

  }

}
