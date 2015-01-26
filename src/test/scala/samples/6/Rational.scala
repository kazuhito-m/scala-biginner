package samples

class Rational(n: Int, d: Int) {

  // 事前条件(precondition)
  require(d != 0)
  // フィールドセット
  val numer: Int = n
  val denom: Int = d

  // 分子だけを指定すると分母は1固定になる(補助コンストラクター)
  def this(n: Int) = this(n, 1)

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

  def lessThan(that: Rational) = this.numer * that.denom < that.numer * this.denom

  def max(that: Rational): Rational = if (this.lessThan(that)) that else this

}

