package cafe24.wio.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cafe24.wio.bean.Member;

@Mapper
public interface MemberMapper {
	
	// 1. 구성원 리스트 가져오기.
	public List<Member>getWIOMemberList();
	
}
