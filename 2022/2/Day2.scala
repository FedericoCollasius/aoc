val shapeToScore= Map('X' -> 1, 'Y' -> 2, 'Z' -> 3) 
val part1 = scala.io.Source.fromFile("input.txt").mkString
  .split("\n")
  .toList
  .map(_.replaceAll("\\s", ""))
  .map{round => 
    val opp = round.head
    val me  = round.last
    
    val base = shapeToScore(me)
    val outcome = round match {
      case "AX" => 3
      case "BY" => 3
      case "CZ" => 3
      case "AY" => 6
      case "BZ" => 6
      case "CX" => 6
      case _    => 0
    }
    val score = base + outcome
    score
  }
  .sum

val part2 = scala.io.Source.fromFile("input.txt").mkString
  .split("\n")
  .toList
  .map(_.replaceAll("\\s", ""))
  .map{round => 
    round match {
      case "AX" => 3
      case "AY" => 4
      case "AZ" => 8
      case "BX" => 1
      case "BY" => 5
      case "BZ" => 9
      case "CX" => 2
      case "CY" => 6
      case "CZ" => 7
    }
  }
  .sum
