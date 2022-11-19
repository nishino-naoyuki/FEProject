package jp.ac.asojuku.feprj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller(value="/ans")
public class AnswerController {

	@RequestMapping(value= {"/q1"}, method=RequestMethod.GET)
	public String helloWorld() {
		return "index";
	}
}
