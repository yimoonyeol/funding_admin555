package funding.command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.springlec.base0301.FDaoA;

import funding.dto.FDtoCalculate;
import funding.dto.FDtoSeller;

public class ACAWListCommand implements FCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		Object adminID = session.getAttribute("adminId");
		String adminId = (String)adminID;
		
		FDaoA daoA = new FDaoA();
		ArrayList<FDtoCalculate> dtos = daoA.calapprovewaitlist();
		request.setAttribute("calapprovewaitlist", dtos);
		

	}

}
