val part1 = io.Source.fromFile("input.txt").mkString
  .sliding(4)
  .zipWithIndex
  .collectFirst{ 
    case (str, idx) if str == str.distinct =>
      idx + 4
  }
  .get

val part2 = io.Source.fromFile("input.txt").mkString
  .sliding(14)
  .zipWithIndex
  .collectFirst{ 
    case (str, idx) if str == str.distinct =>
      idx + 14
  }
  .get
