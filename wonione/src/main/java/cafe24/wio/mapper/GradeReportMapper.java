package cafe24.wio.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import cafe24.wio.bean.GradeReport;
import cafe24.wio.bean.Report;

@Mapper
public interface GradeReportMapper {

	//보고서조회
	public List<GradeReport> getGradeReportList(GradeReport gradeReport);
	
	//보고서 상세조회
	public GradeReport GradeReportDetailList(String reportLecCode);
	
	//조건검색
	public List<GradeReport> searchGradeReport(String graRe, String graResult);
	
}
