package lessons.modules.module_01_Scala_Start.lesson_003_Basic_of_Scala_on_example_of_first_program

import scala.io.StdIn

/**
 * @author Fail Khabibullin
 *         This program print input Name.
 */

object Hello {
  def main(args: Array[String]): Unit = {
    val name = StdIn.readLine()

    println(s"Hello, $name")
  }
}