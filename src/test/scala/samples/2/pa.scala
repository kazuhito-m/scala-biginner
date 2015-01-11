/**
 * コップ本2.6の例。
 */
object pa {
  def main(args: Array[String]): Unit = {
    // args.foreach(arg => println(arg))
    // きっちり書いた例
    // args.foreach((arg: String) => println(arg))
    // もっと簡易(特別な略記法)に書いた例。
    args.foreach(println)
 }
}