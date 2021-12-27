package homeWorks.module_Scala_Essential.homeWork_05.task_03

/*
? Задание 3
** Какая ошибка может возникнуть, если вызвать метод get на пустом значении Option? Продемонстрируйте это в коде.
*/

object Main extends App {
	val npe: Option[String] = None

	println(npe.get)
}
