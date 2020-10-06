package cafe24.wio.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface QuestionMapper {
	//타이틀리스트
	public List<Map<String, Object>> QuestionList(Map<String, Object> parameterMap);
	//타이틀갯수
	public int QuestionListCount();
	//몇문제있는지 획인
	public int QuestionCount(String questionName);
	//문제표시
	public List<Map<String, Object>> Question(Map<String, Object> parameterMap);
	//점수등록
	public int QuestionScoreCheck(String qeAnswer, int qeCode, String studentName);
	//점수확인
	public Map<String, Object> ScoreCheck(String scoreSid, String scoreCheckQuestionName);
	//해당문제 풀었던 인원인지 체크
	public String QuestionSidCheck(String questionSid, String questionName);
	//타이틀등록
	public int insertQuestionTitle(cafe24.wio.bean.Question question);
	//타이틀 삭제
	public int deleteQuestionTitle(String questionName);
	//타이틀안에 문제를 추가하기전 타이틀안에 속해있는 문제리스트출력
	public List<Map<String, Object>> titleQuestionList(Map<String, Object> parameterMap);
	//문제리스트출력시 안에 몇개의문제가있는지 확인하는 Mapper
	public int titleQuestionListCount(String qtCodeName);
	//문제자세히보기
	public Map<String, Object> titleQuestionListView(String qeCode);
	//문제등록
	public int insertQuestion(cafe24.wio.bean.Question question);
	//타이틀내 문제수정
	public void modifyQuestion(cafe24.wio.bean.Question question);
	//타이틀내 문제삭제
	public int deleteQuestion(int qeCode);
	//타이틀 수정
	public int modifyQuestionTitle(String questionCodeName, String questionTitle);
	//타이틀 수정전 이름체크
	public int QuestionTitleNameCheck(String questionCodeName);
	//인원확인숫자
	public int candidateQuestionListCount(String qtCodeName);
	//인원확인
	public List<Map<String, Object>> candidateQuestionList(Map<String, Object> parameterMap);
	//학생시점 점수확인
	public Map<String, Object> questionScoreCheck(String questionSid, String questionCodeName);
	//응시인원초기화
	public int candidateQuestionInitialization(String candidateQuestionCodeName);
	//인원검색
	public List<Map<String, Object>> selectcandidateQuestionId(String selectcandidateQuestionId, String candidateQuestionCodeName);
	//인원삭제
	public int deleteCandidateQuestion(String candidateQuestionId, String candidateQuestionCodeName);
	


}
