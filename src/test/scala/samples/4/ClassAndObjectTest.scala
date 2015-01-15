package samples

import org.specs2.mutable.Specification

/**
 * コップ本4.1のサンプル
 */
class ClassAndObjectTest extends Specification {

  "オブジェクトとその上に乗っているフィールドは編集可不可が違う" should {

    "オブジェクト二つ作って比較" in {

      class ChecksumAccumlator {
        var sum = 0
      }

      val acc = new ChecksumAccumlator()
      val sca = new ChecksumAccumlator()

      // 作成直後は値は一緒。
      acc.sum must equalTo(sca.sum)

      // 値を変更することはできて、
      sca.sum = 3

      // それは参照したときに違うもの。
      acc.sum must not equalTo(sca.sum)

    }

  }
}

