package samples

import org.specs2.mutable.Specification
import java.io.{IOException, FileNotFoundException, File}
import java.io
import java.net.{MalformedURLException, URL}

// いっちょ前の関数
class FirstclassFanctionsTest extends Specification {

  "一人前の存在としての関数(8.3の内容)" should {

    "値としての関数(function values)" in {
      var increase = (x: Int) => x + 1
      increase(10) must equalTo(11)
      // 変数なので、上書きもOK
      increase = (x: Int) => x + 9999
      increase(10) must equalTo(10009)
    }

    "ワンライナーでなく、処理を持つ場合" in {
      val increase = (x: Int) => {
        println("We")
        println("are")
        println("here!")
        x + 1
      }

      increase(10) must equalTo(11)

    }

    "フィルターに関数を放り込む例" in {
      // 個々の値をほかに副作用させる例
      val someNumbers = List(-11, -10, -5, 0, 5, 10)
      var sum = 0
      someNumbers.foreach((x: Int) => sum += x)
      sum must equalTo(-11)
      // 絞り込みの例
      val actual = someNumbers.filter((x: Int) => x > 0)
      actual must equalTo(List(5, 10))
    }

  }

  "関数リテラルの短縮形(8.4の内容)" should {

    "短縮形" in {
      val someNumbers = List(-11, -10, -5, 0, 5, 10)
      // パラメータの型を省略
      val actual = someNumbers.filter((x) => x > 0)
      actual must equalTo(List(5, 10))
      // カッコすら省略
      val actual2 = someNumbers.filter(x => x > 0)
      actual2 must equalTo(List(5, 10))
    }

  }

  "プレースホルダー構文(8.5の内容)" should {

    "プレースホルダを使った例" in {
      val someNumbers = List(-11, -10, -5, 0, 5, 10)
      // プレースホルダー使用例
      val actual = someNumbers.filter(_ > 0)
      actual must equalTo(List(5, 10))
    }

    "二個以上のプレースホルダーを使った例" in {
      val f = (_: Int) + (_: Int)
      f(5, 10) must equalTo(15)
    }

  }

  "部分適用された関数(0.6の内容)" should {

    "部分適用された関数" in {
      // まずは普通に定義
      def sum(a: Int, b: Int, c: Int) = a + b + c
      val actual = sum(1, 2, 3)
      actual must equalTo(6)
      // 次にプレースホルダーを仕込む
      val x = sum _
      val actual2 = x(1, 2, 3)
      actual2 must equalTo(6)
      // 一部の引数をコンクリートした状態の関数を定義する
      val y = sum(1, _: Int, 3)
      val actual3 = y(2)
      actual3 must equalTo(6)
    }

  }

  "クロージャー(8.7の内容)" should {

    "開いた項(open terms)" in {

      var more = 1

      // 変数束縛
      val addMore = (x: Int) => x + more

      // 関数の結果に影響を及ぼすし、取り出すことも出来る。
      addMore(10) must equalTo(11)
      more must equalTo(1)

      // varなら束縛されている変数の変更も可能
      more = 9999

      // 観測するとその影響を受けている。
      addMore(10) must equalTo(10009)
      more must equalTo(9999)

    }

    "ある対象の変数を書き換える(値自体の束縛では無い)" in {
      val someNumbers = List(-11, -10, -5, 0, 5, 10)
      var sum = 0
      someNumbers.foreach(sum += _)
      sum must equalTo(-11)
    }


    "変数は関数に束縛された時点の値を記録する" in {

      def makeIncreaser(more: Int) = (x: Int) => x + more

      val inc1 = makeIncreaser(1)

      val inc9999 = makeIncreaser(9999)

      inc1(10) must equalTo(11)

      inc9999(10) must equalTo(10009)

    }

  }

}
