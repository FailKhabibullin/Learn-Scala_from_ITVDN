package homeWorks.module_Scala_Essential.homeWork_07.task_03

trait PrintHello extends Print {
	override def print(msg: String): Unit = super.print(s"Hello, $msg! - ")
}
