package com.hive;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

	@RequestMapping("/main.mc")
	public ModelAndView main() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("main");
		return mv;
	}

	@RequestMapping("/chart.mc")
	public ModelAndView chart(HttpServletResponse res) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("centerpage", "chart");
		mv.setViewName("main");
		return mv;
	}


}
