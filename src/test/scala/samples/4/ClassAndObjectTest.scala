package samples

import org.specs2.mutable.Specification

/**
 * コップ本4.1のサンプル
 */
class ClassAndObjectTest extends Specification {

  class ChecksumAccumlator {
    var sum = 0
  }

  "オブジェクトとその上に乗っているフィールドは編集可不可が違う" should {

    "オブジェクト二つ作って比較" in {
      val acc = new ChecksumAccumlator()
      val sca = new ChecksumAccumlator()

      // 作成直後は値は一緒。
      acc.sum must equalTo(sca.sum)

    }

  }
}

