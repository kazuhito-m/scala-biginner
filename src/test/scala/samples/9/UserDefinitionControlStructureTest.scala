package samples

import org.specs2.mutable.Specification
import java.io.{PrintWriter, File}
import scala.io.Source

class UserDefinitionControlStructureTest extends Specification {

  "新しい制御構造を作る(9.4)" should {

    "自分で定義した構造" in {

      // 指定された関数を二回呼ぶ関数
      def twice(op: Double => Double , x: Double) = op(op(x))

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

}
