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

  }

}



