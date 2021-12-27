package homeWorks.module_Scala_Essential.homeWork_07.task_02

import homeWorks.module_Scala_Essential.homeWork_07.task_01.PrintDate

object Hello extends PrintDate {
	 override def print(name: String): Unit = println(s"Hello, $name!")
}