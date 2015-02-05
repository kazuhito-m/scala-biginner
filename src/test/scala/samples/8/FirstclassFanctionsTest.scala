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
      val someNumbers = List(-11, -10, -5, 0, 5, 10)
      var sum = 0
      someNumbers.foreach((x: Int) => sum += x)
      sum must equalTo(-11)
    }

  }

}