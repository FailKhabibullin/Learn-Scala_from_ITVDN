import scala.annotation.tailrec

// Anonimous function or Function literal
val mult = (x: Int, y: Int) => x * y
println(mult(1, 2))

val getTheAnswer = () => 42
println(getTheAnswer())


val addOne: Function1[Int, Int] = (x: Int) => x + 1
println(addOne(1))

println(List(1, 2, 3).product)

// Function
def abs(x: Int): String =
	if (x >= 0) "x"
	else s"${-x}"
abs(-2)

def example(f: Int => Int, x: Int): Int = {
	f(x)
	99
}

example(x => x + 1, 4)

// Recursion

def factorial(n: Int): Int = {
	@tailrec
	def recursion(n: Int, acc: Int = 1): Int = {
		if (n <= 0) acc else recursion(n - 1, acc * n)
	}

	recursion(n)
}

println(factorial(4))

// Default arguments
def beautifulString(left: String = "*** ",
                    s: String,
                    right: String = " ***"
                   ): String = {
	s"$left$s$right"
}

beautifulString("###", "Hello")

// Variable number of args

def sum(args: Int*): Int = {
	var result: Int = 0

	for (arg <- args) {
		result += arg
	}

	result
}

sum(1, 2, 3)

// Procedures
def prettyString(s: String, left: String = "*", right: String = "*": String): Unit = {
	println(left + s + right)
	99
}

prettyString("Hello, World!")