package homeWorks.module_Scala_Essential.homeWork_06.task_02

import homeWorks.module_Scala_Essential.homeWork_06.task_01.StringLengthGreater

import scala.io.StdIn

object Main extends App {
	val userName = StdIn.readLine

	def checkStringLength(string: String, length: Int) = {
		if (string.length > length) throw new StringLengthGreater("String length greater than 10 symbol")
		else string
	}

	try {
		checkStringLength(userName, 10)
	} catch {
		case _: StringLengthGreater => println("String length greater than 10 symbols - pln")
		case x => println(x)
	}
}
