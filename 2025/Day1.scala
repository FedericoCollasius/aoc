object Day1{
  def mod(a: Int, n: Int): Int = {
    val res = a % n
    res + (if (res < 0) n else 0)
  }

  def rotate(state: (Int, Int), rotation: String): (Int, Int) = {
    val (position, countOf0) = state
    println(s"Current state: $state")
    val (direction, magnitude) = rotation.splitAt(1)
    println(s"Rotation: $rotation")
    val nextRotation = direction match {
      case "R" => position + magnitude.toInt
      case "L" => position - magnitude.toInt
    }
    println(s"Next rotation: $nextRotation")
    val nextPosition = mod(nextRotation, 100)
    println(s"NextPosition: $nextPosition")
    val newState = nextPosition == 0 match {
      case true => (nextPosition, countOf0 + 1)
      case false => (nextPosition, countOf0)
    }
    println(s"The dial is rotated $rotation to point at ${newState._1} with ${newState._2} counts of 0")
    newState
  }
 
  def solveFile(filePath: String): Unit = {
    val input = scala.io.Source.fromFile(filePath).getLines.toList
    println(s"$input")
    val res = input.foldLeft((50, 0))(rotate)._2
    println(s"$res")
  }

  def main(args: Array[String]): Unit = {
    args.foreach(solveFile)
  }
}
