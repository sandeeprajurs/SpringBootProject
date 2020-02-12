package com.todo.webapp.restfulwebservices.todo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TodoHardcodedService {
	
	private static List<Todo> todos = new ArrayList<Todo>();
	private static int idCounter = 0;
	
	static {
		todos.add(new Todo(++idCounter, "in28minutes", "Learn to dance", new Date(), false));
		todos.add(new Todo(++idCounter, "in29minutes", "Learn to sing", new Date(), false));
		todos.add(new Todo(++idCounter, "in30minutes", "Learn to code", new Date(), true));
		todos.add(new Todo(++idCounter, "in40minutes", "Learn to draw", new Date(), false));
		todos.add(new Todo(++idCounter, "in41minutes", "Learn to swim", new Date(), true));
	}
	
	public List<Todo> findAll(){
		return todos;
	}
	
	public Todo deleteById(long id) {
		Todo todo = findToById(id);
		todos.remove(todo);
		if(todo == null) return null;
		return todo;
	}

	public Todo findToById(long id) {
		for(Todo todo:todos) {
			if(todo.getId() == id) {
				return todo;
			}
		}
		return null;
	}
	
	public Todo save(Todo todo) {
		if(todo.getId() == -1 || todo.getId() == 0) {
			todo.setId(++idCounter);
			todos.add(todo);
		}
		else {
			deleteById(todo.getId());
			todos.add(todo);
		}
		return todo;
	}
}
