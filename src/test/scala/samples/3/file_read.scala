import scala.io.Source

/**
 * ファイルからテキストを読み込む例。
 *
 */
object file_read {
  /**
     * コップ本3.6ファイルがあら行を読み出すの例。
   * @param args
   */
  def main(args: Array[String]): Unit = {
    // ファイルを読み出し、プリントする。
    fileRead01(args)
  }

  /**
   * 一つ目の例。
   * @param args
   */
  def fileRead01(args: Array[String]): Unit = {
    if (args.length > 0) {
      for (line <- Source.fromFile(args(0)).getLines())
        println(line.length + " " + line)
    }
    else
      Console.err.println("Please enter filename")
  }
}