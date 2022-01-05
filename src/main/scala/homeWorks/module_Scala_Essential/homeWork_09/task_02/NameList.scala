package homeWorks.module_Scala_Essential.homeWork_09.task_02

object NameList extends App {
	val names = List("Fail", "Ali", "Albert", "Marat", "Martin")

	def printSimilarWord(list: List[String]): Unit = {
		val iteratorCopy = list.iterator
		//		iteratorCopy
		//		list.filter(x => {
		//			if (iteratorCopy.hasNext && (x.head == iteratorCopy.next.head)) true else false
		//		}).foreach(println)
		val sameNameStartSymbol = {
			for {
				l <- list if (l.head == iteratorCopy.next.head)
			} yield l
		}
		sameNameStartSymbol.foreach(println)

		list.reduce((x, y) => (if (x.head == y.head) x else y))

	}

	printSimilarWord(names)
}
