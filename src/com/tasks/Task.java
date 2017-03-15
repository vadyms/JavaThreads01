package com.tasks;

public class Task implements Runnable {
	int time;
	Task tempTask;
	public TaskManager tmTemp;
	@Override
	public void run() {
		try {
			Thread.sleep((long)time*1000);
			tmTemp.insertJobReoccurence(1,1,5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
