val input = scala.io.Source.fromFile("input.txt").mkString.split("\n\n")

//val numStacks = input(0).takeRight(2).trim.toInt
//val buckets: Vector[List[Char]] = Vector.fill(numStacks)(List())
var stacks= input(0).split("\n").dropRight(1).flatMap{line =>
    line.grouped(4).toList.zipWithIndex.collect{
      case(str, idx) if str.trim.nonEmpty && str.contains('[') =>
        (idx, str.trim.replaceAll("\\[|\\]", "").head)
    }
  }.groupMap(_._1)(_._2).toVector.sortBy(_._1).map(_._2.toList)

val part2 = input(1).split("\n")
  .map{ lines =>
    lines match {
      case s"move $nStr from $fromStr to $toStr" =>
        val n = nStr.toInt
        val from = fromStr.toInt - 1
        val to = toStr.toInt - 1
        val newStackTo = stacks(from).take(n) ::: stacks(to)
        val newStackFrom = stacks(from).drop(n)
        stacks = stacks
          .updated(from, newStackFrom)
          .updated(to, newStackTo)
        println(s"$stacks")
    }
  }
  // Maybe it would have made more sense to use a foldLeft
  // Also a List of char is a string basically
  // So a Vector[String] would have been simpler

stacks.map(_.head).toString

//First try:
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

// Much cleaner parsing:
// val lines = io.Source.fromResource("2022/day-05.txt").getLines()
// val drawing = lines.takeWhile(_.nonEmpty).toVector
// val steps = lines.toList
//
// val start: State = drawing.init.transpose.collect {
//   case col if col.exists(_.isLetter) => col.mkString.stripLeading
// }

// For doing part1 add a `reverse` in line 19 
