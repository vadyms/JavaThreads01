package com.tasks;

public interface ITaskManager {
	
	public boolean insertReoccurenceTask(int id, int priority, int time);
	public boolean insertTask(int id, int priority);
	public int getNextTask();
	
}
