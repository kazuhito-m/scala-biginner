package samples

import org.specs2.mutable.Specification

class RichWrapperTest extends Specification {

  "リッチラッパー" should {

    "最大と最小" in {
      0 max 5 must equalTo(5)
      0 min 5 must equalTo(0)
    }

    "絶対値" in {
      // こうは書けないみたい-2.7 abs must equalTo(2.7)
      (-2.7 abs) must equalTo(2.7)
      (-2.7).abs must equalTo(2.7)
    }

    "四捨五入？" in {
      // 切り捨て
      (-2.7 round) must equalTo(-3L)
      -2.7.round must equalTo(-3L)
      // 切り上げ
      (1.51 round) must equalTo(2)
    }

    "ゼロ割（無限）判定" in {
      // 無限に鳴らない例
      (1.5 isInfinity) must equalTo(false)
      1.5.isInfinity must equalTo(false)
      // ゼロ割の例
      ((1.0 / 0) isInfinity) must equalTo(true)
      (1.0 / 0).isInfinity must equalTo(true)
    }

    "範囲の扱い" in {
      (4 to 6).toList must equalTo(List(4 , 5 ,6))
    }

    "アメリカンな名前変換則(頭文字を大文字にする)" in {
      ("bob" capitalize) must equalTo("Bob")
      ("bob").capitalize must equalTo("Bob")
    }

    "先頭文字削り" in {
      "robert" drop 2 must equalTo("bert")
      "robert".drop(2) must equalTo("bert")
    }

  }

}
