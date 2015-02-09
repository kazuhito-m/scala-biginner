package samples

import org.specs2.mutable.Specification
import java.io.{IOException, FileNotFoundException, File}
import java.io
import java.net.{MalformedURLException, URL}
import scalaz.Digit._0

// いっちょ前の関数
class FileMatcherTest extends Specification {

  "重複するコードの削減(9.1)" should {

    "ファイルの末尾指定で集めるメソッドのテスト" in {
      val actual = FileMatcher.fileEnding("t")
      actual.length must equalTo(4)
    }

    "ファイルの一部を含んでいるものを取得するメソッドのテスト" in {
      val actual = FileMatcher.filesContaining("git")
      actual.length must equalTo(2)
    }

  }

}
