package cafe24.wio.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cafe24.wio.bean.Grade;
@Mapper
public interface GradeMapper {

	//성적조회
	public List<Grade> getGradeList(Grade grade);

	//성적상세조회
	public List<Grade> getGradeDetailList(Grade grade);
	
}
