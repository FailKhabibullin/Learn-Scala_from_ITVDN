package homeWorks.module_Scala_Advanced.homeWork_08.task_03


import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.util.Random

object ErrorHandling extends App {
	val list: List[Int] = List.fill(1_000_000)(Random.nextInt(1_000_000))

	def mean(list: List[Int], maybeException: => Int): Int = {
		maybeException
		list.sum / list.length
	}

	val future = Future(mean(list, throwMaybeException))

	def throwMaybeException = if (Random.nextInt(2) == 1) throw new Exception else 1

	Thread.sleep(10)

	val futureResult = future recover {
		case _: Exception => "Error handling"
		case res => s"Work $res"
	}

	println(futureResult)


}
