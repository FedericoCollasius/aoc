val part1 = scala.io.Source.fromFile("input.txt").getLines().toList
  .map{ l => 
    val length = l.length
    val (fst, snd) = l.splitAt(length/2)
    fst.intersect(snd).distinct
  }
  .map{ str => 
    val char = str.head
    if (char.isLower)
      char.toInt - 96
    else 
      char.toInt - 38
  }
  .sum

val part2 = scala.io.Source.fromFile("input.txt")
  .getLines()
  .toList
  .grouped(3)
  .toList
  .map{ group => 
   group match {
      case List(elf1, elf2, elf3) => 
        elf1.intersect(elf2).intersect(elf3)
    }
  }
  .map{ str => 
    val char = str.head
    if (char.isLower)
      char.toInt - 96
    else 
      char.toInt - 38
  }
  .sum
