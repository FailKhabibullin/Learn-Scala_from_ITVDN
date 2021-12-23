package lessons.modules.module_02_Scala_Essential.lesson_04_Composition_and_Inheritance.compositon

abstract class Element {
	def contents: Array[String]

	def height: Int = contents.length

	def width: Int =
		if (contents.isEmpty) 0
		else contents(0).length

	def above(that: Element): Element = {
		new ArrayElement(contents ++ that.contents)
	}

	def beside(that: Element): Element = {
		val zipped = contents zip that.contents
		new ArrayElement(
			for {

				(line1, line2) <- zipped
			}
			yield line1 + line2
		)
	}

	override def toString: String = contents.mkString("\n")
}
