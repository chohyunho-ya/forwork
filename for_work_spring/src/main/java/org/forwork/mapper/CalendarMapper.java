package org.forwork.mapper;

import java.util.List;

import org.forwork.domain.Calendar;

public interface CalendarMapper {
	public int insertCalendar(Calendar calendar);

	public int updateCalendar(Calendar calendar);

	public int deleteCalendar(String calendar_id);

	public Calendar getCalendar(String calendar_id);

	public List<Calendar> getCalendarList(String project_id);
}
