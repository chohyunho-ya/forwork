package org.forwork.service;

import java.util.List;

import org.forwork.domain.Calendar;
import org.forwork.dto.CalendarDto;
import org.forwork.dto.CalendarWeekDto;

public interface CalendarService {
	public int registerCalendar(Calendar cal);
	public List<CalendarDto> listCalendar(String project_id);
	public List<CalendarWeekDto> listWeek(String project_id);
	
	public int updateCalendar(Calendar cal);
	
	public int deleteCalendar(String calendar_id);
}
