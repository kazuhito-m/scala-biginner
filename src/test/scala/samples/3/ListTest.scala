import org.specs2.mutable._

/**
 * コップ本のサンプルを書く場所。
 */
class ListTest extends Specification {

  "コップ本「3.2リストを使う」に載ってるサンプル" should {
    "単純なリストの例" in {
      val oneTwoThree = List(1,2,3)
      oneTwoThree.size must equalTo(3)
    }

  }
}

