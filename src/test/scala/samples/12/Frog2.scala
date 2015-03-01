package samples

class Animal
trait HasLegs

class Frog2 extends Animal with Philosophical with HasLegs{
  override def toString = "green"
  override def say() = "It ain't easy being " + toString + "!"
}