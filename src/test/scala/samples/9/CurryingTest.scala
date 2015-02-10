package samples

import org.specs2.mutable.Specification
import java.io.{IOException, FileNotFoundException, File}
import java.io
import java.net.{MalformedURLException, URL}
import scalaz.Digit._0

class CurryingTest extends Specification {

  "クライアントコードの単純化(9.2)" should {

    // 命令形で書いたList内に負数があるか検索
    def containsNegC(nums: List[Int]): Boolean = {
      var exists = false
      for (num <- nums)
        if (num < 0)
          exists = true
      exists
    }

    // 関数型で書いたList内に負数があるか検索
    def containsNegF(nums: List[Int]): Boolean = nums.exists(_ < 0)

    "関数自体のただしさテスト" in {
      var baseParam = List(1,2,3,4)
      var expected = false

      containsNegC(baseParam) must equalTo(expected)
      containsNegF(baseParam) must equalTo(expected)

    }

  }

}
