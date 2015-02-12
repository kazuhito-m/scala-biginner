package samples

import org.specs2.mutable.Specification
import java.io.{PrintWriter, File}
import scala.io.Source

class UserDefinitionControlStructureTest extends Specification {

  "新しい制御構造を作る(9.4)" should {

    "自分で定義した構造" in {

      // 指定された関数を二回呼ぶ関数
      def twice(op: Double => Double, x: Double) = op(op(x))

      val actual = twice(_ + 1, 5)

      actual must equalTo(7)

    }

    val test_file_name = "test.txt"
    val test_file_text = "Test text."

    "初期処理と終了処理を面倒見る制御構造を作る" in {

      def withPrintWriter(file: File, op: PrintWriter => Unit) {
        val writer = new PrintWriter(file)
        try {
          op(writer)
        } finally {
          writer.close()
        }
      }

      withPrintWriter(
        new File(test_file_name),
        writer => writer.println(test_file_text)
      )

      val actual = Source.fromFile(test_file_name).getLines.reduceLeft(_ + _)
      (new File(test_file_name)).delete

      actual must equalTo(test_file_text)

    }


    "ローンパターンを使った制御構造(カリー化適用後)" in {

      def withPrintWriter(file: File)(op: PrintWriter => Unit) {
        val writer = new PrintWriter(file)
        try {
          op(writer)
        } finally {
          writer.close()
        }
      }

      val f = new File(test_file_name)

      withPrintWriter(f) {
        writer => writer.println(test_file_text)
      }

      val actual = Source.fromFile(test_file_name).getLines.reduceLeft(_ + _)
      (new File(test_file_name)).delete

      actual must equalTo(test_file_text)

    }

  }

  "名前渡しパラメーター(9.5)" should {

    "アサーションのための制御構造の実装" in {
      // アサーション関数の定義
      var assertionEnabled = true
      def myAssert(predicate: () => Boolean) =
        if (assertionEnabled && !predicate())
          throw new AssertionError

      // myAssert(5 > 3) こう書きたい…のだが
      myAssert(() => 5 > 3)

      // フラグOFF中
      assertionEnabled = false
      myAssert(() => 5 < 3)

      // フラグONで偽のもの
      assertionEnabled = true
      (myAssert(() => 5 < 3)) must throwA[AssertionError]
    }

    "名前渡しパラメーターを使ったアサーションのための制御構造" in {
      // 名前渡しパラメータを使ってのアサーション構文
      var assertionEnabled = true
      def byNameAssert(predicate: => Boolean) =
        if (assertionEnabled && !predicate)
          throw new AssertionError

      byNameAssert(5 > 3)

      // フラグOFF中
      assertionEnabled = false
      byNameAssert(5 < 3)

      // フラグONで偽のもの
      assertionEnabled = true
      (byNameAssert(5 < 3)) must throwA[AssertionError]
    }


    "関数でなく計算後の真偽値をそのまま渡すアサーションと関数を渡す奴との違い" in {
      // 関数でなく計算後の真偽値をそのまま渡す形のアサート関数
      var assertionEnabled = false
      def boolAssert(predicate: Boolean) =
        if (assertionEnabled && !predicate)
          throw new AssertionError

      // 前の関数
      def byNameAssert(predicate: => Boolean) =
        if (assertionEnabled && !predicate)
          throw new AssertionError

      // フラグOFF中
      // 関数渡しのほうはフラグOFFなので関数の実行されないのでエラー無く終わる
      byNameAssert(1 / 0 == 0)
      // 値渡しのほうは、関数へ行く前にエラーが起こる
      (boolAssert(1 / 0 == 0)) must throwA[ArithmeticException]

      // おまけ
      assertionEnabled = true
      assertionEnabled must equalTo(true)
    }

  }

}