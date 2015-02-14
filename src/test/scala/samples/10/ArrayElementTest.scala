package samples

import org.specs2.mutable.Specification

class ArrayElementTest  extends Specification {

  "クラスの拡張(10.4)" should {

    "継承のテスト" in {
      val ae = new ArrayElement(Array("Hello","World"))
      ae.width must equalTo(5)
    }

    "必要に応じて継承先のクラスの値が参照される" in {
      val e: Element = new ArrayElement(Array("Hello"))
      e.width must equalTo(5)
    }

  }

}
