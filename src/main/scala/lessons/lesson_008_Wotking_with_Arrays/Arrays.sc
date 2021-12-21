import scala.collection.mutable.ArrayBuffer
// Fixed array length

val nums = new Array[Int](10)

val s = new Array[String](5)

val a = Array("Hello", "World", 5)

a(0) = "Goodbye"
a

// Changeable array length
val b = ArrayBuffer[Int]()
b += 7

b += (1, 2, 3)

b addAll Array(8, 6)
b

b ++= ArrayBuffer(6, 5)
b.trimEnd(5)
b

b.insert(1, 20)
b

b.insert(3, 100)
b.remove(1)
b

b.remove(2, 2)
b

// ArrayBuffer to Array
b.toArray
b

b.toBuffer
b

for (i <- a.indices) println(a(i))

for (i <- a) println(i)

val result = for (i <- b) yield i * 2

val result2 = for (i <- b if i % 2 == 0) yield 2 * i

result.sum
result.min

b.sorted
b.toString
b.mkString("<", ", ", ">")

val matrix = Array.ofDim[Double](3, 4)
matrix(1)(2)