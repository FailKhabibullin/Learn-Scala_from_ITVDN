import scala.util.{Failure, Success, Try}

def sqrtException(x: Int) =
	if (x >= 0) Math.sqrt(x)
	else throw new IllegalArgumentException("x should be negative")

class MyException extends Exception("MyException")

def sqrtMyException(x: Int) =
	if (x >= 0) Math.sqrt(x)
	else throw new MyException

//sqrtException(2)

//sqrtMyException(-3)

val a: Double = try {
	sqrtMyException(9)
} catch {
	case _: MyException =>
		println("It's my exception")
		0.0
	case ex: Exception =>
		println(ex.getMessage)
		0.0
	case _: Throwable =>
		println("Something went wrong")
		0.0
}

def toIntMethod(x: String): Option[Int] = {
	try {
		Some(Integer.parseInt(x.trim))
	} catch {
		case _: Throwable => None
	}
}

toIntMethod("que") match {
	case Some(x) => println(x)
	case None => println("Exception")
}

val y = for {
	a <- toIntMethod("1")
	b <- toIntMethod("2")
	c <- toIntMethod("3")
} yield a + b + c

def toIntTry(str: String): Try[Int] = Try(Integer.parseInt(str))

toIntTry("2")
toIntTry("dge").getOrElse(0)

val res = toIntTry("sf") match {
	case Success(value) =>
		println(value)
		value
	case Failure(exception) =>
		println("Exception Failure")
		0
}

val yTry = for {
	a <- toIntTry("1")
	b <- toIntTry("2")
	c <- toIntTry("ewfr")
} yield a + b + c