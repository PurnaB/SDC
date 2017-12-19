package in.apssdc.controller;

import in.apssdc.model.DateWiseAttendance;
import in.apssdc.model.SIP;
import in.apssdc.model.SdcModel;
import in.apssdc.service.StudentsAttendanceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.andromeda.commons.model.Response;

@RestController
@RequestMapping("/attendance")
public class StudentsAttendanceController
{
	@Autowired
	StudentsAttendanceService attendanceService;

	@ResponseBody
	@RequestMapping(value = { "saveStudentAttendance" }, method = { RequestMethod.POST })
	public Response saveStudentAttendance(@RequestBody SdcModel sdcModel)
	{
		return attendanceService.saveStudentAttendance(sdcModel);
	}
	
	@ResponseBody
	@RequestMapping(value = { "saveMentorsAttendance" }, method = { RequestMethod.POST })
	public Response saveMentorsAttendance(@RequestBody SdcModel sdcModel)
	{
		return attendanceService.saveMentorsAttendance(sdcModel);
	}
	
	@ResponseBody
	@RequestMapping(value = "allPrograms", method = { RequestMethod.POST })
	public Response allPrograms(@RequestBody SIP sip)
	{
		return attendanceService.allPrograms(sip);
	}

	@ResponseBody
	@RequestMapping(value = "getTrainingBatchId", method = { RequestMethod.POST })
	public Response getTrainingBatchId(@RequestBody SIP sip)
	{
		return attendanceService.getTrainingBatchId(sip);
	}

	@ResponseBody
	@RequestMapping(value = "dateWise", method = { RequestMethod.POST })
	public Response searchAttendance(@RequestBody DateWiseAttendance dateWiseAttendance)
	{
		return attendanceService.searchAttendance(dateWiseAttendance);
	}

}