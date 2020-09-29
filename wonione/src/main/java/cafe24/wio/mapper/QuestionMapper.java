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

	public int selectIdQuestion(String questionSid);

	public int insertQuestion(cafe24.wio.bean.Question question, String teacherId);

	public int insertQuestionTitle(cafe24.wio.bean.Question question);



}
