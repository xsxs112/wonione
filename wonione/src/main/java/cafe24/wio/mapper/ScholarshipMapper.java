package cafe24.wio.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cafe24.wio.bean.ScholarShip;

@Mapper
public interface ScholarshipMapper {

	public List<ScholarShip> getScholarList(ScholarShip scholarship);
	
}
