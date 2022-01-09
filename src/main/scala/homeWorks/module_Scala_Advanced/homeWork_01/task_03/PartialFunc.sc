val partialFunc1: PartialFunction[Int, String] = {
	case x if x > 0 => "More zero"
	case y if y < 0 => "Negative"
	case _ => "Zero"
}

partialFunc1 match {
	case x => x
}

val partialFuncAction =
	new PartialFunction[Int, String] {
		override def isDefinedAt(x: Int) =
			x > 0 && x < 180

		override def apply(v: Int) = "Not-right angle"
	}

partialFuncAction(3)

if (partialFuncAction.isDefinedAt(181))
	partialFuncAction(181) // Check before run

val pf1: PartialFunction[Int, String] = {
	case 1 => "1"
	case 2 => "2"
}

val pf2: PartialFunction[Int, String] = {
	case 3 => "3"
	case 4 => "4"
}

// Combine the two partial function
val combinedPartialFunc = pf1 orElse pf2

combinedPartialFunc(4)