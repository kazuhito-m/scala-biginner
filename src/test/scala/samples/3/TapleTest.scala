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

    "集合クラスを具体的に指定したい場合" in {
      import scala.collection.immutable.HashSet
      val hashSet = HashSet("Tomatoes", "Chileies")
      println(hashSet + "Coriander")
      hashSet.size must equalTo(2)
    }

    "ミュータブルマップの作成・初期化・操作" in {
      import scala.collection.mutable.Map
      val tresureMap = Map[Int, String]()
      tresureMap += (1 -> "Got to island")
      tresureMap += (2 -> "Find big X on ground.")
      tresureMap += (3 -> "Dig.")
      tresureMap(2) must equalTo("Find big X on ground.")
    }

    "イミュータブルマップの作成・初期化・操作" in {
      val romanNumeral = Map(
        1 -> "i", 2 -> "ii", 3 -> "iii", 4 -> "iv", 5 -> "v"
      )
      romanNumeral(4) must equalTo("iv")
    }
  }
}

