package homeWorks.module_Scala_Essential.homeWork_07.task_03

import java.util.Date

trait PrintDate extends Print {
	override def print(msg: String): Unit = super.print(msg + new Date().toString)
}
