import scala.collection.immutable.HashMap

case class Counter() {

	import Counter.{count, newCount}

	val id = newCount()
	count = 5
}

object Counter {

	private var count = 0

	private def newCount(): Int = {
		count += 1
		count
	}

	println("Object")
}

//val counter = new Counter()

val c1 = Counter()
val c2 = Counter()

c1.id
c2.id

abstract class UndoableAction(val description: String) {
	def undo(): Unit

	def redo(): Unit
}

class DoNothing(description: String) {}

object DoNothing extends UndoableAction("Do Nothing") {
	override def undo(): Unit = {}

	override def redo(): Unit = {}

	def apply(description: String): DoNothing =
		new DoNothing(description)
}


val nothing = DoNothing

val action = HashMap(
	"Open" -> DoNothing,
	"Save" -> DoNothing
)

Array("1", "2", "3")
Array.apply("1", "2", "3")

DoNothing("Do  Nothing from apply")

Array(Array(1, 2), Array(3, 4))

object TrafficLight extends Enumeration {
	val Red = Value("Super Red")
	val Yellow = Value(10, "Super Yellow")
	val Green = Value
}

TrafficLight.Red.id
TrafficLight.Yellow.id
TrafficLight.Green.id

def onTheRoad(color: TrafficLight.Value) = {
	import TrafficLight._

	color match {
		case Red => "Stop"
		case Yellow => "Attention"
		case Green => "Go"
		case _ => "Something went wrong!"
	}

	/*if (color == Red) "Stop"
	else if (color == Yellow) "Attention"
	else if (color == Green) "Go"
	else "Something went wrong!"*/
}

onTheRoad(TrafficLight.Yellow)

for (color <- TrafficLight.values) {
	println(s"${color.id}: $color")
}

TrafficLight(0)
TrafficLight.withName("Super Red")