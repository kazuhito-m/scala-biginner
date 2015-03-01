package samples

import org.specs2.mutable.Specification

class FrogTest extends Specification {

  "トレイトの仕組み(12.1)" should {

    "トレイトのExtends時の動き" in {
      val frog = new Flog
      // 継承元トレイトのメソッドも呼べるし
      frog.philosophize()
      // 勿論「自身クラスの特徴」も保持している
      frog.toString must equalTo("green")
      // 別の型にキャスト
      val phil: Philosophical = frog
      // 無論継承元であるこの型のメソッドは呼べるのは当たり前。
      phil.philosophize()
      // 同じメソッドをよんでも「インスタンス側の性質」で呼び出される。
      phil.toString must equalTo("green")
    }

    "ミックスインしたトレイトのメソッドもオーバーライド出来る" in {
      val phrog = new Flog2
      phrog.toString must equalTo("green")
      phrog.say() must equalTo("It ain't easy being green!")
    }

  }

}