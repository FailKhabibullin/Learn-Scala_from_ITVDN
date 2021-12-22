package lessons.modules.module_Scala_Essential.lesson_03_Objects

object Hello extends App {
	if (!args.isEmpty) println(s"Hello, ${args(0)}") else println("Hello, world!")
}