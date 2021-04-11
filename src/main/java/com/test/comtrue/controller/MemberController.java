package com.test.comtrue.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.SendFailedException;
import javax.mail.internet.AddressException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.supercsv.io.CsvMapWriter;
import org.supercsv.io.ICsvMapWriter;
import org.supercsv.prefs.CsvPreference;

import com.test.comtrue.api.SendMail;
import com.test.comtrue.dto.ComtrueMemberDTO;
import com.test.comtrue.mapper.ComtrueMapper;

import jdk.internal.org.jline.utils.Log;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class MemberController {
	
	@Autowired
	private ComtrueMapper comtrueMapper;
	
	@RequestMapping("/member/send")
	public String send() throws AddressException, MessagingException {
		List<ComtrueMemberDTO> list = comtrueMapper.downAll();
		SendMail.generateAndSendEmail();
		return "/member/list";
	}
	
	@RequestMapping("/member/downloadCSV")
	public void downloadCSV(HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=euc-kr");
		List<ComtrueMemberDTO> list = comtrueMapper.downAll();
		String csvFileName="member.csv";
		String headKey = "Content-Disposition";
		String headValue = String.format("attachment; filename=\"%s\"", csvFileName);
		response.setHeader(headKey, headValue);
		
		 ICsvMapWriter mapWrite = new CsvMapWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);
		  String[] header = {"mno", "position", "name", "phone","email"};
		  mapWrite.writeHeader(header);
		  for( ComtrueMemberDTO dto : list) {
			  Map<String, Object> tmpMap = new HashMap<>();
			  tmpMap.put(header[0], dto.getMno());
			  tmpMap.put(header[1], dto.getPosition());
			  tmpMap.put(header[2], dto.getName());
			  tmpMap.put(header[3], dto.getPhone());
			  tmpMap.put(header[4], dto.getEmail());
			  System.out.println(tmpMap);
			  
		    mapWrite.write(tmpMap, header);
		  }
		  mapWrite.close();
	}
	
	@RequestMapping("/member/updateOk")
	public String updateOk(ComtrueMemberDTO dto,HttpServletRequest request) {
		int no = Integer.parseInt(request.getParameter("no"));
		System.out.println(no);
		comtrueMapper.update(dto,no);
		return "redirect:/member/list";
	}
	
	@RequestMapping("/member/update")
	public String Update(Model model,HttpServletRequest request) {
		int mno = Integer.parseInt(request.getParameter("mno"));
		ComtrueMemberDTO dto = comtrueMapper.getOne(mno);
		model.addAttribute("dto",dto);
		return "/member/update";
	}
	
	@RequestMapping("/member/deleteOk")
	public String delete(HttpServletRequest request) {
		int mno = Integer.parseInt(request.getParameter("mno"));
		comtrueMapper.delete(mno);
		return "redirect:/member/list";
	}
	
	@RequestMapping("/member/insert")
	public String insert() {
		log.info("dd");
		log.debug("dd");
		log.warn("dd");
		log.error("dd");
		return "/member/insert";
	}
	
	@RequestMapping("/member/insertOk")
	public String memberinsetOk(ComtrueMemberDTO dto) {
		comtrueMapper.insert(dto);
		return "redirect:/member/list";
	}
	
	@RequestMapping("/member/list")
	public String memberList(Model model,HttpServletRequest request) {
		String searchOption = request.getParameter("searchOption");
		Object keyword = request.getParameter("keyword");
		HashMap<String, Object> search = new HashMap<>();
		search.put(searchOption,keyword);
//		search.get(mno);
		List<ComtrueMemberDTO> list = new ArrayList<>();
		if(search.get(searchOption) == null) {
			 list = comtrueMapper.getAll("where name like",keyword);
		}else if(searchOption.equals("mno")){
			list = comtrueMapper.getAll("where mno like",keyword);
		}else if(searchOption.equals("position")){
			list = comtrueMapper.getAll("where position like",keyword);
		}else if(searchOption.equals("name")) {
			list = comtrueMapper.getAll("where name like",keyword);
		}else if(searchOption.equals("phone")) {
			list = comtrueMapper.getAll("where phone like",keyword);
		}else if(searchOption.equals("email")) {
			list = comtrueMapper.getAll("where email like",keyword);
		}
		model.addAttribute("list",list);
		return "/member/list";
	}
	
}
