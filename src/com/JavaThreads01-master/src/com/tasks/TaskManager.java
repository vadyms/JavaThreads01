package com.tasks;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TaskManager implements ITaskManager {
	
	List<Task> tasks = new ArrayList<Task>();
	int tasksCount;
	int tasksMaxCount;
	
	public TaskManager(int tasksMaxCount) {
		super();
		this.tasksMaxCount = tasksMaxCount;
	}

	@Override
	synchronized public boolean insertReoccurenceTask(int id, int priority, int time) {
		boolean result=false;
		if (tasksCount<tasksMaxCount) {
			result = true;
			addTask(id, priority, time);
		} else {
			result = false;
		}
		return result;
		
	}
	
	private void addTask(int id, int priority, int time) {
		Task t = new Task(id, priority, time);
		List<Task> detectTask=tasks.stream().filter(p -> p.id == id).collect(Collectors.toList());
		if (detectTask.size() == 0 ) {
			tasks.add(t);
			tasksCount++;
			System.out.println(String.format("Insert task #:%s, p:%s, t:%s", id, priority, time));
		} else {
			detectTask.get(0).setId(id);
			detectTask.get(0).setPriority(priority);
			detectTask.get(0).setTime(time);
			System.out.println(String.format("Update task #:%s, p:%s, t:%s", id, priority, time));
		}
	}

	@Override
	public boolean insertTask(int id, int priority) {
		return insertReoccurenceTask(id, priority, 0);
	}

	@Override
	synchronized public int getNextTask() {
		if (tasks.size()>0) {
			Task tm = getTask();
			if (tm.time>0) {
				tm.tmTemp = this;
				Thread runAgain = new Thread(tm);
				runAgain.start();
				tasks.remove(tm);
				tasksCount--;
			} else {
				tasks.remove(tm);
				tasksCount--;
			}
			return tm.id;
		}
		return -1;
	}
	
	void listTasks() {
		for(Task t:tasks) {
			System.out.println(t.toString());
		}
	}
	
	Task getTask() {
		Task resultTask=null;
		List<Task> filterPriority=tasks.stream().filter(p -> p.priority==1).collect(Collectors.toList());
		Comparator<Task> comp = (p1, p2) -> Integer.compare( p1.time, p2.time);
		if (filterPriority.size()!=0) {
		    Task max = filterPriority.stream().min(comp).get();
		    resultTask = max;
			return resultTask;
		}
		filterPriority=tasks.stream().filter(p -> p.priority==2).collect(Collectors.toList());
		if (filterPriority.size()!=0) {
		    Task max = filterPriority.stream().min(comp).get();
		    resultTask = max;
			return resultTask;
		}
		filterPriority=tasks.stream().filter(p -> p.priority==3).collect(Collectors.toList());
		if (filterPriority.size()!=0) {
		    Task max = filterPriority.stream().min(comp).get();
		    resultTask = max;
			return resultTask;
		}
		return resultTask;
	}

}
