object Day1{
  def mod(a: Int, n: Int): Int = {
    val res = a % n
    res + (if (res < 0) n else 0)
  }

  def rotate(state: (Int, Int), rotation: String): (Int, Int) = {
    val (position, countOf0) = state
    val (direction, magnitude) = rotation.splitAt(1)
    val nextRotation = direction match {
      case "R" => position + magnitude.toInt
      case "L" => position - magnitude.toInt
    }
    val nextPosition = mod(nextRotation, 100)
    nextPosition == 0 match {
      case true => (nextPosition, countOf0 + 1)
      case false => (nextPosition, countOf0)
    }
  }
 
  def solveFile(filePath: String): Unit = {
    scala.io.Source
      .fromFile(filePath)
      .getLines
      .toList
      .foldLeft((50, 0))(rotate)
      ._2
  }

  def main(args: Array[String]): Unit = {
    args.foreach(solveFile)
  }
}
