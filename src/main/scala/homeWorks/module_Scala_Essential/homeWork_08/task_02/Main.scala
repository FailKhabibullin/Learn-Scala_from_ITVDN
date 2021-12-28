package homeWorks.module_Scala_Essential.homeWork_08.task_02

object Main extends App {
	def func(f: => Int => Int, value: Int): Int = {
		f(value)
	}

	println(func(_ + 1, 3))
}
