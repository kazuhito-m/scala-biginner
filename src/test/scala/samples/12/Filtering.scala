package samples

trait Filtering extends IntQueue {
  abstract override def put(x: Int) { super.put(x + 1) }
}
