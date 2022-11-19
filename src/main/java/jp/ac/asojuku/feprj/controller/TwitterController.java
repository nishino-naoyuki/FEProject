package jp.ac.asojuku.feprj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TwitterController {

	@RequestMapping(value= {"twitter"}, method=RequestMethod.GET)
	public ModelAndView top(ModelAndView mv,@RequestParam(name="id", required = false)Integer id) {
		if( id==0 ) {
			mv.setViewName("twitter");
		}
		return mv;
	}
}
