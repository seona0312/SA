package com.example.restservice;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;


@RestController
public class GreetingController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	private Log log = LogFactory.getLog(this.getClass());

	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
	
	@GetMapping("/oauth/token")
	public Map token(@RequestBody Object obj, HttpServletRequest request, HttpServletResponse response) {
		Map res = new HashMap();
		res.put("status_code", 200);
		res.put("description", "Success");
		return res;
	}
	
	@PostMapping(value="/Aaa/aa", consumes = "application/json")
	public Map attr(@RequestBody Object obj, HttpServletRequest request, HttpServletResponse response) {
		String auth = request.getHeader("Authorization");
		log.info("Authorization: " + auth);
		
		if ( auth == null || !auth.equals("Bearer abcde")) {
			try {
				response.sendError(401, "UnAuthorization");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		Map res = new HashMap();
		res.put("status_code", 200);
		res.put("description", "Success");
		return res;
	}
	
	@PostMapping(value="/Bbb/bb", consumes = "application/json")
	public Map tele(@RequestBody Object obj, HttpServletRequest request, HttpServletResponse response) {
		String auth = request.getHeader("Authorization");
		log.info("Authorization: " + auth);
		log.info(auth.equals("Bearer abcde"));
		
		if ( auth == null || !auth.equals("Bearer abcde")) {
			try {
				response.sendError(401, "UnAuthorization");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		Map res = new HashMap();
		res.put("status_code", 200);
		res.put("description", "Success");
		return res;
	}
	
	@PostMapping(value="/Aaa/aaa", consumes = "application/json")
	public Map attrV2(@RequestBody Object obj, HttpServletRequest request, HttpServletResponse response) {
		
		Map res = new HashMap();
		res.put("status_code", 200);
		res.put("description", "Success");
		return res;
	}
	
	@PostMapping(value="/Bbb/bbb", consumes = "application/json")
	public Map teleV2(@RequestBody Object obj, HttpServletRequest request, HttpServletResponse response) {
		
		Map res = new HashMap();
		res.put("status_code", 200);
		res.put("description", "Success");
		return res;
	}
}

