/**
 * コンストラクタに型パラメータを渡す例。
 */
object type_parameter {
  def main(args: Array[String]): Unit = {
    val big = new java.math.BigInteger("12345")
    println(big)

    // 配列のパラメータとして型を指定する例
    val greetStrings = new Array[String](3)

    greetStrings(0) = "Hello"
    greetStrings(1) = ", "
    greetStrings(2) = "world!\n"

    // greetStringsは「代入不可」だが、要素の(1)には「再度代入可」である証明。
    greetStrings(0) = "Happy!"
    // 上記の書き方が「省略形」を使っており、本当はこちらのほうが「展開系」である、という例。
    greetStrings.update(2, "Life\n")

    // for (i <- 0 to 2)
    for (i <- (0).to(2)) // こうとも書ける。
    // print(greetStrings(i))
      Console print greetStrings.apply(i) // これも別の書き方

    // 配列の作成例
    val numNames = Array("zero", "one", "two", "three")
    val numNames2 = Array.apply("zero", "one", "two", "three")

    println(numNames)
    println(numNames2)
  }
}