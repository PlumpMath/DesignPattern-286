package com.maxm.pattern.single;

import com.maxm.pattern.util.PrintUtil;

public class Main {
	static class WorkThread implements Runnable {
		@Override
		public void run() {
			work();
		}

		static void work() {
			for (int i = 0; i < 1000; i++) {
				SigletonWithSyncOnce.getInstance();
			}
		}

		static WorkThread getOne() {
			return new WorkThread();
		}
	}

	public static void main(final String[] args) {
		PrintUtil.println("start");
		for (int i = 0; i < 10000; i++) {
			new Thread(WorkThread.getOne()).start();
		}
		PrintUtil.println("over");
	}
}
