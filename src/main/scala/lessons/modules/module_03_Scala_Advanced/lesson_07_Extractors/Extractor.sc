object Email {
	def apply(user: String, domain: String): String = s"$user@$domain"

	//! Экстрактор. При Matching'е если условие true то,
	//? возвращает Tuple2 с двумя значениями, а если false то None
	def unapply(str: String): Option[(String, String)] = {
		val parts = str.split('@')
		if (parts.length == 2) Some((parts(0), parts(1)))
		else None
	}
}

val fail = Email("fail", "gmail.com")

val anotherStr = "123"

Email.unapply(fail)
Email.unapply(anotherStr)

"fail@gmail.com" match {
	case Email(user, domain) => s"${user}AT$domain"
	case _ => "Error! This word is not email!"
}

val x: Any = 123

x match {
	case Email(user, domain) => s"$user and $domain"
	case _ => "Error! This word is not email!"
}

"x" match {
	case Email(user, domain) => s"$user and $domain"
	case _ => "Error! This word is not email!"
}

"x@x.com" match {
	case Email(user, domain) => s"$user and $domain"
	case _ => "Error! This word is not email!"
}

object Twice {
	def apply(str: String): String = str + str

	def unapply(arg: String): Option[String] = {
		val length = arg.length / 2
		val half = arg.substring(0, length)
		if (half == arg.substring(length)) Some(half)
		else None
	}
}

object UpperCase {
	def unapply(arg: String): Boolean =
		arg.toUpperCase == arg
}

def UserTwiceUpper(str: String) = str match {
	case Email(Twice(x@UpperCase()), domain) =>
		x + " in domain" + domain
	case _ => "no match"
}

UserTwiceUpper("HIHI@mail.com")
UserTwiceUpper("hihi@mail.com")
UserTwiceUpper("hih@mail.com")
UserTwiceUpper("hello")

object Domain {
	def apply(parts: String*): String = parts.reverse.mkString(".")

	def unapplySeq(arg: String): Option[Seq[String]] =
		Some(arg.split("\\.").reverse)
}

def isAnnaInDotCom(s: String) = s match {
	case Email("anna", Domain("com", _*)) => true
	case _ => false
}

isAnnaInDotCom("anna@mail.com")
isAnnaInDotCom("anna@mail.ua")
isAnnaInDotCom("ivan@mail.com")