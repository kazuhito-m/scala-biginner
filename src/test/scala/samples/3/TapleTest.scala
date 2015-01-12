import org.specs2.mutable._

/**
 * コップ本のサンプルを書く場所。
 */
class TapleTest extends Specification {

  "コップ本「3.2タプルを使う」に載ってるサンプル" should {

    "タプルを作って使う" in {
      val pair = (99, "Luftballons")
      pair._1 must equalTo(99)
      pair._2 must equalTo("Luftballons")
    }

  }

  "コップ本「3.4集合とMapを使う」に載ってるサンプル" should {

    "イミュータブルな集合の作成・初期化・操作" in {
      var jetSet = Set("Boeing", "Arirbus")
      jetSet += "Lear"
      println(jetSet.contains("Cessna"))
      jetSet.contains("Cessna") must equalTo(false)
    }

    "ミュータブルな集合の作成・初期化・操作" in {
      import scala.collection.mutable.Set
      val movieSet = Set("Hitch", "Poltergeist")
      // 実際は下のメソッドが呼ばれている。
      // val movieSet = Set.apply("Hitch", "Poltergeist")
      movieSet += "Shrek"
      println(movieSet)
      movieSet must equalTo(Set("Poltergeist", "Shrek", "Hitch"))
    }
  }
}

