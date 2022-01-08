package lessons.modules.module_02_Scala_Essential.lesson_10_OtherSequences

object Main extends App {

	import scala.collection.{StringOps, mutable}
	import scala.collection.mutable.
	{ArrayBuffer, ListBuffer}

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
}
