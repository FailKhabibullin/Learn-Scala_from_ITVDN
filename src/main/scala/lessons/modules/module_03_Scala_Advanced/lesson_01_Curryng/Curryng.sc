import scala.annotation.tailrec

def mul(x: Int, y: Int): Int = x * y

def mulCurry(x: Int): Int => Int = (y: Int) => x * y

mulCurry(3)(4) // (y: Int) => 3 * 4

def mulCurry2(x: Int)(y: Int): Int = x * y

val a = List("Alex", "Anna")
val b = List("alex", "anna")

a.corresponds(b)(
	_.equalsIgnoreCase(_)
) // (a: String, b: String) => a.equalsIgnoreCase(b)

def runInThread(blockCode: => Unit): Unit = {
	new Thread {
		override def run(): Unit = blockCode
	}.start()
}
//
//runInThread {
//	println(
//		"The function does not accept any parameters and does not return anything"
//	);
//	Thread.sleep(100);
//	println("Buy!")
//}

var x = 10

@tailrec
def until(condition: => Boolean)(block: => Unit): Unit = {
	if (!condition) {
		block
		until(condition)(block)
	}
}


until(x == 0) {
	x -= 1
	println(x)
}

val partFunc: PartialFunction[Char, Int] = {
	case '+' => 1
	case '-' => -1
}

partFunc('-')
partFunc.isDefinedAt('-')
partFunc.isDefinedAt('+')
//partFunc('=')

"-3+4".collect { case '+' => 1; case '-' => -1 }

List(1, 2, -2, 8, 90).collect {
	case 0 => "0"
	case x if x < 0 => "-1"
	//	case x if x > 0 => s"$x"
}

val divide = new PartialFunction[Int, Int] {
	override def isDefinedAt(x: Int): Boolean = x != 0

	override def apply(x: Int) = 42 / x
}

if (divide.isDefinedAt(0)) divide(0)

//val divide2: PartialFunction[Int, Int] = {
//	case x if x != 0 => 42 / x
//}
//
//divide2(0)

val convert1To5: PartialFunction[Int, String] = new PartialFunction[Int, String] {
	val nums = Array("One", "Two", "Three", "Four", "Five")

	override def apply(i: Int): String = nums(i - 1)

	override def isDefinedAt(i: Int): Boolean = i > 0 && i <= nums.length
}

val convert5To10: PartialFunction[Int, String] = new PartialFunction[Int, String] {
	val nums = Array("Six", "Seven", "Eight", "Nine", "Ten")

	override def apply(i: Int): String = nums(i - 6)

	override def isDefinedAt(i: Int): Boolean = i >= nums.length && i <= nums.length + 5
}

val convert1To10 = convert1To5 orElse convert5To10

if (convert1To10.isDefinedAt(1)) convert1To10(7)
