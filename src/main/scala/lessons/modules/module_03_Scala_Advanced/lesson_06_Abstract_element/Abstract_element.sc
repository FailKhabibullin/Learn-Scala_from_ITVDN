trait Abstract {
	type A

	def a(a: A): Unit = println(a)
}

class ConcreteString extends Abstract {
	type A = String
}

class ConcreteInt extends Abstract {
	type A = Int
}

val concreteString = new ConcreteString
concreteString.a("Hi")


val concreteInt = new ConcreteInt
concreteInt.a(2)

abstract class Fruit {
	val v: String

	def m: String
}

abstract class Apple extends Fruit {
	val v: String
	val m: String
}

abstract class Apple1 extends Fruit {
	val v: String
	val m: String
}

trait Rational {
	val numerator: Int

	//! val инициализируется сразу (по дефолту там 0) и поэтому ошибка с require!
	val denominator: Int

	// denominator не должен равняться нулю(0)
	require(denominator != 0, "Division by zero!")
}


/* new Rational {
	override val numerator = 1
	override val denominator = 0
}*/

//& Default значения для полей trait что-бы не было ошибки
val rational = new {
	//! Предварительно проинициализированное поля (при наследовании) -
	//? позволяет инициализировать поле подкласса до вызова родительского класса.
	val numerator = 1
	val denominator = 3
} with Rational

object myRationalObject extends {
	val numerator = 1
	val denominator = 1
} with Rational

class RationalClass(num: Int, denom: Int) extends {
	val numerator = num
	val denominator = denom
} with Rational {
	def +(that: RationalClass): RationalClass =
		new RationalClass(numerator * that.denominator + numerator * that.denominator,
			denominator * that.denominator)
}

new RationalClass(1, 3)

object Demo {
	lazy val x: String = {
		println("Initializing x")
		"Done"
	}
}

Demo

Demo.x
