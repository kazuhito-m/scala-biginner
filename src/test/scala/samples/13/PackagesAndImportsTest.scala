package samples

import org.specs2.mutable.Specification
import samples.bobsrockets.navigation.Navigator
import samples.bobsrockets.navigation.tests.NavigatorSuite
import samples.bobsrockets.launch.Booster

package bobsrockets {
  package navigation {
    class Navigator
    package tests{
      class NavigatorSuite
    }
    package launch {
      class Booster1
    }
    class MissionControl {
      val booster1 = new launch.Booster1
      val booster2 = new bobsrockets.launch.Booster2
      // FIXME コレがなぜか通らない。コメントアウト
      // val booster3 = new _root_.launch.Booster3
    }
  }
  package launch {
    class Booster {
      val nav = new navigation.Navigator
    }
    class Booster2
  }

}
package launch {
  class Booster3
}

class PackagesAndImportsTest extends Specification {

  "パッケージ(13.1)" should {

    "同じファイルに入れ子にしてパッケージ定義" in {
      val sut = new Navigator
      sut.getClass.getPackage.getName must equalTo("samples.bobsrockets.navigation")
      val sut2 = new NavigatorSuite
      sut2.getClass.getPackage.getName must equalTo("samples.bobsrockets.navigation.tests")
    }

  }

  "Scalaパッケージは本当に入れ子になる" in {
    val sut = new Booster
    sut.getClass.getPackage.getName must equalTo("samples.bobsrockets.launch")
    // 内部のクラスはクラスで別パッケージのものを指定。
    sut.nav.getClass.getPackage.getName must equalTo("samples.bobsrockets.navigation")
  }

  "インポート(13.2)" should {
    "関数の途中でインポートする例" in {
      import java.util.regex
      val hittest = "abcdef"
      val pat = regex.Pattern.compile("a*b")
      pat.matcher(hittest).find must equalTo(true)
    }
  }

  "暗黙のインポート(13.3)" should {
    "普段インポートされているパッケージをあえてインポート" in {
      import java.lang._
      import scala._
      import Predef._
      // たとえばJavaLangのStringを使う例。
      new String("miura") must equalTo("miura")
    }
  }

}

