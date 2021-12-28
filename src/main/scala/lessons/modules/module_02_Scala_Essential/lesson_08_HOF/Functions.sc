import java.lang.Math.{abs, addExact, ceil, sqrt}

val function1: Double => Double = ceil
val function2: Double => Double = sqrt

val number = 6.9
function1(number)

Array(3.14, 0.24).map(function1)
Array(3.14, 0.24).map(x => x + 1)
Array(3.14, 0.24).map(_ + 1)
Array(3.14, 0.24).map(_ + 1)
Array(3.14, 0.24).map { x =>
	x + 1
}

val fun1 = 2 * (_: Int)
val fun2: Int => Int = 2 * _

def highOrderFunc(
	                 f: => Double => Double,
	                 value: Double) =
	f(value)

highOrderFunc(function1, 5)
highOrderFunc(function2, 9.9)

def add(value: Int) = (x: Int) => 1 + x
def mult(value: Int) = (x: Int) => value * x

val addUsing = add(1)
val addUsing2 = add(2)


addUsing(10)

def highOrderFunc2(f: Int => Int => Int,
                   value: Int): Int => Int = f(value)

val highOrderFunc2Add = highOrderFunc2(add, 22)
highOrderFunc2Add(1)

val highOrderFunc2Mult = highOrderFunc2(mult, 22)
highOrderFunc2Mult(1)

highOrderFunc2(mult, 22)(2)

def highOrderF3(f: => Int => Int => Int,
                v1: Int, v2: Int): Int = {
	f(v1)(v2)
}

highOrderF3(add, 1, 2)
highOrderF3(mult, 1, 2)

(1 to 9).map(_ + 1)
(1 to 9).map("*" * _).foreach(println)

(1 to 9).filter(_ % 2 == 0)

(1 to 9).reduce(_ * _)

"Hello, World hello sea sun breeze"
	.split(" ")
	.sortWith((x, y) => x.length < y.length)