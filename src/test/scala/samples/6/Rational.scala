package samples

class Rational(n: Int, d: Int) {
  require(d != 0) // 事前条件(precondition)
  println("Created " + toString)
  override def toString = n + " / " + d
  def add(that:Rational):Rational = new Rational(0,1) // FIXME 仮実装。早く実装してね！
}

