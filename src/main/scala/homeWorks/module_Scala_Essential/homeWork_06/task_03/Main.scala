package homeWorks.module_Scala_Essential.homeWork_06.task_03

import homeWorks.module_Scala_Essential.homeWork_06.task_01.StringLengthGreater

import scala.io.StdIn
import scala.util.{Failure, Success, Try}

object Main extends App {
	val userInput = StdIn.readLine

	def checkStringLength(string: String, length: Int): Try[String] = {
		if (string.length > length) Try(throw new StringLengthGreater("String length greater than 10 symbol"))
		else Try(string)
	}

	checkStringLength(userInput, 10) match {
		case Success(ex) => println(ex)
		case Failure(ex) => println(ex.getMessage)
	}
}