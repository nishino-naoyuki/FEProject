package jp.ac.asojuku.feprj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import jp.ac.asojuku.feprj.form.Answer1Form;
import jp.ac.asojuku.feprj.form.AnswerMaoForm;
import jp.ac.asojuku.feprj.form.BattleStartForm;

@Controller
public class BattleController {

	@RequestMapping(value= {"battle/start"}, method=RequestMethod.GET)
	public ModelAndView start(ModelAndView mv) {
		mv.addObject("id","");
		mv.setViewName("login");
		return mv;
	}
	@RequestMapping(value= {"battle/startb56c"}, method=RequestMethod.GET)
	public ModelAndView start2(ModelAndView mv) {
		mv.addObject("id","4ec5");
		mv.setViewName("login");
		return mv;
	}
	@RequestMapping(value= {"battle/start4148"}, method=RequestMethod.GET)
	public ModelAndView start3(ModelAndView mv) {
		mv.addObject("id","b044");
		mv.setViewName("login");
		return mv;
	}
	@RequestMapping(value= {"battle/start0b62"}, method=RequestMethod.GET)
	public ModelAndView start4(ModelAndView mv) {
		mv.addObject("id","aa86");
		mv.setViewName("login");
		return mv;
	}
	@RequestMapping(value= {"battle/mao"}, method=RequestMethod.POST)
	public ModelAndView mao(ModelAndView mv,BattleStartForm form) {
		mv.addObject("name",form.getName());
		mv.addObject("img","mao1.png");
		mv.addObject("bgm","boss1.mp3");
		mv.addObject("don","don.mp3");
		mv.addObject("ansurl","ans1");
		mv.setViewName("boss_battle");
		return mv;
	}
	@RequestMapping(value= {"battle/mao4ec5"}, method=RequestMethod.POST)
	public ModelAndView mao2(ModelAndView mv,BattleStartForm form) {
		mv.addObject("name",form.getName());
		mv.addObject("img","mao2.png");
		mv.addObject("bgm","boss2.mp3");
		mv.addObject("don","don.mp3");
		mv.addObject("ansurl","ans2");
		mv.setViewName("boss_battle");
		return mv;
	}
	@RequestMapping(value= {"battle/maob044"}, method=RequestMethod.POST)
	public ModelAndView mao3(ModelAndView mv,BattleStartForm form) {
		mv.addObject("name",form.getName());
		mv.addObject("img","sotoku1.png");
		mv.addObject("bgm","boss3.mp3");
		mv.addObject("don","don.mp3");
		mv.addObject("ansurl","ans3");
		mv.setViewName("boss_battle");
		return mv;
	}
	@RequestMapping(value= {"battle/maoaa86"}, method=RequestMethod.POST)
	public ModelAndView mao4(ModelAndView mv,BattleStartForm form) {
		mv.addObject("name",form.getName());
		mv.addObject("img","sotoku1.png");
		mv.addObject("bgm","boss4.mp3");
		mv.addObject("don","don.mp3");
		mv.addObject("ansurl","ans3");
		mv.setViewName("boss_battle");
		return mv;
	}
	@RequestMapping(value= {"battle/ans1"}, method=RequestMethod.POST)
	public ModelAndView ans1(ModelAndView mv,AnswerMaoForm form) {
		int[] ansList = getAnsList(form);
		int[] correctAnsList = {
				0,0,0,0,
				0,0,0,0,
				0,0,0,0,
				0,0,0,0
		};
		//答え合わせ
		int correctNum = checkAnswer(ansList,correctAnsList);
		String img;
		String bgm = "boss1.mp3";
		String msg;
		if(correctNum >= 10) {
			img = "mao4.png";
			msg = correctNum+"問正解か！\nぐふっ！やるではないか・・・・";
		}else if( correctNum >= 8 ) {
			img = "mao1.png";
			msg = correctNum+"問正解か！\n中々やりおる、、、しかし、それでは私に勝ったつもりか？";
		}else {
			img = "mao1.png";
			msg = "ふん、修業が足りんわ！出直してくるがよい";
		}
		mv.addObject("img",img);
		mv.addObject("bgm",bgm);
		mv.addObject("msg",msg);
		mv.setViewName("boss_ans");
		return mv;
	}

	@RequestMapping(value= {"battle/ans2"}, method=RequestMethod.POST)
	public ModelAndView ans2(ModelAndView mv,AnswerMaoForm form) {
		int[] ansList = getAnsList(form);
		int[] correctAnsList = {
				0,0,0,0,
				0,0,0,0,
				0,0,0,0,
				0,0,0,0
		};
		//答え合わせ
		int correctNum = checkAnswer(ansList,correctAnsList);
		String img;
		String bgm = "boss2.mp3";
		String msg;
		if(correctNum >= 10) {
			img = "mao6.png";
			msg = correctNum+"問正解か！\nぐふっ！やるではないか・・・・";
		}else if( correctNum >= 8 ) {
			img = "mao2.png";
			msg = correctNum+"問正解か！\n中々やりおる、、、しかし、それでは私に勝ったつもりか？";
		}else {
			img = "mao2.png";
			msg = "ふん、修業が足りんわ！出直してくるがよい";
		}
		mv.addObject("img",img);
		mv.addObject("bgm",bgm);
		mv.addObject("msg",msg);
		mv.setViewName("boss_ans");
		return mv;
	}
	/**
	 * 
	 * @param form
	 * @return
	 */
	private int[] getAnsList(AnswerMaoForm form) {
		int[] ansList = {
				form.getQ1(),form.getQ2(),form.getQ3(),form.getQ4(),
				form.getQ5(),form.getQ6(),form.getQ7(),form.getQ8(),
				form.getQ9(),form.getQ10(),form.getQ11(),form.getQ12(),
				form.getQ13(),form.getQ14(),form.getQ15(),form.getQ16()
		};
		return ansList;
	}
	/**
	 * 正解数を取得する　ansListとcorrectAnsListの要素数が同じであることが前提
	 * @param ansList
	 * @param correctAnsList
	 * @return
	 */
	private int checkAnswer(int[] ansList,int[] correctAnsList) {
		if( ansList.length != correctAnsList.length ) {
			return 0;
		}
		int correctNum = 0;
		for(int i=0; i < ansList.length; i++) {
			if( ansList[i] == correctAnsList[i]) {
				correctNum++;
			}
		}
		return correctNum;
	}
}
