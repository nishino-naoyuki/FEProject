package jp.ac.asojuku.feprj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import jp.ac.asojuku.feprj.form.Answer1Form;
import jp.ac.asojuku.feprj.form.Answer2Form;
import jp.ac.asojuku.feprj.form.Answer3Form;
import jp.ac.asojuku.feprj.form.Answer4Form;

@Controller
public class AnswerController {

	/**
	 * 答え１
	 * 学籍番号とその合計ちが入っていればOK
	 * @param mv
	 * @param ansForm
	 * @return
	 */
	@RequestMapping(value= {"ans/q1"}, method=RequestMethod.POST)
	public ModelAndView ans1(ModelAndView mv,Answer1Form ansForm) {
		int inputAns = 0;
		int corectAns = 0;
		
		try {
			String orgNo = ansForm.getOrgno();
			//学籍番号を数値変換して合計値を取得
			for( int i=0; i<orgNo.length(); i++ ) {
				inputAns += Integer.parseInt(orgNo.substring(i, i+1));
			}
			corectAns = Integer.parseInt(ansForm.getAnswer());
		}catch(NumberFormatException e) {
			inputAns = -1;
		}
		System.out.println("inputAns="+inputAns+" corectAns="+corectAns);
		//一致するかどうかを確認
		if(inputAns == corectAns) {
			mv.addObject("msg","第１問");
			mv.addObject("img","coin1.png");
			mv.addObject("flg",false);
			mv.addObject("twitter",false);
			mv.setViewName("ans");
		}else {
			mv.addObject("flg",true);
			mv.setViewName("redirect:/top");
		}
		
		return mv;
	}

	/**
	 * 2問目
	 * 「がくせきばんごうさいしょとさいご」
	 * @param mv
	 * @param ansForm
	 * @return
	 */
	@RequestMapping(value= {"ans/q2"}, method=RequestMethod.POST)
	public ModelAndView ans2(ModelAndView mv,Answer2Form ansForm) {

		int inputAns = 0;
		int corectAns = 0;
		
		try {
			String orgNo = ansForm.getOrgno();
			//最初と最後（１文字目と７文字目）を取得
			if( orgNo != null) {
				corectAns = Integer.parseInt(orgNo.substring(0, 1))*10;
				corectAns += Integer.parseInt(orgNo.substring(6, 7));
			}
			inputAns = Integer.parseInt(ansForm.getAnswer());
		}catch(NumberFormatException e) {
			inputAns = -1;
		}
		System.out.println("inputAns="+inputAns+" corectAns="+corectAns);
		//一致するかどうかを確認
		if(inputAns == corectAns) {
			mv.addObject("msg","第2問");
			mv.addObject("img","coin2.png");
			mv.addObject("flg",false);
			mv.addObject("twitter",false);
			mv.setViewName("ans");
		}else {
			mv.addObject("flg",true);
			mv.setViewName("redirect:/top");
		}
		
		return mv;
	}
	

	/**
	 * 3問目
	 * 「このがっこうのなまえはなんだっけ」
	 * @param mv
	 * @param ansForm
	 * @return
	 */
	@RequestMapping(value= {"ans/q3"}, method=RequestMethod.POST)
	public ModelAndView ans3(ModelAndView mv,Answer3Form ansForm) {
		String corectAns = "FEヒーローアカデミア";
		
		if( ansForm.getAnswer() != null && corectAns.equals(ansForm.getAnswer())) {
			mv.addObject("msg","第3問");
			mv.addObject("img","coin3.png");
			mv.addObject("flg",false);
			mv.addObject("twitter",true);
			mv.setViewName("ans");
		}else {
			mv.addObject("flg",true);
			mv.setViewName("redirect:/top");
		}
		return mv;

	}

	/**
	 * 4問目
	 * 「そうとくのたんじょうびはちけたでこたえろ」
	 * @param mv
	 * @param ansForm
	 * @return
	 */
	@RequestMapping(value= {"ans/q4"}, method=RequestMethod.POST)
	public ModelAndView ans3(ModelAndView mv,Answer4Form ansForm) {
		String corectAns = "19770314";
		
		if( ansForm.getAnswer() != null && corectAns.equals(ansForm.getAnswer())) {
			mv.addObject("msg","第4問");
			mv.addObject("img","coin4.png");
			mv.addObject("flg",true);
			mv.addObject("twitter",false);
			mv.setViewName("ans");
		}else {
			mv.addObject("flg",true);
			mv.setViewName("redirect:/top");
		}
		return mv;

	}
	
	@RequestMapping(value= {"10100110"}, method=RequestMethod.GET)
	public ModelAndView ans3(ModelAndView mv) {
		mv.addObject("img","mao.png");
		mv.setViewName("mao");
		return mv;
	}

	@RequestMapping(value= {"11010100"}, method=RequestMethod.GET)
	public ModelAndView sotokutwitter(ModelAndView mv) {
		mv.addObject("headerlogo", "logo.png");
		mv.addObject("icon", "sotoku_twitter.png");
		mv.addObject("name", "裏総督");
		mv.setViewName("twitter2");
		return mv;
	}
}
