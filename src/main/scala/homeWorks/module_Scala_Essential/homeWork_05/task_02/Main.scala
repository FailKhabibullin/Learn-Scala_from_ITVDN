package homeWorks.module_Scala_Essential.homeWork_05.task_02

object Main extends App {
	val npe: Option[String] = Option("1")

	npe match {
		case Some(value) => println(value)
		case None => println("None value")
	}
}
