package org.forwork.dto;

import lombok.Data;
import lombok.extern.log4j.Log4j;

@Data
@Log4j
public class MessageSearchDto {
	private String messageId;
	private int pageNum; // paging해서 메세지 가져올 때 사용
	
	public void calculatePageNumByRownum(String rownum, String msgAmountPerPage) {
		this.pageNum = (Integer.parseInt(rownum) / Integer.parseInt(msgAmountPerPage)) + 1;
		log.info(rownum + " " + msgAmountPerPage + " " + this.pageNum);
	}
}
