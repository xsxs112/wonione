package cafe24.wio.service;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cafe24.wio.bean.Grade;
import cafe24.wio.bean.GradeReport;
import cafe24.wio.bean.Report;
import cafe24.wio.mapper.GradeMapper;
import cafe24.wio.mapper.GradeReportMapper;

@Service
public class GradeReportService {
	@Autowired
	private GradeReportMapper gradeReportMapper;

	
	private static final Logger logger = LoggerFactory.getLogger(GradeReportService.class);

	// 성적보고서 리스트
	public List<GradeReport> getGradeReportList(GradeReport gradeReport) {

		List<GradeReport> reportGrade = gradeReportMapper.getGradeReportList(gradeReport);
		logger.info("getGradeReportList-->" + reportGrade);
		return reportGrade;

	}

	//성적보고서 리스트 상세보기
	public GradeReport GradeReportDetailList(String reportLecCode){
		GradeReport reportGrade = gradeReportMapper.GradeReportDetailList(reportLecCode);
		logger.info("GradeReportDetailList-->" + reportGrade);
		return reportGrade;
	}
	
	//조건검색
	public List<GradeReport> searchGradeReport(String graRe, String graResult){
		List<GradeReport> gradeReport = gradeReportMapper.searchGradeReport(graRe, graResult);
		logger.info("gradeReport-->" + gradeReport);
		return gradeReport;
	}
	
	
}
