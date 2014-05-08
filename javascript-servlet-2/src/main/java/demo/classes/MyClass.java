package demo.classes;

import com.google.inject.Inject;

public class MyClass {

	@Inject
	public MyClass() {
		
	}
	
	public void doSomething() {
		System.out.println("I'm doing things!");
	}
}
