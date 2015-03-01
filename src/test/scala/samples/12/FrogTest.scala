package samples

import org.specs2.mutable.Specification

class FrogTest  extends Specification {

  "トレイトの仕組み(12.1)" should {
    "トレイトのExtends時の動き" in {
      val frog = new Flog
      frog.toString must equalTo("green")
    }
  }

}