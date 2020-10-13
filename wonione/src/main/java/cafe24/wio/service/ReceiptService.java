package cafe24.wio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cafe24.wio.bean.Course;
import cafe24.wio.mapper.ReceiptMapper;

@Service
public class ReceiptService {
	
	@Autowired
	private ReceiptMapper receiptMapper;
	
	
	/**
	 * 1. 수납 전 과정 선택
	 * @param course
	 * @return
	 */
	
	public int getCourseSelection(Course course) {
		
		int courseSelection = receiptMapper.getCourseSelection(course);
		
		return courseSelection;
	}

}
