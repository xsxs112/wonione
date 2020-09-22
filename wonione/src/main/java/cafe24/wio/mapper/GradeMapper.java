package cafe24.wio.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cafe24.wio.bean.Grade;
@Mapper
public interface GradeMapper {

	//성적조회
	public List<Grade> getGradeList(Grade grade);

	//성적코드로상세조회
	public List<Grade> getGradeDetailList(String gradeManCode);
	
	//조건검색
	public List<Grade> searchGrade(String lecGd, String lecGds);
	
}
