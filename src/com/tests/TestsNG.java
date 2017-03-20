package com.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.tasks.Task;
import com.tasks.TaskManager;

public class TestsNG {

	@Test
	public void testEmptyTaskManager() {
		TaskManager tm = new TaskManager(5);
		assertEquals(-1, tm.getNextTask());
	}
	
	@Test
	public void testOneElementTaskManager() {
		TaskManager tm = new TaskManager(5);
		tm.insertTask(1, 1);
		assertEquals(1, tm.getNextTask());
	}
	
	@Test
	public void testTaskGetters() {
		Task t = new Task(1,2,3);
		assertEquals(1, t.getId());
		assertEquals(2, t.getPriority());
		assertEquals(3, t.getTime());
	}
	
	@Test
	public void testTaskSetters() {
		Task t = new Task(1,2,3);
		t.setId(4);
		t.setPriority(5);
		t.setTime(6);
		assertEquals(4, t.getId());
		assertEquals(5, t.getPriority());
		assertEquals(6, t.getTime());
	}
	
	@Test
	public void testTaskToString() {
		Task t = new Task(1, 2, 3);
		assertEquals("Task #:1, p:2, t:3", t.toString());
	}
	
	@Test(timeout = 12)
	public void testTaskManagerAddReoccurenceTaskPriority1() {
		TaskManager tm = new TaskManager(1);
		tm.insertReoccurenceTask(1, 3, 10);
		assertEquals(1, tm.getNextTask());
	}

	@Test(timeout = 2)
	public void testTaskManagerAddReoccurenceTaskPriority2() {
		TaskManager tm = new TaskManager(1);
		tm.insertReoccurenceTask(2, 2, 2);
		assertEquals(2, tm.getNextTask());
	}

	@Test(timeout = 3)
	public void testTaskManagerAddReoccurenceTaskPriority3() {
		TaskManager tm = new TaskManager(1);
		tm.insertReoccurenceTask(3, 3, 2);
		assertEquals(3, tm.getNextTask());
	}
	
	@Test
	public void testInsertSameTask() {
		TaskManager tm = new TaskManager(2);
		tm.insertTask(1, 1);
		tm.insertTask(1, 2);
		assertEquals(1,tm.getNextTask());
		
	}
	
	@Test
	public void testTaskRun() {
		TaskManager tm = new TaskManager(2);
		Task t = new Task(1,1,1);
		t.tmTemp = tm;
		t.run();
		assertEquals(1,tm.getNextTask());
		
	}
	
	@Test(expected = NullPointerException.class)
	public void testTaskRunNoTaskManager() {
		TaskManager tm = new TaskManager(2);
		Task t = new Task(1,1,1);
		t.run();
		assertEquals(1,tm.getNextTask());
		
	}
}
