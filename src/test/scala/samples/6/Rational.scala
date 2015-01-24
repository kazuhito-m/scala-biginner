package samples

class Rational(n: Int, d: Int) {

  // 事前条件(precondition)
  require(d != 0)
  // フィールドセット
  val numer: Int = n
  val denom: Int = d
  // コンストラクタの主処理っぽいもの
  println("Created " + toString)

  // メソッド群
  override def toString = numer + " / " + denom

  def add(that: Rational): Rational = {
    new Rational(
      numer * that.denom + that.numer * denom
      , denom * that.denom
    )
  }

}

