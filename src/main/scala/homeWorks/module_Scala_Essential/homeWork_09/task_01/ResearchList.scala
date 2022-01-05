package homeWorks.module_Scala_Essential.homeWork_09.task_01

object ResearchList extends App {

	val list = List(1, 2, 3, 4)

	println(list.foldLeft("1")((x, y) => x.toString + y))
}
