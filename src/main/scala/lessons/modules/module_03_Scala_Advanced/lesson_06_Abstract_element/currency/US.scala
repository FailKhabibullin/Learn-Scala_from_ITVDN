package lessons.modules.module_03_Scala_Advanced.lesson_06_Abstract_element.currency

object US extends CurrencyZone {

	abstract class Dollar extends AbstractCurrency {
		override def destination: String = "USD"
	}

	type Currency = Dollar

	override def make(amount: Long): Dollar = new Dollar {
		override val amount: Long = amount
	}
}
