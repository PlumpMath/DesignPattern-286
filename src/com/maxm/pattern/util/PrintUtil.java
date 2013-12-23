package com.maxm.pattern.util;

import java.io.PrintStream;

public class PrintUtil {
	private static PrintStream out = System.out;

	public static void println(final Object obj) {
		out.println(obj);
	}

	public static void println() {
		out.println();
	}

	public static void main(final String[] args) {
		PrintUtil.println("test");
	}
}
