package pl.bartekde.booktradingspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

	@GetMapping("/")
	public String showHome() {
		return "home";
	}
	
	@GetMapping("books")
	public String showBooks() {
		return "books";
	}
	
	@GetMapping("/panel")
	public String showPanel() {
		return "panel";
	}
	
}
