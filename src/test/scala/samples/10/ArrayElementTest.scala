package samples

import org.specs2.mutable.Specification

class ArrayElementTest  extends Specification {

  "クラスの拡張(10.4)" should {

    "継承のテスト" in {

      val ae = new ArrayElement(Array("Hello","World"))

      ae.width must equalTo(5)

    }

  }

}
