val opt: Option[String] = Some("opt")
val option: Option[String] = None

val intToStr = Map(1 -> "1", 2 -> "2")

intToStr.get(1) match {
	case Some(v) => v
	case None => 0
}

if (intToStr.get(0).isEmpty) "0" else intToStr.get(0)

intToStr.get(1).getOrElse("0")


for ((k, v) <- intToStr) println(v)

intToStr.get(10).isDefined


val a1 = intToStr.get(10)
val a2 = intToStr.get(1)

a1.map(_ + "map")
a2.map(_ + "map")

a2.filter(_ == "1")

a2.contains("1")
a2.exists(_.toInt.toString == "1")

a2.foreach(println)

class User(email: String, password: String) {
	var firstName: String = null
	var lastName: String = _
}

val null1 = new User("test", "testPasswd").firstName
val null2 = new User("test1", "testPasswd1").firstName

//null1.length


class UserOpt(email: String, password: String) {
	var firstName: Option[String] = None
	var lastName: Option[String] = None
}

val userOpt = new UserOpt("test", "testPasswd")

userOpt.firstName.map(_.length)
userOpt.firstName = Some("Max")
userOpt.firstName.map(_.length).getOrElse()

def doSomething: Option[User] = {
	None
}

def getName(user: User): Option[String] = {
	val name = user.lastName
	if (name == null) None else Some(name)
}

getName(new User("test", "testPasswd"))

def getNameOtp(user: User): Option[String] =
	Option(user.lastName)

getNameOtp(new User("test", "testPasswd"))

def toMax(str: String): String = {
	str.toUpperCase
}


userOpt.firstName.fold("None")(toMax)
None.fold("Default")(toMax)