// コンストラクタに型パラメータを渡す例。
val big = new java.math.BigInteger("12345")
println(big)

// 配列のパラメータとして型を指定する例
val greetStrings = new Array[String](3)

greetStrings(0) = "Hello"
greetStrings(1) = ", " 
greetStrings(2) = "world!\n"  

// greetStringsは「代入不可」だが、要素の(1)には「再度代入可」である証明。
greetStrings(0) = "Happy!"

// for (i <- 0 to 2)
for (i <- (0).to(2)) // こうとも書ける。
    // print(greetStrings(i))
    Console print greetStrings.apply(i) // これも別の書き方
