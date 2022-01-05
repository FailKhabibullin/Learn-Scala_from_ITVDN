val l = List(1, 2, 3, 4, 5)
val l1 = 1 :: 2 :: 3 :: Nil

l.head
l.tail
l.isEmpty

val emptyList1 = Nil
val emptyList2 = List()

//emptyList1.head
//emptyList1.tail

def insert[T <: Int](x: T, xs: List[T]): List[T] = {
	if (xs.isEmpty || x <= xs.head) x :: xs
	else xs.head :: insert(x, xs.tail)
}

def sort[T <: Int](xs: List[T]): List[T] = {
	if (xs.isEmpty) Nil
	else insert(xs.head, sort(xs.tail))
}

sort(l)

val List(a, b, c) = l1
a
b
c

def insertPattern[T <: Int](x: T, xs: List[T]): List[T] = {
	xs match {
		case Nil => List(x)
		case y :: ys => if (x <= y) x :: xs.tail
		else y :: insert(x, ys)
	}
}

def sortPattern[T <: Int](xs: List[T]): List[T] = {
	xs match {
		case Nil => Nil
		case z :: zs => insertPattern(z, insertPattern(z, zs))
	}
}


sortPattern(l)
val ys = List(4, 5, 6)

// Merging list
val xs = List(1, 2, 3)

val zs = List("04", "05", "06")

xs ::: ys
ys.:::(xs)
ys ::: xs ::: zs
xs :: zs

// O(n)
xs.length
xs.init // All list EXCEPT last element

// O(1)
xs.head
xs.tail

//emptyList1.last
//emptyList1.init

xs.reverse
xs

val n = 2

xs take n // Take first n element
xs drop n // Drop first n elements and take others

xs splitAt n

xs apply n
xs(n)

(xs drop n).head

xs.indices.toList
xs.toArray

val arr = Array(5, 6, 7)

xs.copyToArray(arr, 1)
arr

val iter = xs.iterator // Stands in front the zero element
val iterCopy = xs.iterator

iter.next() // First element
iter.next() // Second element

iterCopy.length

val xss = List(xs, ys)

xss
xss.flatten

val zipped = xs.zipWithIndex
xss.zipWithIndex
zipped.unzip

xs.mkString
xs.mkString("|")
xs.mkString("*", "|", "*")

val words = List("One", "Two", "Three")
words.map(_.toList)
words.map(_.toList).flatten
words.flatMap(_.toList)

words.partition(_.length > 3)

words.find(_.length == 3)

