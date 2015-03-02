package samples

/**
 * 6章で作ったクラスの例。
 * 12章で改造するために、コピーし再度定義する。
 * @param n
 * @param d
 */
class Rational2(n: Int, d: Int) extends Ordered[Rational2] {

  // 事前条件(precondition)
  require(d != 0)

  // 通分処理
  private val g = gcd(n.abs, d.abs)

  // フィールドセット
  val numer: Int = n / g
  val denom: Int = d / g

  // 分子だけを指定すると分母は1固定になる(補助コンストラクター)
  def this(n: Int) = this(n, 1)

  // コンストラクタの主処理っぽいもの
  println("Created " + toString)

  // メソッド群
  override def toString = numer + " / " + denom

  def add(that: Rational2): Rational2 = {
    new Rational2(
      numer * that.denom + that.numer * denom
      , denom * that.denom
    )
  }

  def lessThan(that: Rational2) = this.numer * that.denom < that.numer * this.denom

  def max(that: Rational2): Rational2 = if (this.lessThan(that)) that else this

  // 最大公約数計算(再帰)
  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

  // "+" 演算子
  def +(that: Rational2): Rational2 = add(that)

  // "+" 演算子(整数の足し算バージョン)
  def +(i: Int) = new Rational2(numer * i + denom, denom)

  // "*" 演算子
  def *(that: Rational2): Rational2 = new Rational2(numer * that.numer, denom * that.denom)

  // "*" 演算子（整数の掛け算バージョン）
  def *(i: Int) = new Rational2(numer * i, denom)

  // 比較に使うコンパレータ
  def compare(that: Rational2): Int = (this.numer * that.denom) - (that.numer * this.denom)
}

