val part1 = scala.io.Source.fromFile("input.txt").mkString
  .split("\n")
  .toList
  .map(_.replaceAll("\\s", ""))
  .map{round => 
    round match {
      case "AX" => 4
      case "AY" => 8
      case "AZ" => 3
      case "BX" => 1
      case "BY" => 5
      case "BZ" => 9
      case "CX" => 7
      case "CY" => 2
      case "CZ" => 6
    }
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

