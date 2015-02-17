package samples

import org.specs2.mutable.Specification

class ArrayElementTest extends Specification {

  "クラスの拡張(10.4)" should {

    "継承のテスト" in {
      val ae = new ArrayElement(Array("Hello", "World"))
      ae.width must equalTo(5)
    }

    "必要に応じて継承先のクラスの値が参照される" in {
      val e: Element = new ArrayElement(Array("Hello"))
      e.width must equalTo(5)
    }

  }

  "メソッドとフィールドのオーバーライド(10.5)" should {
    "フィールドでメソッドをオーバーライドしてみる" in {
      val e: Element = new ArrayElement2(Array("Hello"))
      e.width must equalTo(5)
    }
  }

  "パラメーターフィールドの定義(10.6)" should {
    "コンストラクタとフィールドとなんやかんやを一緒にした略記法で同じの書く" in {
      val e: Element = new ArrayElement3(Array("Hello"))
      e.width must equalTo(5)
    }
  }

  "スーパークラスコンストラクターの呼び出し(10.7)" should {
    "オーバーライドされた別型の引数のコンストラクタを呼び出してインスタンス化" in {
      val e: Element = new LineElement("Hello")
      e.width must equalTo(5)
    }
  }

  "多相性と動的束縛(10.9)" should {
    "指定した文字を敷き詰めるクラスを定義する" in {
      val e: Element = new UniformElement('x',5,3)
      val actual = e.contents
      actual.length must equalTo(3)
      actual(0) must equalTo("xxxxx")
      actual(1) must equalTo("xxxxx")
      actual(2) must equalTo("xxxxx")
    }
  }

}
