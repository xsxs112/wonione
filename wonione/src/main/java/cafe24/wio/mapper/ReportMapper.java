package cafe24.wio.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cafe24.wio.bean.Report;

@Mapper
public interface ReportMapper {

	//보고서조회
	public List<Report> getReportList(Report report);
	
	
}
