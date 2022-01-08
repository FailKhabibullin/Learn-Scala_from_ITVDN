package homeWorks.module_Scala_Essential.homeWork_10.task_03_UnsortedSetToSorted

import scala.annotation.tailrec
import scala.collection.immutable.TreeSet
import scala.util.Random


object SetSort extends App {


	def generateRandomWordsSet(count: Int, length: Int): TreeSet[String] = {

		@tailrec
		def generate(length: Int, acc: String = ""): String = length match {
			case 0 => acc
			case _ => generate(length - 1, Random.between(97, 116).toChar + acc)
		}

		TreeSet[String]() ++= Set.fill(count)(generate(Random.between(2, length)))
	}

	println(generateRandomWordsSet(5, 6))
}