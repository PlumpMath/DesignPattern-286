package com.maxm.pattern.single;

public class Book {
	private static class LazyBook {
		// 这么写，可以保证在jvm加载Book.class时不会创建对象，
		// 只有在首次调用getBook的时候才创建一次,实现了延迟实例化,并且是单例
		static Book book = new Book();
	}

	public static Book getBook() {
		// 访问LazyBook中的静态域book，会导致类LazyBook的初始化过程（静态域的赋值和静态代码块的执行）。 
		return LazyBook.book;
	}
}
