package samples

import org.specs2.mutable.Specification

class BasicIntQueueTest extends Specification {

  "積み重ね可能な変更をそれぞれのトレイトで表現する(12.5)" should {

    "トレイト以前にのベーシックな実装のテスト" in {
      val queue = new BasicIntQueue
      queue.put(10)
      queue.put(20)
      queue.get() must equalTo(10)
      queue.get() must equalTo(20)
    }

    "積み重ねメソッドを実装するクラスを作成" in {
      val queue = new MyQueue
      queue.put(10)
      queue.get() must equalTo(20)
    }

    "クラス定義時ではなくnewインスタンス作成時にミックスイン" in {
      val queue = new BasicIntQueue with Doubling
      queue.put(10)
      queue.get() must equalTo(20)
    }

    "積み重ね可能な変更トレイトの二つをミックスイン" in {
      val queue = (new BasicIntQueue with Incrementing with Filtering)
      queue.put(-1); queue.put(0); queue.put(1)
      queue.get() must equalTo(1)
      queue.get() must equalTo(2)
    }

    "トレイトのミックスインの順序にて結果が変わる確認" in {
      val queue = (new BasicIntQueue with Filtering with Incrementing)
      queue.put(-1); queue.put(0); queue.put(1)
      queue.get() must equalTo(0)
      queue.get() must equalTo(1)
      queue.get() must equalTo(2)
    }

  }

}



