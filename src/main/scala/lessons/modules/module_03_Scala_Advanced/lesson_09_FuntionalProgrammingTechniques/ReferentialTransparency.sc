val x = "Hello, World!"

val r1 = x.reverse
val r2 = x.reverse

val r1 = "Hello, World!".reverse
val r2 = "Hello, World!".reverse

val x = new StringBuilder("Hello")

val y = x.append(", World!")

val r1 = y.toString()
val r2 = y.toString()

val x2 = new StringBuilder("Hello")

val r1 = x2.append(", World!").toString()
val r2 = x2.append(", World!").toString()


def if2[A](cond: Boolean, onTrue: => A, onFalse: => A) =
	if (cond) onTrue else onFalse

if2(cond = false, sys.error("Failed"), 3)

def pair(i: => Int) = {
	lazy val j = i
	j
	(5, 5)
}

pair {
	println("hi")
	7
}

val rnd = new java.util.Random
rnd.nextDouble
rnd.nextInt

trait Random {
	def nextInt: Int

	def nextDouble: Double
}

trait RND {
	def nextInt: (Int, RND)

	def nextDouble: Double
}