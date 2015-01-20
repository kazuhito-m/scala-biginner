package samples

import org.specs2.mutable.Specification

class PrimitiveTest extends Specification {

  "プリミティブ型のメソッドの扱いについての色々" in {

    // 中置演算子はメソッドなので、メソッド型としても書ける。
    val value1 = 1 * 3
    val value2 = (1).*(3)

    value1 must equalTo(value2)

  }

  "算術演算子例" in {

    // Doubleに成る場合
    val value1 = 1.2 + 2.3
    value1 must equalTo(Double.box(3.5d))

    // Intに成る場合
    val value2 = 3 - 1
    value2 must equalTo(Int.box(2))

  }

}
