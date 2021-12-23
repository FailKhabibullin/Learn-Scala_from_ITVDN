import scala.language.postfixOps

abstract class Element {
	def contents: Array[String]

	def height: Int = contents.length

	def width: Int = if (contents.isEmpty) 0 else contents(0).length

	def above(that: Element): Element = {
		new ArrayElement(this.contents ++ that.contents)
	}

	def besides(that: Element): Element = {
		new ArrayElement(for ((line1, line2) <- contents zip that.contents) yield line1 + line2)
	}

	override def toString = contents.mkString("\n")
}

class ArrayElement(val conts: Array[String]) extends Element {
	override def contents: Array[String] = conts

	println(s"ArrayElement, Height: $height, Width: $width")
}

val arrayElement = new ArrayElement(Array("Hello", "World"))

arrayElement.height
arrayElement.width

val a: Element = new ArrayElement(Array("Hello"))

class LineElement(s: String) extends Element {
	override val height = s.length
	override val width = 1

	println(s"LineElement, Height: $height, Width: $width")

	val contents = Array(s)
}

val lineElement = new LineElement("LineElement")
lineElement.height
lineElement.width

class UniformElement(char: Char, override val width: Int, override val height: Int) extends Element {
	private val line = char.toString * width

	def contents: Array[String] = Array.fill(height)(line)

	println(s"UniformElement, Height: $height, Width: $width")
}


val element1: Element = new ArrayElement(Array("Hello"))


val arrayElement1: Element = new LineElement("123")

val element2: Element = element1

val element3: Element = new UniformElement('*', 2, 5)


arrayElement1.contents

abstract class E {
	def demo(): Unit = println("E invoked")
}

class AE extends E {
	override def demo(): Unit = println("AE invoked")
}

class LE extends AE {
	override def demo(): Unit = println("LE invoked")
}

class UE extends E {
	override def demo(): Unit = super.demo()
}

def invokeDemo(e: E): Unit = {
	e.demo()
}


invokeDemo(new AE)
invokeDemo(new LE)
invokeDemo(new UE)

val column1 = new ArrayElement(Array("Hello")) above new ArrayElement(Array("***"))
val column2 = new ArrayElement(Array("***")) above new ArrayElement(Array("Hello"))

column1 besides column2