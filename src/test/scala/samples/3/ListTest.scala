import org.specs2.mutable._

/**
 * コップ本のサンプルを書く場所。
 */
class ListTest extends Specification {

  "コップ本「3.2リストを使う」に載ってるサンプル" should {

    "単純なリストの例" in {
      val oneTwoThree = List(1, 2, 3)
      oneTwoThree.size must equalTo(3)
    }

    "リスト同士の連結" in {
      val oneTwo = List(1, 2)
      val threeFour = List(3, 4)
      val oneTwoThreeFour = oneTwo ::: threeFour
      println("" + oneTwo + " and " + threeFour + " were not mutated.")
      println("Thus, " + oneTwoThreeFour + " is a new list.")

      val expected = List(1, 2, 3, 4)
      oneTwoThreeFour must equalTo(expected)
    }

    "要素とリストをconsでつないでリストを作成" in {
      val twoThree = List(2, 3)
      val oneTwoThree = 1 :: twoThree
      println(oneTwoThree)
      oneTwoThree must equalTo(List(1, 2, 3))
    }

    "consとNilでリストを生成する" in {
      val oneTwoThree = 1 :: 2 :: 3 :: Nil
      println(oneTwoThree)
      oneTwoThree must equalTo(List(1, 2, 3))
    }

  }
}

