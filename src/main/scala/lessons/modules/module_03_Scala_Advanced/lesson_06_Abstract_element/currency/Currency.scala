package lessons.modules.module_03_Scala_Advanced.lesson_06_Abstract_element.currency

abstract class Currency {
	val amount: Long

	def destination: String

	override def toString: String = s"$amount $destination"

	def +(that: Currency): Currency

	def *(that: Currency): Currency
}