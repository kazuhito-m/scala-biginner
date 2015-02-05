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

  }

}