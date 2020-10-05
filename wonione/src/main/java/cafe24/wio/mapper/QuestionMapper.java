package cafe24.wio.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface QuestionMapper {

	public List<Map<String, Object>> QuestionList(Map<String, Object> parameterMap);

	public int QuestionListCount();

	public int QuestionCount();

	public List<Map<String, Object>> Question(Map<String, Object> parameterMap);

	public int QuestionScoreCheck(String qeAnswer, int qeCode, String studentName);

	public Map<String, Object> ScoreCheck(String scoreSid);

	public int QuestionSidCheck(String questionSid, String questionName);

	public int insertQuestionTitle(cafe24.wio.bean.Question question);
	//타이틀 삭제
	public void deleteQuestionTitle(String questionName);
	//타이틀안에 문제를 추가하기전 타이틀안에 속해있는 문제리스트출력
	public List<Map<String, Object>> modifyQuestionList(Map<String, Object> parameterMap);
	//문제리스트출력시 안에 몇개의문제가있는지 확인하는 Mapper
	public int modifyQuestionListCount(String qtCodeName);

	public Map<String, Object> modifyQuestionListView(String qeCode);

	public int insertQuestion(cafe24.wio.bean.Question question);
	


}
