package funding.dao;

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

	
	
}
