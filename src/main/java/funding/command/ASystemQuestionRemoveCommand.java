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

public class ASystemQuestionRemoveCommand implements FCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		// TODO Auto-generated method stub
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
//		HttpSession session = request.getSession();
//		Object adminID = session.getAttribute("adminId");
//		String adminId = (String)adminID;
//		
		
		String question_num = request.getParameter("question_num");
		FDaoA dao = sqlSession.getMapper(FDaoA.class);
		dao.SystemQuestionRemove(question_num);

	}

}
