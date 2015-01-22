package samples

import org.specs2.mutable.Specification

class RichWrapperTest extends Specification {
  "リッチラッパー" should {
    "最大と最小" in {
      0 max 5 must equalTo(5)
      0 min 5 must equalTo(0)
    }
  }
}