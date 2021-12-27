import java.util.Date

trait HelloWorld {
	println("Constructor HelloWorld!")

	val name: String

	def sayHello(msg: String = ""): Unit =
		println(s"Hello, world! $msg")
}

trait TimestampHelloWorld extends HelloWorld {
	println("Constructor TimestampHelloWorld")

	override def sayHello(msg: String): Unit =
		super.sayHello(new Date() + " " + msg)
}

trait UppercaseHelloWorld extends HelloWorld {
	println("Constructor UppercaseHelloWorld")

	override def sayHello(msg: String): Unit =
		super[HelloWorld].sayHello(msg.toUpperCase)
}

trait HelloSea {
	println("Constructor HelloSea")

	def sayHelloSea(str: String): Unit =
		println("Hello, sea")
}

case class B() {
	println("B")
}

/*
class A extends B with HelloWorld
	with HelloSea {
	println("Constructor A")
	override val name = "A Anna"
}
*/


/*
new A().sayHello()


val a = new A()
val helloWorld: HelloWorld = a

a.sayHello()
*/

class C extends B
	with HelloWorld
	with TimestampHelloWorld
	with UppercaseHelloWorld with HelloSea {
	override val name = "C Anna"
	println(s"Constructor C with name: $name")
}

new C().sayHelloSea("Super")

//-------------------------------------------------
trait LoggedException extends Exception {
	val log: Unit = println(getMessage)

	var dsf: String = "Hello"
}

class MyException extends IllegalArgumentException with LoggedException {
	getMessage
}