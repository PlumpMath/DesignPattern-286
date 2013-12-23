package com.maxm.pattern.single;

public class SigletonWithSync {
	private static SigletonWithSync sigleton;

	private SigletonWithSync() {
	}

	// 每次调用都要同步，性能差，但保证单例
	public static synchronized SigletonWithSync getInstance() {
		if (sigleton == null) {
			sigleton = new SigletonWithSync();
		}
		return sigleton;
	}
}
