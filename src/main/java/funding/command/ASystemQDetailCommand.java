package funding.command;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import funding.dao.FDaoA;
import funding.dto.FDtoSystemQuestion;

public class ASystemQDetailCommand implements FCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		// TODO Auto-generated method stub
		System.out.println("커맨드 시작");
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		System.out.println("맵끝");
	
//		ServletRequest session = (ServletRequest) request.getSession();
//		Object adminID = session.getAttribute("adminId");
//		System.out.println("세션끝");
//		String adminId = (String)adminID;
		
		String question_num = request.getParameter("question_num");
		System.out.println("리퀘스트 끝");
		
		 FDaoA dao = sqlSession.getMapper(FDaoA.class);
		System.out.println("다오끝");
		 ArrayList<FDtoSystemQuestion> dtos = dao.SystemQuestionDetail(question_num);
		
		request.setAttribute("system_question_detail", dtos);
		System.out.println("커맨드 끝");
	}
		
	}
	
	


