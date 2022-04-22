package funding.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import funding.command.ACListCommand;
import funding.command.ANListCommand;
import funding.command.ANCreateCommand;
import funding.command.ANContentCommand;
import funding.command.ANModifyCommand;
import funding.command.ANRemoveCommand;
import funding.command.ASystemQAnswerInsertCommand;
import funding.command.ASystemQDetailCommand;
import funding.command.ASystemQuestionRemoveCommand;
import funding.command.FCommand;
import funding.command.SystemQuestionlistCommand;


@Controller
public class YangController {
	FCommand command = null;

	
	@Autowired
	private SqlSession sqlSession;
	
	@RequestMapping("/aSAList")
	public String SystemQuestionlist(HttpServletRequest request, Model model) {
		System.out.println("컨트롤러 시작");
		model.addAttribute("request", request);
		command = new SystemQuestionlistCommand();
		command.execute(sqlSession, model);
		System.out.println("컨트롤러 끝");
		return "aSAList";
	}
	
	@RequestMapping("/asystemqDetail")
	public String AsystemDetail(HttpServletRequest request, Model model) {
		System.out.println("컨트롤러 시작");
		model.addAttribute("request", request);
		command = new ASystemQDetailCommand();
		command.execute(sqlSession, model);
		System.out.println("컨트롤러 끝");
	
		return "aSQAnswer";
	}
	
	@RequestMapping("/aSystemQAnswerInsert")
	public String aSystemQAnswerInsertCommand(HttpServletRequest request, Model model) {
		System.out.println("컨트롤러 시작");
		
		String question_num =  request.getParameter("question_num");
		
		model.addAttribute("request", request);
		command = new ASystemQAnswerInsertCommand();
		command.execute(sqlSession, model);

		System.out.println("컨트롤러 끝");
		
		return "redirect:/asystemqDetail?question_num="+question_num;
	}
	
	@RequestMapping("/systemQuestionRemove")
	public String ASystemQAnswerRemoveCommand(HttpServletRequest request, Model model) {

		String question_num =  request.getParameter("question_num");
		model.addAttribute("request", request);
		command = new ASystemQuestionRemoveCommand();
		command.execute(sqlSession, model);
		
		System.out.println("컨트롤러 끝");
		
		return "redirect:/asystemqDetail?question_num="+question_num;
	}
	
	@RequestMapping("/aCList")
	public String ACList(HttpServletRequest request, Model model) {
		
		model.addAttribute("request", request);
		command = new ACListCommand();
		command.execute(sqlSession, model);

		return "aCList";
	}
	
	@RequestMapping("/anotice_list")
	public String ANList(HttpServletRequest request, Model model) {
		System.out.println("컨트롤러 시작");
		model.addAttribute("request", request);
		command = new ANListCommand();
		command.execute(sqlSession, model);
		System.out.println("컨트롤러 끝");
		return "aNoticeList";
		
	}
	
	@RequestMapping("/anoticeCreate")
	public String ANCreateCommand(HttpServletRequest request, Model model) {
		System.out.println("컨트롤러 시작");
		model.addAttribute("request", request);
		command = new ANCreateCommand();
		command.execute(sqlSession, model);
		System.out.println("컨트롤러 끝");
		return "redirect:/anotice_list";
		
	}
	
	@RequestMapping("/anoticeCreate_view")
	public String aNoticeCreate() {
	
		return "aNoticeCreate";
		
	}
	
	@RequestMapping("/anoticeModify")
	public String ANModifyCommand(HttpServletRequest request, Model model) {
		System.out.println("컨트롤러 시작");
		model.addAttribute("request", request);
		String notice_num = request.getParameter("noticeNum");
		command = new ANModifyCommand();
		command.execute(sqlSession, model);
		System.out.println("컨트롤러 끝");
		
		
		
		return "redirect:anotice_list";
		
}
	
	@RequestMapping("/anoticeContent_view")
	public String ANContentCommand(HttpServletRequest request, Model model) {
		System.out.println("컨트롤러 시작");
		model.addAttribute("request", request);
		command = new ANContentCommand();
		command.execute(sqlSession, model);
		System.out.println("컨트롤러 끝");
		return "aNContentView";
		
	}
	
	@RequestMapping("/anoticeRemove")
	public String ANRemovecommand(HttpServletRequest request, Model model) {
		System.out.println("컨트롤러 시작");
		model.addAttribute("request", request);
		command = new ANRemoveCommand();
		command.execute(sqlSession, model);
		System.out.println("컨트롤러 끝");
		return "redirect: anotice_list";
		
	}
	


}
