package cafe24.wio.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cafe24.wio.bean.Equipment;
import cafe24.wio.bean.SupplyTextbook;
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
	 * 등록된 비품정보 조회
	 * @return Map String,Object resultMap
	 */
	public Map<String,Object> getEquipList(int currentPage){
		final int ROW_PER_PAGE = 7;
	      
	      int startRow = 0;
	      
	      int startPageNum = 1;
	      int lastPageNum = ROW_PER_PAGE;
	      
	      if(currentPage > (ROW_PER_PAGE/2)) {
	         startPageNum = currentPage - ((lastPageNum/2)-1);
	         lastPageNum += startPageNum;
	      }
	      
	      startRow = (currentPage - 1) * ROW_PER_PAGE ;
	      
	      Map<String,Object> equipMap = new HashMap<String,Object>();
	            
	      equipMap.put("startRow", startRow);
	      equipMap.put("rowPerPage", ROW_PER_PAGE);

	      List<Equipment> equipList = equipmentMapper.getEquipList(equipMap);
	      
	      double totalRowCount = equipmentMapper.countEquipment();
	      
	      int lastPage = (int)Math.ceil((totalRowCount / ROW_PER_PAGE));
		
		
	      if(currentPage >= (lastPage-4)) {
		         lastPageNum = lastPage;
		      }
	      Map<String,Object> resultMap = new HashMap<String,Object>();
	      
	      resultMap.put("equipList", equipList);
	      resultMap.put("lastPage", lastPage);
	      resultMap.put("startPageNum", startPageNum);
	      resultMap.put("lastPageNum", lastPageNum);
		
		return resultMap;
	      
	}
}
