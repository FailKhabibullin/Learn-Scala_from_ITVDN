package homeWorks.module_Scala_Essential.homeWork_07.task_01

import java.util.Date

trait PrintDate {
	def print(): Unit = println(new Date())
	def print(str: String): Unit = println(s"$str ${new Date()}")
}
