package com.tasks;

public class GetTasks implements Runnable {
	
	TaskManager tm;

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			tm.listTasks();
			System.out.println(tm.getNextTask());
		}
	}

	public GetTasks(TaskManager tm) {
		super();
		this.tm = tm;
	}
	
}
