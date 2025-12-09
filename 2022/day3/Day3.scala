scala.io.Source.fromFile("input.txt").getLines().toList
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


