package samples

import org.specs2.mutable.Specification
import samples.bobsrockets.navigation.Navigator

package bobsrockets {
  package navigation {
    class Navigator
    package tests{
      class NavigatorSuite
    }
  }
}


class PackagesAndImportsTest extends Specification {

  "パッケージ(13.1)" should {

    "同じファイルに入れ子にしてパッケージ定義" in {
      val sut = new Navigator
      sut.getClass.getPackage.getName must equalTo("samples.bobsrockets.navigation")
    }

  }

}


