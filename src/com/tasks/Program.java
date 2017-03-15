package com.tasks;

public class Program {

	public static void main(String[] args) {
		TaskManager tasks = new TaskManager();
		tasks.insertJobReoccurence(1, 1, 5);
		tasks.getNextTask();
		tasks.getNextTask();
		System.out.println("Finished! Tasks count: "+tasks.tasksCount);

	}

}
