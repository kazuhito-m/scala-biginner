package samples

import org.specs2.mutable.Specification
import org.mockito.Matchers

class BuiltinControlStructuresTest extends Specification {

  "組み込み制御構造" should {

    "条件if式(7.1の内容)" in {
      val args: Array[String] = Array()
      // 命令形スタイル
      var filename1 = "default.txt"
      if (!args.isEmpty)
        filename1 = args(0)
      // 関数型スタイル
      val filename2 = if (!args.isEmpty) args(0) else "default.txt"
      // 等式推論例
      println(if (!args.isEmpty) args(0) else "default.txt")
      // 書き方違えど双方結果は同じ
      filename1 must equalTo(filename2)
    }

    "whileループ(7.2の内容)" in {

      // 命令型スタイルの最大公約数計算
      def gcdLoop(x: Long, y: Long): Long = {
        var a = x
        var b = y
        while (a != 0) {
          val temp = a
          a = b % a
          b = temp
        }
        b
      }

      // 関数型スタイルの最大公約数計算
      def gcd(x: Long, y: Long): Long = {
        if (y == 0) x else gcd(y, x % y)
      }

      val i = 9
      val j = 6

      gcdLoop(i, j) must equalTo(gcd(i, j))

    }

  }

}

