package lessons.modules.module_03_Scala_Advanced.lesson_06_Abstract_element.currency

abstract class CurrencyZone {
	type Currency <: AbstractCurrency

	// Factory methods
	def make(amount: Long): Currency

	abstract class AbstractCurrency {

		val amount: Long

		def destination: String

		override def toString: String = s"$amount $destination"

		def +(that: Currency): Currency = make(this.amount + that.amount)

		def *(x: Long): Currency = make(this.amount * x)
	}
}