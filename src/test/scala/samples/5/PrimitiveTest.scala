package samples

import org.specs2.mutable.Specification

class PrimitiveTest extends Specification {

  "プリミティブ型のメソッドの扱いについての色々" in {

    // 中置演算子はメソッドなので、メソッド型としても書ける。
    val value1 = 1 * 3
    val value2 = (1).*(3)

    value1 must equalTo(value2)

  }

}
