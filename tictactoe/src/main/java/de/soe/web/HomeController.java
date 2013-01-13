package de.soe.web;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

@Controller
@RequestMapping("/")
public class HomeController {

	@RequestMapping(method = GET)
	public ModelAndView show() {
		return new ModelAndView("index");
	}
	
}
