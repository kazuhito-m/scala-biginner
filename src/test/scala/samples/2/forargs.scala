/**
 * コップ本2.6の例、for式
 * @param args
 */
object forargs {
  def main(args: Array[String]): Unit = {
    /*
    for (arg <- args)
      println(arg)
    */

    // 一行でもいけんかな？
    for (arg <- args) println(arg)

    // 特別記法も使え…ないみたいｗ （引数なしのprintln()連打になる）
    // for (arg <- args) println
  }
}