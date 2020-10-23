package cafe24.wio.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import cafe24.wio.bean.Equipment;
import cafe24.wio.bean.WhEquipment;

@Mapper
public interface EquipmentMapper {

	//비품코드로 비품정보 조회
	public Map<String,Object> getEquipListOnly(String eqCode);
	
	//비품코드 maxcount
	public String equipMaxCode();
	
	//비품 입고내역 검색
	public List<Map<String,Object>> getEquipWhSearchList(String equipWhSk
												, String equipWhSv);
	
	//등록 비품정보 검색
	public List<Equipment> getEquipSearchList(String equipSk
											, String equipSv);

	//비품 입고내역 조회
	public List<WhEquipment> getEquipWhList();

	//페이징을 위한 비품정보카운팅 
	public int countEquipment();
	
	//등록된 비품정보 조회
	public List<Equipment> getEquipmentList(Map<String,Object> equipMap);
	
	//비품카테고리 조회
	public List<Equipment> getEquipCategory();
	
	//비품정보 등록하기
	public int addEquipment(Equipment equipment);
	
}
