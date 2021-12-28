package homeWorks.module_Scala_Essential.homeWork_08.task_01

object Main extends App {
	def func(f: => Int => Int) = (x: Int) => f(x)

	val addOne = func _

	println(addOne(x => x + 1)(4))


}