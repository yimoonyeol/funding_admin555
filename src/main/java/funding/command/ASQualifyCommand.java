package funding.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.springlec.base0301.FDaoA;

import funding.dto.FDtoSeller;

public class ASQualifyCommand implements FCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Object adminID = session.getAttribute("adminId");
		String adminId = (String)adminID;
		
		String sellerId = request.getParameter("sellerId");
		FDaoA dao = new FDaoA();
		FDtoSeller dto = dao.sellerqualify(sellerId);
		
	}

}
