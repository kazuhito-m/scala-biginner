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
        new File("test.txt"),
        writer => writer.println("Test text.")
      )

      val actual = Source.fromFile("test.txt").getLines.reduceLeft(_ + _)
      (new File("test.txt")).delete

      actual must equalTo("Test text.")

    }

  }

}
