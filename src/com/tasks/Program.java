package com.tasks;

public class Program {

	public static void main(String[] args) throws InterruptedException {
		TaskManager tm = new TaskManager(5);
		Thread tc;
		Thread tg;
		//while(true) {

			tc = new Thread(new CreateTasks(tm));
			tc.start();
			
			tg = new Thread(new GetTasks(tm));
			tg.start();
			tm.listTasks();
		//}

	}
}
