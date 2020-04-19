package com.example.restservice;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.*;

@RestController
public class GreetingController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}

	@PostMapping("/publish")
	public void acknowledger(@RequestParam(value = "data", defaultValue = "no data") String data){
		System.out.println(data);
	}

	@PutMapping("/testput")
	public void publisher(){
		System.out.println("Publisher put request received....");
	}
}
