import scala.language.postfixOps

// Cyclic with pre-condition
var i = 0

val a: Unit = while (i < 3) {
	println(i)
	i += 1
}

// Cyclic with post-condition
var j = 0
do {
	println(j)
	j += 1
} while (j < 0)

// Cyclic with counter
val c: Unit = for (i <- 0 until 3) {
	println(i)
}

for (i <- "Hello") {
	println(i)
}

// Cyclic with rich-for
for (i <- 0 until 3; j <- 0 until 3 if i != j) {
	println(s"i = $i, j = $j")
}

// for-coprehension
for (i <- 0 until 3) yield i * 10

val d: Seq[Int] = for (i <- 0 until 3) yield i * 10