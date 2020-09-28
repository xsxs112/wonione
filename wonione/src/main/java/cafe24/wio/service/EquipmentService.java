package cafe24.wio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cafe24.wio.bean.Equipment;
import cafe24.wio.bean.WhEquipment;
import cafe24.wio.mapper.EquipmentMapper;

@Service
public class EquipmentService {

	@Autowired
	private EquipmentMapper equipmentMapper;
	
	
	/**
	 * 비품카테고리 보기
	 * @return List Equipment equipmentCategory
	 */
	public List<Equipment> getEquipCategory(){
		
		List<Equipment> equipmentCategory = equipmentMapper.getEquipCategory();
		
		return equipmentCategory;
	}
	
	/**
	 * 비품정보 등록하기
	 * @param equipment
	 * @return int addResult;
	 */
	public int addEquipment(Equipment equipment) {
		
		int addResult = equipmentMapper.addEquipment(equipment);
		
		return addResult;
	}
	
	/**
	 * 비품코드 자동증가
	 * @return String eqCode
	 */
	public String equipMaxCode() {
		String equipCodeMaxCount = equipmentMapper.equipMaxCode();
		String tempCode = null;
		String eqCode = null;
		int maxCode = 0;
		if(equipCodeMaxCount != null && !"".equals(equipCodeMaxCount)) {
			maxCode = Integer.parseInt(equipCodeMaxCount);
			if(maxCode <10) {
				tempCode = "eq_0000";
			}else if(10<=maxCode && maxCode <100) {
				tempCode = "eq_000";
			}else if(100<=maxCode && maxCode <1000) {
				tempCode = "eq_00";
			}
		}
		eqCode = tempCode + maxCode;
		
		return eqCode;
	}
	
	/**
	 * 비품 입고내역 검색 
	 * @param selectEqWhSk
	 * @param selectEqWhSv
	 * @return List WhEquipment getEqWhSearchList
	 */
	public List<WhEquipment> getEquipWhSearchList(String equipWhSk
												, String equipWhSv){
		List<WhEquipment> getEqWhSearchList = 
							equipmentMapper.getEquipWhSearchList(equipWhSk, equipWhSv);
		return getEqWhSearchList;
	}
	
	/**
	 *	등록 비품정보 검색 
	 * @param selectEqSk
	 * @param selectEqSv
	 * @return List Equipment getEqSearchResult
	 */
	public List<Equipment> getEquipSearchList(String equipSk
											, String equipSv){
		List<Equipment> getEqSearchResult = 
							equipmentMapper.getEquipSearchList(equipSk, equipSv);
		return getEqSearchResult;
	}
	
	
	/**
	 * 비품 입고내역 조회
	 * @return List WhEquipment equipWhList
	 */
	public List<WhEquipment> getEquipWhList(){
		List<WhEquipment> equipWhList = equipmentMapper.getEquipWhList();
		return equipWhList;
	}
	
	/**
	 * 등록된 비품정보만 조회하기
	 * @return List Equipment equipList
	 */
	public List<Equipment> getEquipList(){
		List<Equipment> equipList = equipmentMapper.getEquipList();
		return equipList;
	}
}
