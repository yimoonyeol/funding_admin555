package funding.command;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import funding.dao.FDaoA;
import funding.dto.FDtoC;

public class ACListCommand implements FCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		// TODO Auto-generated method stub
		System.out.println("커맨드 시작");
//		
//		HttpServletRequest request2;
//		HttpSession session = request2.getSession();
		String adminId = "admin@admin.com";
//		Object adminID = session.getAttribute("adminId");
//		String adminId = (String)adminID;
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
//		
		FDaoA dao = sqlSession.getMapper(FDaoA.class);
		
		ArrayList<FDtoC> dtos = dao.clist(adminId);
		
		request.setAttribute("clist", dtos);
		System.out.println("커맨드 끝");
	}

}

