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
    fileRead02(args)
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

  /**
   * 引数の文字列の文字数をカウント…した桁数を返す。
   * @param s 文字数を数える対象の文字列。
   * @return 文字列を数えた数値の桁数(例えば10文字なら2)
   */
  def widthOfLength(s: String) = s.length.toString.length

  /**
   * 二つ目の例。
   * @param args
   */
  def fileRead02(args: Array[String]): Unit = {
    if (args.length > 0) {
      val lines = Source.fromFile(args(0)).getLines().toList
      // linesに格納されている文字列中「一番長いもの」の文字列を取得。
      val longsLine = lines.reduceLeft(
        (a,b) => if (a.length > b.length) a else b
      )
      // 一番長かった文字列の文字数を取得。
      val maxLength = widthOfLength(longsLine)
      // 全行書き出し
      for (line <- lines) {
        // 最大の桁数引く現在の行の桁数（空白を詰める回数を算出）
        val numSpaces = maxLength - widthOfLength(line)
        val padding = " " * numSpaces
        println(padding + line.length + " | " + line)
      }
    }
    else
      Console.err.println("Prease enter filename")
  }
}