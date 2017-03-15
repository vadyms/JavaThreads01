package com.tasks;

public class Task implements Runnable {
	
	public TaskManager tmTemp;
	
	int id;
	int priority;
	int time;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}

	@Override
	public void run() {
		try {
			Thread.sleep((long)time*1000);
			tmTemp.insertReoccurenceTask(id, priority, time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public String toString() {
		return String.format("Task #:%s, p:%s, t:%s", this.id, this.priority, this.time  );
	}
	
	public Task(int id, int priority, int time) {
		super();
		this.id = id;
		this.priority = priority;
		this.time = time;
	}
	
}
