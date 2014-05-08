(function(){
	
	var GuiceBundle = new JavaImporter(com.google.inject);
	
	with (GuiceBundle) {
		
		var Module = Java.extend(AbstractModule, {
			configure: function(){
				
			}
		});
		
		var injector = Guice.createInjector(new Module());
		var myClassImpl = injector.getInstance(Java.type("demo.classes.MyClass").class)
		
		myClassImpl.doSomething();
		
		return java.lang.System.getenv();
	}
	
	
	
	
	
})()