package test.scala

import org.specs2.mutable._

/**
 * コップ本のサンプルを書く場所。
 * (置くとこないので、ここに仮置き)
 * Created by kazuhito on 15/01/03.
 */
class SampleTest extends Specification {

  "本の序盤に載ってるサンプル" should {
    "1_1_マップの例" in {
      var capital = Map("US" -> "Washington" , "France" -> "Paris")
      capital += ("Japan" -> "Tokyo")
      println(capital("France"))
      capital.size must equalTo(3)
      capital("France") must equalTo("Paris")
    }

  }

}
