package samples

class UniformElement(
  ch: Char,
  override val width: Int,
  override val height: Int
) extends Element {
  private val line = ch.toString * width
  def contents = Array.fill(height)(line) // 本に乗っているのは古く、コレが新しい記述らしい
}

