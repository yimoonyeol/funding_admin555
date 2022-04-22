package funding.command;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import funding.dao.FDaoA;
import funding.dto.FDtoNotice;


public class ANCreateCommand implements FCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		HttpSession session = request.getSession();
		Object adminID = session.getAttribute("adminId");
		String adminId = (String)adminID;
		
		Object notice_admin = "admin@admin.com";
		
		String notice_title = request.getParameter("notice_title");
		String notice_content = request.getParameter("notice_content");
		
//		
		FDaoA dao = sqlSession.getMapper(FDaoA.class);
		
		
		dao.anoticecreate(notice_admin, notice_title, notice_content);

	}



}
