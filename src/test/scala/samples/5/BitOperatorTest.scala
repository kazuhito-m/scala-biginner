package samples

import org.specs2.mutable.Specification

class BitOperatorTest extends Specification {

  "ビットシフト演算子" should {

    "ビット単位の比較演算" in {
      1 & 2 must equalTo(Int.box(0))
      1 | 2 must equalTo(Int.box(3))
      1 ^ 3 must equalTo(Int.box(2))
      ~1 must equalTo(Int.box(-2))
    }

    "右ビットシフトでIntの再下位まで移動(シフトしたところに１を入れていく)" in {
      -1 >> 31 must equalTo(Int.box(-1))
    }

    "右ビットシフトでIntの再下位まで移動(シフトしたところに0を入れていく)" in {
      -1 >>> 31 must equalTo(Int.box(+1))
    }

    "左ビットシフトでIntで2bitシフト移動(シフトしたところに0を入れていく)" in {
      1 << 2 must equalTo(Int.box(4))
    }

  }

}