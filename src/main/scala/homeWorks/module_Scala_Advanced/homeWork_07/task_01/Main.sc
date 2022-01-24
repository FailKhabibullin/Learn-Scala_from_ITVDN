object Extractor {
	//	def apply(str: String): String = str + str

	def unapply(arg: String): Option[String] = {
		val halfLength = arg.length / 2
		val substringFirst = arg.reverse
		if (substringFirst == arg) Some(arg)
		else None
	}
}

val twice = "HIHI"

twice match {
	case Extractor(palindrome) => palindrome
	case _ => println("False")
}