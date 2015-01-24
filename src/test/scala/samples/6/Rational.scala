package samples

class Rational(n: Int, d: Int) {

  // 暗黙的なコンストラクタの実装
  require(d != 0)
  // 事前条件(precondition)
  val numer: Int = n
  val denom: Int = d
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

