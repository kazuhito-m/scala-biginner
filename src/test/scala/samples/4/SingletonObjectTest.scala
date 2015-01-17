package samples

import org.specs2.mutable.Specification

/**
 * コップ本4.3のサンプル
 */
class SingletonObjectTest extends Specification {

    "ChecksumAccumlatorクラスとChecksumAccumlatorシングルトンオブジェクト" in {

      // まず一度目。
      val checkTarget = "Every value is an object."
      ChecksumAccumlator.calculate(checkTarget) must equalTo(-248)

      // それ以降も同じ値を返す。（キャッシュされているからそっから結果を出している…はず)
      ChecksumAccumlator.calculate(checkTarget) must equalTo(-248)
      ChecksumAccumlator.calculate(checkTarget) must equalTo(-248)

    }

  }