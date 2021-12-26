package homeWorks.module_Scala_Essential.homeWork_06.task_01

import scala.io.StdIn

class StringLengthGreater(string: String) extends Exception(string) {
	def this() = {
		this("")
	}
}

object Main extends App {
	val userName = StdIn.readLine

	def checkStringLength(string: String, checkLength: Int) = {
		if (string.length > checkLength) throw new StringLengthGreater("String length greater than") else string
	}

	checkStringLength(userName, 10)
}
