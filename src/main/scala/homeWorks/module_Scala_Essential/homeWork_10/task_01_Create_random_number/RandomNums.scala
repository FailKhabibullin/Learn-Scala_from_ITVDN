package homeWorks.module_Scala_Essential.homeWork_10.task_01_Create_random_number

import scala.util.Random

object RandomNums {
	val rndSet: Set[Int] = (1 to 20).map(_ => Random.between(0, 20)).toSet

	def main(args: Array[String]): Unit = {
		import scala.util.Random


	}
}