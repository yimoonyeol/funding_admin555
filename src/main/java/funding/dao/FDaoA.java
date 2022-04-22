package funding.dao;

import java.sql.Timestamp;
import java.util.ArrayList;

import funding.dto.FDtoC;
import funding.dto.FDtoNotice;
import funding.dto.FDtoSystemQuestion;

public interface FDaoA {

	
	public int countQuestion();
	public ArrayList<FDtoSystemQuestion>systemquestion_view(int page);
	public ArrayList<FDtoSystemQuestion> SystemQuestionDetail(String question_num);

	public void SystemQAnswerInsert(String question_answer, int question_num);
	public void SystemQuestionRemove(String question_num);
	public ArrayList<FDtoC> clist(String adminId);
	public ArrayList<FDtoNotice> anotice_list();
	public void anoticecreate(Object notice_admin, String notice_title, String notice_content);
	public void anoticemodify(String notice_num, String notice_title, String notice_content, Timestamp notice_At);
	public FDtoNotice noticecontent(String noticeNum);
	public void anoticemodify(String notice_num, String notice_title, String notice_content, String notice_At);
	public void anoticedelete(String notice_num);

	
	
}
