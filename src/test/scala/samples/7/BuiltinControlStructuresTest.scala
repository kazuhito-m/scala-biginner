package samples

import org.specs2.mutable.Specification
import org.mockito.Matchers

class BuiltinControlStructuresTest extends Specification {

  "組み込み制御構造" should {

    "if式（7.1の内容）" in {
      val args: Array[String] = Array()
      // 命令形スタイル
      var filename1 = "default.txt"
      if (!args.isEmpty)
        filename1 = args(0)
      // 関数型スタイル
      val filename2 = if (args.isEmpty) "default.txt" else args(0)
      // 書き方違えど双方結果は同じ
      filename1 must equalTo(filename2)
    }

  }

}
