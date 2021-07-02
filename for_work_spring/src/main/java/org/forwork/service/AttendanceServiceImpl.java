package org.forwork.service;

import java.util.List;
import java.util.Map;

import org.forwork.mapper.AttendanceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Setter;
@Service
public class AttendanceServiceImpl implements AttendanceService {
	
	@Setter(onMethod_=@Autowired)
	private AttendanceMapper mapper;
	
	@Override
	public int commuteRegister(String member_id) {
		if(mapper.getTime(member_id) == null){			
			return mapper.commute(member_id);
		}else{
			return -1;
		}
		
	}

	@Override
	public int offRegister(String member_id) {
		if(mapper.getTime(member_id) == null || mapper.getTime(member_id).containsKey("off")){
			return -1;
		}
		else{				
			return mapper.off(member_id);
			}
	}

	@Override
	public Map<String, String> getTime(String member_id) {
		return mapper.getTime(member_id);
	}

	@Override
	public List<Map<String, String>> getWeekWork(String ago, String member_id) {
		List<Map<String, String>> week = mapper.getWeekAttendance(ago, member_id);
		
		week.forEach(w ->{
 	   		double time = 0;
 		   	int c_hour = Integer.parseInt(w.get("commute").substring(0, 2));
			int c_min = Integer.parseInt(w.get("commute").substring(3, 5));
			if(w.get("off") != null){
				int o_hour = Integer.parseInt(w.get("off").substring(0, 2));
				int o_min = Integer.parseInt(w.get("off").substring(3, 5));
				time = ((o_hour*60+o_min)-(c_hour*60+c_min))/60.0 - 1;
				time = time < 0 ? 0 : time;
			}

			w.put("workTime", String.format("%.2f", time));
		});
		
		
		
		return week;
	}

}
