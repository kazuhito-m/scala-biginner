/**
 * コンソール引数に指定された文字を、開業しながら出す…の関数型ワンライナー版。
 */
object printaargs_other2 {
  def formatArgs(args: Array[String]) = args.mkString("\n")
  def main(args: Array[String]): Unit = {
    println(formatArgs(args))  
  }
}
