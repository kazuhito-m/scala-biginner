package samples

import org.specs2.mutable.Specification

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
      var baseParam = List(1, 2, 3, 4)
      var expected = false

      containsNegC(baseParam) must equalTo(expected)
      containsNegF(baseParam) must equalTo(expected)

      baseParam = List(1, 2, -3, 4)
      expected = true

      containsNegC(baseParam) must equalTo(expected)
      containsNegF(baseParam) must equalTo(expected)

    }

    // 命令形で書いたList内に奇数があるか検索
    def containsOddC(nums: List[Int]): Boolean = {
      var exists = false
      for (num <- nums)
        if (num % 2 == 1)
          exists = true
      exists
    }

    // 関数型で書いたList内に奇数があるか検索
    def containsOddF(nums: List[Int]): Boolean = nums.exists(_ % 2 == 1)

    "奇数検出の関数のテスト" in {
      var baseParam = List(2, 4, 10)
      var expected = false

      containsOddC(baseParam) must equalTo(expected)
      containsOddF(baseParam) must equalTo(expected)

      baseParam = List(2, 3, 4)
      expected = true

      containsOddC(baseParam) must equalTo(expected)
      containsOddF(baseParam) must equalTo(expected)

    }

  }

}
