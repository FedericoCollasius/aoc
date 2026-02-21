val part1 = io.Source.fromFile("input.txt")
  .mkString
  .split("\n\n")
  .map{_.split("\n").map(_.toInt)}
  .map(_.sum)
  .max

val part2= io.Source.fromFile("input.txt")
  .mkString
  .split("\n\n")
  .map{_.split("\n").map(_.toInt)}
  .map(_.sum)
  .sorted
  .takeRight(3)
  .sum

