package homeWorks.module_Scala_Advanced.homeWork_08.task_01

import homeWorks.module_Scala_Advanced.homeWork_08.task_02.MiddleValue_SingleThread.time

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.util.Random

object MiddleValue_With_Future {

	def main(args: Array[String]): Unit = {
		val list: List[Int] = List.fill(10_000_000)(Random.nextInt(1_000_000))

		def middleValue(list: List[Int]): Int = list.sum / list.length

		time(Future(middleValue(list)), "Future implementing")
		time(middleValue(list), "Single thread")
	}
}
