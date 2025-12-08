case class State(position: Int, countOf0: Int)

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

  def completeMCyclesInRange(p: Int, a: Int, , m: Int): Int = {
    a match {
      case x if (p == 0 && a < 0) =>
        ((a - b)/100).abs - 1
      case x if (a == 0)          =>
        ((a - b)/100).abs + 1
      case _                      =>
        ((a - b)/100).abs
    }
  }

  def rotatePt2(state: State, rotation: String): State = {
    println(s"Rotation: $rotation")
    println(s"Current state: $state")
    val nextRotation = rotation match {
      case s"R$mag" => state.position + mag.toInt
      case s"L$mag" => state.position - mag.toInt
    }
    println(s"p: ${state.position}")
    println(s"a: $nextRotation")
    val nextPosition = mod(nextRotation, 100)
    println(s"b: $nextPosition")
    val cycles = completeMCyclesInRange(state.position, nextRotation, nextPosition, 100)
    println(s"The dial is rotated $rotation to point at $nextPosition with ${state.countOf0 + cycles} counts of 0")
    State(nextPosition, state.countOf0 + cycles)
  }

  def solveFile(filePath: String): Unit = {
    println(scala.io.Source
      .fromFile(filePath)
      .getLines()
      .toList
      .foldLeft(State(50, 0))(rotatePt2)
      .countOf0)
  }

  def main(args: Array[String]): Unit = {
    args.foreach(solveFile)
  }
}
