import scala.collection.AbstractSeq

class Pair[T, S](val first: T, val second: S) {
	override def equals(rVal: Any): Boolean = rVal match {
		case that: Pair[T, S] => {
			first == that.first && second == that.second
		}
		case _ => false
	}
}


val pair1 = new Pair(1, "Second")
val pair2 = new Pair[Any, Any](1, "Second")
pair1 == pair2

case class Pair1[T, S](val first: T, val second: S)

val p1 = new Pair(1, "Second")
val p2 = new Pair[Any, Any](1, "Second")

p1 == p2


def getMiddle1[T](a: Array[T]): T = a(a.length / 2)

getMiddle1(Array(1, 2, 3, 4, 5, 6))

val f = getMiddle1[Int] _

f(Array(1, 2, 3, 4, 5))

// Upper bound SubType <: SuperType
// Принимает только подТипы AbstractSeq[S]
def getMiddle2[S, T](a: T)(implicit ev: T <:< AbstractSeq[S]): S = {
	a(a.length / 2)
}

getMiddle2[Int, List[Int]](List(1, 2, 3, 4, 5))
getMiddle2[Int, Vector[Int]](Vector(1, 2, 3, 4, 5))

val middle = getMiddle2(Vector(1, 99, 3, 4, 16))

case class Pair2[T](first: T, second: T) {
	/**
	 * @return new Pair into replace first element
	 */
	def replace(newFirst: T): Pair2[T] =
		Pair2[T](newFirst, first)

	// Lower bound. SuperType >: SubType
	// Принимает только супер типы типа T
	def replace1[R >: T](newFirst: R) =
		Pair2[R](newFirst, first)
}


Pair2(1, 2).replace(100)

class Person {
	override def toString = "Person"
}

class Student extends Person {
	override def toString = "Student"
}

Pair2(new Person, new Person).replace1(new Student)

def firstLast[A, C](it: C)
                   (implicit evidence: C <:< Iterable[A]): (A, A) =
	(it.head, it.last)


firstLast(List(1, 2, 3))

trait Friend[-T] {
	def beFriend(someOne: T): Unit
}

class Person1 extends Friend[Person1] {
	override def beFriend(someOne: Person1): Unit =
		println(s"We are friend's")
}

class Student1 extends Person1

val susen = new Student1
val fred = new Person1

def makeFriendsWith(student1: Student1, friend: Friend[Person1]): Unit = {
	friend.beFriend(student1)
}


makeFriendsWith(susen, fred)

def friends(students: Array[Student1], find: Function1[Student1, Person1]) = {
	for (student <- students) yield find(student)
}

//def findStudent(person: Person1): Student1 => Person1

//friends(Array(new Student1), findStudent(new Person1))