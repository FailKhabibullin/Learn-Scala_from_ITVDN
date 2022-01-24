object Extractor {

	def apply(arg: String*): Seq[String] = arg.map(_.toLowerCase())

	def unapplySeq(arg: Seq[String]): Option[Seq[String]] =
		if (arg.head == arg.head.toLowerCase()) Some(Seq(arg.head, arg.tail.head))
		else None
}

val word1 = Extractor("MAIL", "com")
val word2 = Extractor("Hello")

word1 match {
	case Extractor("mail", _*) => "found"
	case _ => "not found"
}