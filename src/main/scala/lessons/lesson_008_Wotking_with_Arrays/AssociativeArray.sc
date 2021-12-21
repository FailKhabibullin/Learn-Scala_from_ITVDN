import scala.collection.immutable.SortedMap
import scala.collection.{immutable, mutable}

val a = Map(("Anna", 25), ("Max", 48), ("Alex", 25))
val aMutable = mutable.Map("Anna" -> 25, ("Max" -> 48), "Alex" -> 33)

val alex = a("Alex")

//val name = a("Name")
val cont = a.contains("Name")

aMutable("Anna") = 30
aMutable

//a("Anna") = 30

aMutable += ("Bob" -> 22)
aMutable -= "Bob"

// Immutable array
val newA = a + ("Bob" -> 22)

for ((k, v) <- newA) {
	println(s"k = $k, v = $v")
}

newA.keys
newA.values

for ((k, v) <- newA) yield (v, k)

val sortedA = SortedMap(
	("Anna", 25), ("Max", 48), ("Alex", 33)
)