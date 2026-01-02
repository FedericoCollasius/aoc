// I want to find all the directories with a total size of at most 
// 100000 and then sum them.
// The size of a directory is equal to the sum of the sizes of its subdirectories + the files it has at the `ls` level

// The idea is to implement a n-arry tree

case class n_Tree(name: String, size: Int, children: Vector[n_Tree])

val input = io.Source.fromFile("sample.txt").mkString.split("\n")
var fileSystem = n_Tree("", -1, Vector())

val part1 = input.map{inst => 
  inst match{
    case s"$$ cd $dir_name" => {
      var dir: n_Tree = n_Tree(dir_name, -1, Vector())
      fileSystem.children.appended(dir)
    }
    case _ => "tbd"
  }
}
