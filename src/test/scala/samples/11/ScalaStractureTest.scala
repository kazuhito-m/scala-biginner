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
      val y = "efcd".substring(2)

      x == y must equalTo(true)

    }

    "参照を比較するメソッド" in {

      val x = new String("abc")
      val y = new String("abc")

      x == y must equalTo(true)

      x eq y must equalTo(false)

      x ne y must equalTo(true)

    }

  }

  "最下位(bottom)の二つの型(11.3)" should {
    "Nothingの使い所" in {

      // NothingならIF文の判定に、例えばIntだとしても突っ込める
      def error(message: String) : Nothing = throw new RuntimeException(message)

      def divide(x: Int,  y: Int): Int =
        if (y != 0) x / y
        else error("can't divide by zero")

      // 上記のコードは、実際に動く
      divide(4,2) must equalTo(2)
      (divide(4,0)) must throwA[RuntimeException]

    }
  }

}
