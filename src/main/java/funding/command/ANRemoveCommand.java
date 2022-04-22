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

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ANRemoveCommand implements FCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
//		HttpSession session = request.getSession();
//		Object adminID = session.getAttribute("adminId");
//		String adminId = (String)adminID;
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String notice_num = request.getParameter("noticeNum");
		FDaoA dao = sqlSession.getMapper(FDaoA.class);
		dao.anoticedelete(notice_num);

	}

}
