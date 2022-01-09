import scala.annotation.tailrec

@tailrec
def unless(condition: => Boolean)
          (block: => Unit): Unit = {
	if (condition) {
		block
		unless(condition)(block)
	}
}

var x = 10
unless(x != 0) {
	x -= 1
	println("UnLess")
}