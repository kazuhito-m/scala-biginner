package samples

import org.specs2.mutable.Specification

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

    "ファイル名を正規表現で取得するメソッドのテスト" in {
      val actual = FileMatcher.filesRegex(".*a.*")
      actual.length must equalTo(2)
    }

  }

}
