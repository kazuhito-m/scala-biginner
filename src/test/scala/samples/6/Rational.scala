package samples

class Rational(n: Int, d: Int) {

  // 暗黙的なコンストラクタの実装
  require(d != 0)
  // 事前条件(precondition)
  val numer: Int = n
  val denom: Int = d
  println("Created " + toString)

  // メソッド群
  override def toString = n + " / " + d

  def add(that: Rational): Rational = new Rational(5, 4) // FIXME 仮実装。早く実装してね！
}

