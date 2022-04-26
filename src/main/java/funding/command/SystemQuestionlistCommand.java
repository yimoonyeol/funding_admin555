package funding.command;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;



import funding.dao.FDaoA;
import funding.dto.FDtoSystemQuestion;

public class SystemQuestionlistCommand implements FCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		System.out.println("커맨드 시작");
		int page10 = 1;
		int offs = 1;
		int page = 1;
		
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		

		
		 FDaoA dao = sqlSession.getMapper(FDaoA.class);
		if(request.getParameter("page") != null) {
			page10 = Integer.parseInt(request.getParameter("page"));
			offs = (page10 - 1) * 10;
		}
		
		int countQuestion = dao.countQuestion();
		
		ArrayList<FDtoSystemQuestion> list = dao.systemquestion_view(offs);
		
		
		if(request.getParameter("page") != null) {
			page =  Integer.parseInt(request.getParameter("page"));
			if( page < 1) {
				page = 1;
			} else if ( page > (countQuestion/10)+1 ){
				page = (countQuestion/10) + 1;
			}
			
		}
		
		request.setAttribute("question", list);
		request.setAttribute("countQuestion", countQuestion);
		request.setAttribute("page", page);
		System.out.println(page);
		System.out.println("커맨드 끝");
	}

}
