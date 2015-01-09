// コンストラクタに型パラメータを渡す例。
val big = new java.math.BigInteger("12345")
println(big)

// 配列のパラメータとして型を指定する例
val greetStrings = new Array[String](3)

greetStrings(0) = "Hello"
greetStrings(1) = ", " 
greetStrings(2) = "world!\n"  

for (i <- 0 to 2)
    print(greetStrings(i))
