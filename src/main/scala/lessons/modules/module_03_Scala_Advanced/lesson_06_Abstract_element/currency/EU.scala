package lessons.modules.module_03_Scala_Advanced.lesson_06_Abstract_element.currency

object EU extends CurrencyZone {

	abstract class Euro extends AbstractCurrency {
		override def destination: String = "EUR"
	}

	type Currency = Euro

	override def make(amount: Long): Euro = new Euro {
		override val amount: Long = amount
	}
}