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
}

