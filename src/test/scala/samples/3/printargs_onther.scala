/**
 * コンソール引数に指定された文字を、開業しながら出す…の命令形（非関数型）版。
 */
object type_parameter {
  def main(args: Array[String]): Unit = {
    var i = 0
    while (i < args.length) {
      println(args(i))
      i += 1
    }
  }
}
