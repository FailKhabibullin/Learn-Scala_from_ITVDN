import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.{Future, Promise}
import scala.util.{Failure, Success}

val future = Future {
	Thread.sleep(10)
	2 + 55
}

Thread.sleep(10)

//& Check of complete
//? if complete return true
//? else return false
future.isCompleted

//& If computed func then
//? return Some(result) or
//? return None
future.value

val futureMap = future.map(x => x + 1)


Thread.sleep(20)

// Async traverse future result
val futureFor: Future[Int] = for {
	x <- future
	y <- futureMap
} yield x + y

Thread.sleep(10)

futureFor.value

//val f = for {
//	x <- Future {
//		Thread.sleep(10)
//		21 + 21
//	}
//	y <- Future {
//		Thread.sleep(10)
//		21 + 21
//	}
//} yield x + y
//
//Thread.sleep(10)
//
//f.value

//! Create to write the completed result
Future.successful(2 + 2)

//! Create to write the incomplete result
Future.failed(new StackOverflowError("Stop"))

//! Create new complete depend on parameter
Future.fromTry(Success(2 + 2))
Future.fromTry(Failure(new Exception("Stop!")))

val promise = Promise[Int]
val future5 = promise.future

promise.failure(new Exception)
future5.value


val f6 = Future(7)
//! Work only with Success(T)
val valid = f6.filter(_ > 0)
val inValid = f6.filter(_ < 0)
valid.value
inValid.value

val valid1 =
	for {res <- f6 if res > 0}
		yield res

val InValid1 =
	for {res <- f6 if res < 0}
		yield res

valid1.value
InValid1.value

val valid2 = f6 collect {
	case res if (res > 0) => res + 10
}
val inValid2 = f6 collect {
	case res if (res < 0) => res + 10
}
valid2.value
inValid2.value

val f7 = Future(1 / 0)
//! Метод failed возвращает Success() если раньше была ошибка
f7.failed

//? Метод работает только тем кто выбрасывает исключения
//& если нет ошибки то возвращает Failure() где выбрасывает новую ошибку
f6.failed
val f8 = f7.failed

f8.value



// If f7 is Failure then return f6 result
f7.fallbackTo(f6)

// If f7 is Failure and f6 is Failure then return f7 result
f7.fallbackTo(inValid)

//& Если найдёт совпадающий тип Exception,
//? то вернёт result case'а
//? если нет то вернёт result Success()
val f9 = f7 recover {
	case res: ArithmeticException => -1
}

f9.value

//& Если найдёт совпадающий тип Exception,
// то возвращает новый Future объект с результатом case
val f10 = f7 recoverWith {
	case _: ArithmeticException => Future(-1)
}

f10.value

val transform = f7 transform(
	//& Если всё нормально мы можем вернуть обычное значение
	//? и выполнит с ним действия
	res => res * -1,

	//& Если произойдёт какая нибудь ошибка,
	//? то будет свой новый Exception
	ex => new IllegalArgumentException("my exc")
)

transform.value


Thread.sleep(1000)