package funding.command;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import funding.dao.FDaoA;


public class ASystemQAnswerInsertCommand implements FCommand {
	@Override
	public void execute(SqlSession sqlSession, Model model) {
		System.out.println("커맨드 시작");
		// TODO Auto-generated method stub
//		HttpSession session = request.getSession();
//		Object adminID = session.getAttribute("adminId");
//		String adminId = (String)adminID;
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		
		String question_answer = request.getParameter("question_answer");
		String question_num =  request.getParameter("question_num");

		 FDaoA dao = sqlSession.getMapper(FDaoA.class);
		 System.out.println("다오 시작");
		 System.out.println(question_answer +" "+ question_num);
		 dao.SystemQAnswerInsert(question_answer, Integer.parseInt(question_num));
		
	}

}
