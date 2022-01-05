import scala.util.Random

val integerList = List.fill(20)(Random.between(0, 5))

def removeZeroElement[T <: Int](list: List[T]): List[T] = {
	list.filter(_ != 0)
}

removeZeroElement(integerList)
