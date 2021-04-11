package com.test.comtrue.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.test.comtrue.dto.ComtrueMemberDTO;

@Mapper
public interface ComtrueMapper {

	@Insert("insert into contrueMember(mno,name,phone,position,email) values (#{dto.mno},#{dto.name},#{dto.phone},#{dto.position},#{dto.email})")
	int insert(@Param("dto") ComtrueMemberDTO dto);
	
	@Select("select mno,position,name,phone,email from contrueMember ${where} '%${keyword}%' order by name asc")
	List<ComtrueMemberDTO> getAll(@Param("where") String where, @Param("keyword") Object keyword);
	
	@Delete("delete from contrueMember where mno=#{mno}")
	int delete(@Param("mno") int mno);
	
	@Select("select * from contrueMember where mno=#{mno}")
	ComtrueMemberDTO getOne(@Param("mno") int mno);
	
	@Update("update contrueMember set mno=#{dto.mno},name=#{dto.name},phone=#{dto.phone},position=#{dto.position},email=#{dto.email} where mno=#{no}")
	int update(@Param("dto") ComtrueMemberDTO dto, @Param("no") int no);
	
	@Select("select * from contrueMember")
	List<ComtrueMemberDTO> downAll();
}
