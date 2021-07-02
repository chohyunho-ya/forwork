package org.forwork.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.forwork.domain.Calendar;
import org.forwork.dto.CalendarDto;
import org.forwork.dto.CalendarWeekDto;
import org.forwork.mapper.CalendarMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.Setter;

@Service
public class CalendarServiceImpl implements CalendarService {

	@Setter(onMethod_=@Autowired)
	private CalendarMapper mapper;
	
	@Override
	public int registerCalendar(Calendar cal) {
		return mapper.insertCalendar(cal);
	}

	@Override
	public List<CalendarDto> listCalendar(String project_id) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		List<Calendar> list = mapper.getCalendarList(project_id);
		List<CalendarDto> dtoList = null;
		
		if(list != null){
			dtoList = new ArrayList<>();
			for(Calendar cal : list){
				CalendarDto dto = new CalendarDto();
				dto.setId(cal.getCalendar_id());
				dto.setTitle(cal.getCalendar_content());
				dto.setStart(format.format(cal.getCalendar_start_date()));	
				dto.setEnd(format.format(cal.getCalendar_end_date()));
				dtoList.add(dto);
			}
		}
		
		return dtoList;
	}
	

	@Override
	@Transactional
	public int updateCalendar(Calendar cal) {
		Calendar original = mapper.getCalendar(cal.getCalendar_id());
		cal.setProject_id(original.getProject_id());
		return mapper.updateCalendar(cal);
	}

	@Override
	public List<CalendarWeekDto> listWeek(String project_id) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		List<Calendar> list = mapper.getCalendarList(project_id);
		List<CalendarWeekDto> dtoList = null;
		
		if(list != null){
			dtoList = new ArrayList<>();
			for(Calendar cal : list){
				CalendarWeekDto dto = new CalendarWeekDto();
				dto.setId(cal.getCalendar_id());
				dto.setTitle(cal.getCalendar_content());
				dto.setStart(format.format(cal.getCalendar_start_date()));	
				dto.setEnd(format.format(cal.getCalendar_end_date()));
				dto.setAllDay(cal.getAllDay());
				dtoList.add(dto);
			}
		}
		
		return dtoList;

	}
	
 
  

	@Override
	public int deleteCalendar(String calendar_id) {
		return mapper.deleteCalendar(calendar_id);

	}

}
