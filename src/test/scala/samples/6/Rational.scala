package samples

class Rational(n: Int, d: Int) {
//  require(d != 0) // 事前条件(precondition)
  println("Created " + toString)
  override def toString = n + " / " + d
}

