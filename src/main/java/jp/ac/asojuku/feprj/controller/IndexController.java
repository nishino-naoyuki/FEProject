package jp.ac.asojuku.feprj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
	@RequestMapping(value= {"top","/"}, method=RequestMethod.GET)
	public ModelAndView top(ModelAndView mv,@RequestParam(name="flg", required = false)Boolean flg) {
		
		if( flg != null ) {
			mv.addObject("flg", flg);
		}else {
			mv.addObject("flg", false);
		}
		mv.setViewName("top");
		
		return mv;
	}

}
