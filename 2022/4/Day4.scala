val part1 = 
  scala.io.Source.fromFile("input.txt")
  .mkString
  .split("\n")
  .toList
  .map{p =>
    val fullyContains = p match {
      case s"${from1}-${to1},${from2}-${to2}" =>
        ((from1.toInt <= from2.toInt && to2.toInt <= to1.toInt) 
          ||
        (from2.toInt <= from1.toInt && to1.toInt <= to2.toInt))
    }
    fullyContains.compare(false).sign
  }
  .sum
    
val part2 = 
  scala.io.Source.fromFile("input.txt")
  .mkString
  .split("\n")
  .toList
  .map{p =>
    val fullyContains = p match {
      case s"${sFrom1}-${sTo1},${sFrom2}-${sTo2}" =>
        val from1 = sFrom1.toInt
        val to1 = sTo1.toInt
        val from2 = sFrom2.toInt
        val to2 = sTo2.toInt
        (from1 <= from2 && from2 <= to1) ||
        (from2 <= from1 && from1 <= to2) ||
        (from1 <= from2 && to2 <= to1) ||
        (from2 <= from1 && to1 <= to2)
    }
    fullyContains.compare(false).sign
  }
  .sum

/*
f1-t1,f2-t2:

1: 
f1---t1
  f2---t2

2:
  f1---t1 
f2---t2

3: 
f1-----t1
  f2-t2 

4:
  f1-t1
f2-----t2

*/


