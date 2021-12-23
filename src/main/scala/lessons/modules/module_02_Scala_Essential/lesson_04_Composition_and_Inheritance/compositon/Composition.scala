package lessons.modules.module_02_Scala_Essential.lesson_04_Composition_and_Inheritance.compositon

import scala.language.postfixOps

object Composition extends App {
	val column1 = new ArrayElement(Array("Hello")) above new ArrayElement(Array("***"))
	val column2 = new ArrayElement(Array("***")) above new ArrayElement(Array("Hello"))

	println(column1 beside column2)
}
