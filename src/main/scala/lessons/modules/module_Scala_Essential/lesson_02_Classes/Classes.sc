import scala.collection.mutable.ArrayBuffer

class Counter {
	def this(value: Int) = {
		this()
		this.value = value
	}

	def this(value: Int, str: String) = {
		this(value)
	}

	private var value = 0

	def increment(): Unit = {
		value += 1
	}

	//	def vUsing(): Unit = println(v)

	def current: Int = value

	def <(other: Counter): Boolean = value < other.value

	println(s"value = $value")
}

val c1 = new Counter
val c2 = new Counter

val c3 = new Counter(3)
c3.current

val c4 = new Counter(4, "Str")
c4.current

c1.increment()
c1.current

c2.increment()
c2.current


c1 < c2

class Network {
	class Member(name: String) {
		val contacts = new ArrayBuffer[Member]()
	}

	private val members = new ArrayBuffer[Member]()

	def join(name: String) = {
		val m = new Member(name)
		members += m
		m
	}
}

val n1 = new Network
val n2 = new Network

new n1.Member("Anna")
new n2.Member("Ivan")

val anna: n1.Member = n1.join("Anna")
val ivan: n1.Member = n1.join("Ivan")

anna.contacts += ivan
anna.contacts

val nick = n2.join("Nick")

//anna.contacts += nick

class Dog(name: String, age: Int)

case class Cat(name: String, age: Int) {
	override def toString = {
		s"name - $name, age - $age"
	}
}

val cat1 = Cat("Pushok", 7)
val cat2 = Cat("Pushok", 7)
val cat3 = cat1.copy()

cat1 == cat3
cat2 == cat3

println(cat1)
println(n1)

val dog1 = new Dog("Bim", 5)
val dog2 = new Dog("Bim", 5)

dog1 == dog2