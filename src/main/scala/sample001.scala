import scala.io._

def toInt(in: String): Option[Int] = 
  try {
    Some(Integer.parseInt(in.trim))
  } catch {
    case e: NumberFormatException => None
  }


def sum(in: Seq[String]) = {
  val ints = in.flatMap(s => toInt(s))
  ints.foldLeft(0)((a,b) => a + b)
}

println("Enter some numbers and press ctrl-D (Unix/Linux/Mac) ctrl-Z (windows)")

val input = Source.fromInputStream(System.in)

// XXX for old version Scala.
// val lines = input.getLines.collect
// now version Scala.
val lines = input.getLines.toList

println("Sum " + sum(lines))
