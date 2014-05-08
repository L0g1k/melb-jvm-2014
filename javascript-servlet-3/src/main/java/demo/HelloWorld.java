package demo;

import java.io.IOException;
import java.io.InputStreamReader;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.AbstractHandler;

public class HelloWorld extends AbstractHandler {
	
	
	public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		ScriptEngineManager engineManager = new ScriptEngineManager();
		ScriptEngine engine = engineManager.getEngineByName("nashorn");
		
		try {
			Object evaluation = engine.eval(new InputStreamReader(getClass().getResourceAsStream("HelloWorld.js")));
			response.setStatus(HttpServletResponse.SC_OK);
			response.getWriter().println(evaluation);
		} catch (ScriptException e) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			response.getWriter().print(e.getMessage());
		} finally {
			baseRequest.setHandled(true);
		}
	}

	public static void main(String[] args) throws Exception {
		Server server = new Server(8081);
		server.setHandler(new HelloWorld());

		server.start();
		server.join();
	}
}
