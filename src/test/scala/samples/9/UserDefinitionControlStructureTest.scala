package samples

import org.specs2.mutable.Specification

class UserDefinitionControlStructureTest extends Specification {

  "新しい制御構造を作る(9.4)" should {

    "自分で定義した構造" in {

      // 指定された関数を二回呼ぶ関数
      def twice(op: Double => Double , x: Double) = op(op(x))

      val actual = twice(_ + 1, 5)

      actual must equalTo(7)

    }

  }

}
