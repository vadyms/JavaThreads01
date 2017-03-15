package com.tasks;

public class TaskManager implements ITaskManager {

	int tasksCount;
	@Override
	public void insertJobReoccurence(int id, int priority, int time) {
		tasksCount++;
		System.out.println("Inserted task" + id);;
		
	}

	@Override
	public void getNextTask() {
		Task t = new Task();
		t.tmTemp = this;
		Thread runAgain = new Thread(t);
		t.time = 5;
		runAgain.run();
	}

}
