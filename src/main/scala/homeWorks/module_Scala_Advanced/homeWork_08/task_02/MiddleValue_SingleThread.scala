package homeWorks.module_Scala_Advanced.homeWork_08.task_02

import scala.util.Random

object MiddleValue_SingleThread extends App {


	def time[R](block: => R, msg: String): R = {
		val t0 = System.nanoTime()
		val result = block // call-by-name
		val t1 = System.nanoTime()
		val resultTimeMillisecond = (t1 - t0) / 1000000
		println(s"Elapsed time: ${resultTimeMillisecond}ms, with $msg")
		result
	}

	val list = List.fill(10_000_000)(Random.nextInt(1_000_000))

	def middleValue(list: List[Int]): Int = list.sum / list.length


	time(middleValue(list), "Single Thread")
}
