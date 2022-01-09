def hofCurringIntSumResultConvertToLong(num: Int)(f: Int => Long): Long = {
	f(num) + f(num)
}

hofCurringIntSumResultConvertToLong(146150164E47.toInt)(x => x.toLong)