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

  def completeMCyclesInRange(p: Int, a: Int): Int = {
    a match {
      case x if (p != 0 && a <= 0) =>
        (a/100).abs + 1
      case x if (p == 0 || a > 0) =>
        (a/100).abs
    }
  }

  def rotatePt2(state: State, rotation: String): State = {
    val nextRotation = rotation match {
      case s"R$mag" => state.position + mag.toInt
      case s"L$mag" => state.position - mag.toInt
    }
    val nextPosition = mod(nextRotation, 100)
    val cycles = completeMCyclesInRange(state.position, nextRotation)
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
