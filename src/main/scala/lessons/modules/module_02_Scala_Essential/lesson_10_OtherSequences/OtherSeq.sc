import scala.collection.{StringOps, mutable}
import scala.collection.mutable.{ArrayBuffer, ListBuffer}
import scala.collection.immutable.{TreeMap, TreeSet}

var arr = new Array(2)
var arrInt = new Array[Int](3)
var arrString = new Array[String](3)
var arr1 = Array(3)
arrString(1) = "Hello"

val listBuffer = ListBuffer(3)
listBuffer += 4
2 +=: listBuffer
listBuffer.+=:(2)

val arrayBuffer = ArrayBuffer[String]()
arrayBuffer += "Hello"
arrayBuffer += "World"
arrayBuffer -= "World"
Vector

"Hello, World".map(_ + " 0").toList

val set = Set(1, 1, 1, 1, 1, 1, 1, 1)
val mutSet = mutable.Set(2)

val map = Map(1 -> "q")
val mutMap = mutable.Map(1 -> "q")
var mapVar = Map(1 -> "q")

mapVar += (2 -> "w")
mapVar(2)

val str =
	"Hello, World, my beautiful world. It's a beautiful day."

val words = str.split("[ !,.]+")

val result = mutable.Set.empty[String]

for (word <- words) {
	result += word.toLowerCase()
}
result

val nums = Set(1, 2, 3)
nums + 5
nums - 3

nums ++ Set(4, 6)
nums -- List(1, 2)
nums & Set(1, 3)

nums.size
nums.contains(1)

def countWords(text: String) = {
	val counts = mutable.Map.empty[String, Int]

	for (rawWord <- text.split(raw"[ !,.]+")) {
		val word = rawWord.toLowerCase

		val oldCounts: Int = if (counts.contains(word)) counts(word) else 0
		counts += (word -> (oldCounts + 1))
	}

	counts
}

countWords(str)

val exampleMap = countWords(str)
exampleMap + ("Hi" -> 1)
exampleMap - "is"
exampleMap -- List("is", "Word", "it")
exampleMap ++ List("y" -> 8, "p" -> 7)
exampleMap.values
exampleMap.isEmpty

val ts = TreeSet(1, 9, 5, 8, 3, 2)
val tm = TreeMap(3 -> "p", 1 -> "13", 2 -> "o")

val coll: mutable.Set[Any] = mutable.Set("One")
coll += 1

val l =  List("One", "Two", "a")
val treeSet = TreeSet[String]() ++ l
treeSet.toList

val mutTs = mutable.TreeSet.empty[String] += 3