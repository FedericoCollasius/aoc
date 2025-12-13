val input = scala.io.Source.fromFile("sample.txt").mkString.split("\n\n")

val numStacks = input(0).takeRight(2).trim.toInt
val buckets: Vector[List[Char]] = Vector.fill(numStacks)(List())
val stacks= input(0).split("\n")
  .dropRight(1)
  .flatMap{line =>
    line.grouped(4).toList.zipWithIndex.collect{
      case(str, idx) if str.trim.nonEmpty && str.contains('[') =>
        (idx, str.trim.replaceAll("\\[|\\]", "").head)
    }
  }
  .groupMap(_._1)(_._2)
  .toVector
  .map(_._2.toList)

// val stacksToParse = input(0).split("\n")
//   .dropRight(numStacks*2 + 1)
//   .map(_.grouped(4).toList)
//   .flatMap(_.zipWithIndex)
//   .map{case (str, idx) =>
//     val cleanStr = str.trim.replaceAll("\\[|\\]", "")
//     println(s"$cleanStr")
//     if (!cleanStr.isEmpty) cleanStr::buckets(idx)    
//   }
// val stacks = buckets.map(_.reverse)
