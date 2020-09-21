package cafe24.wio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cafe24.wio.bean.Grade;
import cafe24.wio.mapper.GradeMapper;
@Service
public class GradeService {
	@Autowired
	private GradeMapper  gradeMapper;
	
	//성적리스트
	public List<Grade> getGradeList(Grade grade){
		
		List<Grade> gradeList = gradeMapper.getGradeList(grade);
		System.out.println("getGradeList-->"+gradeList);
		return gradeList;
		
	}
	
	//성적상세보기리스트
	public List<Grade> getGradeDetailList(Grade grade){
		
		List<Grade> gradeList = gradeMapper.getGradeDetailList(grade);
		System.out.println("getGradeDetailList-->"+gradeList);
		return gradeList;
	}
	
}
