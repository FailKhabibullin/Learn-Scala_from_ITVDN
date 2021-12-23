package lessons.modules.module_02_Scala_Essential.lesson_04_Composition_and_Inheritance.compositon

class ArrayElement(conts: Array[String]) extends Element {
	override def contents: Array[String] = conts
}
