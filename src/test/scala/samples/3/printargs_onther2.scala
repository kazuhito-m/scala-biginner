import org.specs2.mutable.Specification

/**
 * コンソール引数に指定された文字を、開業しながら出す…の関数型ワンライナー版。
 */
object printaargs_other2 {
  def formatArgs(args: Array[String]) = args.mkString("\n")

  def main(args: Array[String]): Unit = {
    println(formatArgs(args))
  }
}

class PrintArgsTest extends Specification {

  "コップ本「3.5関数型のスタイルが見分ける」に載ってるサンプル" should {
    "関数型アプローチになるとテストできるのでテストする" in {
      val param = Array("1", "2", "3", "end")
      printaargs_other2.formatArgs(param) must equalTo("1\n2\n3\nend")
    }
  }

}

