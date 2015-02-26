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

  "プリミティブ型の実装方法(11.2)" should {

    "Scalaではプリミティブとオブジェクトは極力意識しない" in {

      // Int型指定で等式
      def isEqualInt(x: Int, y: Int) = x == y

      isEqualInt(421, 421) must equalTo(true)

      // Int型以外で等式
      def isEqual(x: Any, y: Any) = x == y

      isEqual(421, 421) must equalTo(true)

    }

    "文字列型の==比較も意味ベースで比較" in {

      val x = "abcd".substring(2)
      val y = "abcd".substring(2)

      x == y must equalTo(true)

    }

  }

}
