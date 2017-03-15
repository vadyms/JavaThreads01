package com.tasks;

public interface ITaskManager {
	
	public void insertJobReoccurence(int id, int priority, int time);
	public void getNextTask();
	
}
