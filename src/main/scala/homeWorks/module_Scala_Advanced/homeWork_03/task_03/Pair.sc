def middle[T, S](iterable: T)(implicit ev: T <:< Iterable[S]): S = {
	if (iterable.isEmpty) throw new NoSuchElementException("Empty iterable") else iterable.toSeq(iterable.size / 2)
}


middle(List(1, 2, 3, 4))