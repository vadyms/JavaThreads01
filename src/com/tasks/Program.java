package com.tasks;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;

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
		
		
		
		
//		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//		
//		while (true) {
//	        System.out.print("Please enter action c - to create a task, g - to get a task, l - list tasks: ");
//	        String action = null;
//	        try {
//	        	action = reader.readLine();
//	        } catch (IOException e) {
//	            e.printStackTrace();
//	        } 
//	        System.out.println("You entered : " + action);
//	        if (action.equalsIgnoreCase("c")) {
//				int id = (int)(Math.random()*100);
//				int priority = (int)(Math.random()*3+1);
//				int time = (int)(Math.random()*10);
//				
//				System.out.println(tm.insertReoccurenceTask(id, priority, time));
//	        	
//	        } else if (action.equalsIgnoreCase("g"))  {
//	        	System.out.println(tm.getNextTask());	
//	        } else if (action.equalsIgnoreCase("l"))  {
//	        	tm.listTasks();
//	        } else {
//	        	System.out.println("Quit from service.");
//	        	break;
//	        }
//		}
		
		
		
		
	}
}
