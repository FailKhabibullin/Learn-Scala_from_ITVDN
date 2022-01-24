object Extractor {
	def apply(arg: String): String = arg.toUpperCase

	def unapply(arg: String): Boolean =
		if (arg == arg.toUpperCase()) true
		else false
}


val wordLower = "hi"
val wordUpper = "HI"

wordLower match {
	case Extractor() => true
	case _ => false
}

wordUpper match {
	case Extractor() => true
	case _ => false
}
