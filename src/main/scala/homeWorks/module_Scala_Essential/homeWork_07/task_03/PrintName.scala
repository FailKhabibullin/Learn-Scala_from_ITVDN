package homeWorks.module_Scala_Essential.homeWork_07.task_03

class PrintName extends Print
	with PrintDate
	with PrintHello {
	override def print(msg: String): Unit = super.print(msg)
}