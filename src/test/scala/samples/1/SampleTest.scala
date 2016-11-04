package test.scala

import org.specs2.mutable._

import scala.collection.immutable.HashMap

/**
  * コップ本のサンプルを書く場所。
  * (置くとこないので、ここに仮置き)
  * Created by kazuhito on 15/01/03.
  */
class SampleTest extends Specification {

  "本の序盤に載ってるサンプル" should {
    "1_1_マップの例" in {
      var capital = Map("US" -> "Washington", "France" -> "Paris")
      capital += ("Japan" -> "Tokyo")
      println(capital("France"))
      capital.size must equalTo(3)
      capital("France") must equalTo("Paris")
    }

    "1_1_1_BigIntの例" in {
      def factorial(x: BigInt): BigInt =
        if (x == 0) 1 else x * factorial(x - 1)
      val actual = factorial(30)
      actual.toString() must equalTo("265252859812191058636308480000000")
    }

    "1_3_2_簡潔性の例" in {
      class MyClass(index: Int, name: String)
      // オブジェクトを作成してみる。
      val actual = new MyClass(9, "わたしだ")
      actual must not equalTo (null)
      // private のフィールドはやっぱ取得メソッド装備しないと無理か。
    }

    "1_3_3_抽象度の高いコードの例" in {
      val name = "KazuhitoMiura"
      val nameHasUpperCase = name.exists(_.isUpper)
      nameHasUpperCase must equalTo true

      val hasNotUpper = "miurakazuhito"
      val nameHasUpperCase2 = hasNotUpper.exists(_.isUpper)
      nameHasUpperCase2 must not equalTo true
    }

    "1_3_4_ドキュメント性の例" in {
      // 冗長にもかけるし…
      val x: HashMap[Int, String] = new HashMap[Int, String]()
      // 自明であれば短くもかける。
      val y = new HashMap[Int, String]()
      val z: Map[Int, String] = new HashMap()
      // 申し訳程度の確認
      y.getClass.getName must equalTo("scala.collection.immutable.HashMap")
      z.getClass.getName must equalTo("scala.collection.immutable.HashMap")
    }

  }

}
