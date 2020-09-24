package cafe24.wio.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cafe24.wio.bean.Equipment;
import cafe24.wio.bean.WhEquipment;

@Mapper
public interface EquipmentMapper {

	//비품 입고내역 검색
	public List<WhEquipment> getEquipWhSearchList(String equipWhSk
												, String equipWhSv);
	
	//등록 비품정보 검색
	public List<Equipment> getEquipSearchList(String equipSk
											, String equipSv);

	//비품 입고내역 조회
	public List<WhEquipment> getEquipWhList();

	//등록된 비품정보만 조회하기
	public List<Equipment> getEquipList();
	
}
