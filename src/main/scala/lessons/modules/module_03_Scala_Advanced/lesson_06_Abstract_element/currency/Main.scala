package lessons.modules.module_03_Scala_Advanced.lesson_06_Abstract_element.currency

object Main extends App {
	val eur = EU.make(100)

	val usd = US.make(100)
	val usd2 = usd + US.make(600)

	println(usd2)
}
