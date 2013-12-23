package com.maxm.pattern.single;

import com.maxm.pattern.util.PrintUtil;

// 平凡调用的时候效果较好
public class SigletonWithSyncOnce {
	// 线程为了提高效率，将某成员变量(如A)从主存拷贝了一份（如B）到线程工作内存，线程中对A的访问其实访问的是B。只在某些动作时才进行A和B的同步。因此存在A和B不一致的情况。
	// 而volatile告诉jvm， 它所修饰的变量不在线程工作内从中保留拷贝，直接访问主存中的.
	private volatile static SigletonWithSyncOnce sigleton;

	private SigletonWithSyncOnce() {
	}

	// 只有第一次调用时，才进入同步块,性能不错,同步块最多进入2次，第二次不会进入if语句块，可以保证单例
	public static SigletonWithSyncOnce getInstance() {
		if (sigleton == null) {
			PrintUtil.println(Thread.currentThread().getName() + " first enter if");
			synchronized (SigletonWithSyncOnce.class) {
				// 假如之前线程已执行过此创建代码，因为sigleton是volatile的，所以线程当前操作的是主从中的对象，而不是线程本地内存的。
				// 所以也可以保证new操作只执行一次，从而保证单例
				PrintUtil.println(Thread.currentThread().getName() + " first enter synchronized ");
				if (sigleton == null) {
					sigleton = new SigletonWithSyncOnce();
					PrintUtil.println(Thread.currentThread().getName() + " create obj");
				}
			}
		}
		return sigleton;
	}
}
