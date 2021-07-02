package org.forwork.controller.chatting;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.forwork.domain.Message;
import org.forwork.dto.MessageCriteria;
import org.forwork.dto.MessageDto;
import org.forwork.dto.MessageSearchDto;
import org.forwork.service.chatting.ChattingService;
import org.json.simple.JSONObject;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;


@RequestMapping("/message/*")
@AllArgsConstructor
@Log4j
@RestController
public class MessageController {

	private final ChattingService service;
	
//	@GetMapping(value = "/chatroom/{chatroomId}",
//			produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
//	public ResponseEntity<List<MessageDto>> read(@PathVariable String chatroomId) {
//		return new ResponseEntity<>(service.findMessageByChatroomId(chatroomId), HttpStatus.OK);
//	}
	
	@PostMapping(value = "/chatroom/{chatroomId}",
			produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<List<MessageDto>> read(@RequestBody MessageCriteria cri, @PathVariable String chatroomId) {
		return new ResponseEntity<>(service.findMessageByChatroomIdWithPaging(cri, chatroomId), HttpStatus.OK);
	}
	
	@PostMapping(value = "/new",
			consumes = "application/json",
			produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> create(@RequestBody Message msg) {
		String messageId = service.createMessage(msg);
		return new ResponseEntity<String>(messageId, HttpStatus.OK);
	}
	
	@PutMapping(value = "/read/{messageId}/member/{memberId}")
	public ResponseEntity<String> checkRead(@PathVariable String messageId, @PathVariable String memberId){
		service.updateReadStatus(messageId, memberId);
		
		return new ResponseEntity<String>("success", HttpStatus.OK);
	}
	
	@PutMapping(value = "/read/member/{memberId}/chatroom/{chatroomId}")
	public ResponseEntity<String> checkReadAll(@PathVariable String memberId, @PathVariable String chatroomId){
		service.updateReadAll(chatroomId, memberId);
		
		return new ResponseEntity<String>("success", HttpStatus.OK);
	}
	
	@GetMapping(value = "/last/member/{memberId}")
	public ResponseEntity<List<Message>> getLastMessage(@PathVariable String memberId){
		return new ResponseEntity<List<Message>>(service.findLastMessagePerChatroomByMemberId(memberId), HttpStatus.OK);
	}
	
	@GetMapping(value = "/unread/member/{memberId}")
	public ResponseEntity<String> getUnreadCount(@PathVariable String memberId){
		return new ResponseEntity<>(new Gson().toJson(service.findUnreadCountPerChatroomByMemberId(memberId)), HttpStatus.OK);
	}
	
	@PostMapping(value = "/search/chatroom/{chatroomId}",
			produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<List<MessageSearchDto>> searchMessage(@RequestBody JSONObject obj, @PathVariable String chatroomId){
		System.out.println("=========================");
		System.out.println((String)obj.get("query"));
		return new ResponseEntity<>(service.searchMessage((String)obj.get("query"), chatroomId, Integer.toString((int)obj.get("amount"))), HttpStatus.OK);
	}
	
	@PostMapping(value = "/file/new")
	@ResponseBody
	public ResponseEntity<String> saveFile(MultipartFile file){
		System.out.println(file);
		String uploadFolder = "/Users/leejooeun/kosta-spring-project/upload";
		String uploadFolderPath = getFolder();
		// 년/월/일 폴더의 생성
		File uploadPath = new File(uploadFolder, uploadFolderPath);
		
		if (uploadPath.exists() == false) {
			uploadPath.mkdirs();
		}
		
		String uploadFileName = file.getOriginalFilename();

		// IE의 경우에는 전체 파일 경로가 전송되므로, 마지막에 \\를 기준으로 잘라낸 문자열이 실제 파일 이름
		uploadFileName = uploadFileName.substring(uploadFileName.lastIndexOf("/") + 1);
		
		UUID uuid = UUID.randomUUID();
		uploadFileName = uuid.toString() + "_" + uploadFileName;
		
		try {

			File saveFile = new File(uploadPath, uploadFileName);
			file.transferTo(saveFile);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String path = uploadFolderPath + "/" + uploadFileName;
		
		try {
			path = URLDecoder.decode(path, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new ResponseEntity<String>(path, HttpStatus.OK);
	}
	
	@GetMapping(value = "/file/download", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	@ResponseBody
	public ResponseEntity<Resource> downloadFile(String fileName) {

		Resource resource = new FileSystemResource("/Users/leejooeun/kosta-spring-project/upload/" + fileName);

		String resourceName = resource.getFilename();
		
		String resourceOriginalName = resourceName.substring(resourceName.indexOf("_") + 1);
		
		HttpHeaders headers = new HttpHeaders();
		try {
			String downloadName = null;
			headers.add("Content-Disposition", "attachment; filename=" + new String(resourceOriginalName.getBytes("UTF-8"), "ISO-8859-1"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Resource>(resource, headers, HttpStatus.OK);
	}
	
	private String getFolder() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String str = sdf.format(date);
		return str.replace("-", File.separator);
	}

}