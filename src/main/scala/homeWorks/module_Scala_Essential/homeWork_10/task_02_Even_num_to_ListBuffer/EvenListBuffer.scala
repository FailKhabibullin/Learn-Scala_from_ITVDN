package homeWorks.module_Scala_Essential.homeWork_10.task_02_Even_num_to_ListBuffer

import scala.collection.mutable.ListBuffer
import homeWorks.module_Scala_Essential.homeWork_10.task_01_Create_random_number.RandomNums.rndSet

object EvenListBuffer {
	val listBuffer: ListBuffer[Int] = ListBuffer() ++= (rndSet.filter(_ % 2 == 0))

	def main(args: Array[String]): Unit = {
		listBuffer.foreach(println)
	}
}