package com.maxm.pattern.single;

// 很安全的单例
public class Sigleton {
	private static Sigleton sigleton = new Sigleton();

	private Sigleton() {

	}

	public static Sigleton getInstance() {
		return sigleton;
	}
}
