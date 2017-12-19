package in.apssdc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.andromeda.commons.model.Response;

import in.apssdc.model.DateWiseAttendance;
import in.apssdc.model.SIP;
import in.apssdc.service.AttendanceService;

@RestController
@RequestMapping("/consolidatedAttReport")
public class AttendanceController
{
	@Autowired
	AttendanceService attendanceService;

	@ResponseBody
	@RequestMapping(value = "/getAllClgAttReport",
			method = { RequestMethod.POST, RequestMethod.GET })
	public Response getAllClgAttReport(@RequestBody String date)
	{
		return attendanceService.getAllClgAttReport(date);
	}

	@ResponseBody
	@RequestMapping(value = "/getYearWiseAttendance", method = { RequestMethod.POST })
	public Response getYearWiseAttendance()
	{
		return attendanceService.getYearWiseAttendance();
	}

	@ResponseBody
	@RequestMapping(value = "/getAllClgForTrainingPRgmIdAttReport", method = { RequestMethod.POST })
	public
			Response getAllClgForTrainingPRgmIdAttReport(@RequestBody DateWiseAttendance dateWiseAttendance)
	{
		return attendanceService.getAllClgForTrainingPRgmIdAttReport(dateWiseAttendance);
	}

	@ResponseBody
	@RequestMapping(value = "/getAllPrgmsForClgsAttReport", method = { RequestMethod.POST })
	public Response getAllPrgmsForClgsAttReport(@RequestBody DateWiseAttendance dateWiseAttendance)
	{
		return attendanceService.getAllPrgmsForClgsAttReport(dateWiseAttendance);
	}

	@ResponseBody
	@RequestMapping(value = "/getCoursewisePrgmsAttReport", method = { RequestMethod.POST })
	public Response getCoursewisePrgmsAttReport(@RequestBody SIP sip)
	{
		return attendanceService.getCoursewisePrgmsAttReport(sip);
	}

	@ResponseBody
	@RequestMapping(value = "/dateWise", method = { RequestMethod.POST })
	public Response dateWise(@RequestBody DateWiseAttendance trainingbatchid)
	{
		return attendanceService.dateWise(trainingbatchid);
	}

	@ResponseBody
	@RequestMapping(value = "/coursewiseStudentsAttendance", method = { RequestMethod.POST })
	public Response coursewiseStudentsAttendance(@RequestBody SIP sipDetails)
	{
		return attendanceService.coursewiseStudentsAttendance(sipDetails);
	}

	@ResponseBody
	@RequestMapping(value = "/getAllSIPClg", method = { RequestMethod.POST, RequestMethod.GET })
	public Response getAllSIPClg()
	{
		return attendanceService.getAllSIPClg();
	}

	@ResponseBody
	@RequestMapping(value = "allPrograms", method = { RequestMethod.POST })
	public Response allPrograms(@RequestBody SIP sip)
	{
		return attendanceService.allPrograms(sip);
	}

	@ResponseBody
	@RequestMapping(value = "/getProgramWise", method = { RequestMethod.POST })
	private Response getProgramWise(@RequestBody SIP sip)
	{
		return attendanceService.getProgramWise(sip);
	}

	@ResponseBody
	@RequestMapping(value = "getTrainingBatchId", method = { RequestMethod.POST })
	public Response getTrainingBatchId(@RequestBody SIP sip)
	{
		return attendanceService.getTrainingBatchId(sip);
	}

	@ResponseBody
	@RequestMapping(value = "getDatewiseAttendance", method = { RequestMethod.POST })
	public Response getDatewiseAttendance(@RequestBody SIP sip)
	{
		return attendanceService.getDatewiseAttendance(sip);
	}

	@ResponseBody
	@RequestMapping(value = "dateWiseAttendance", method = { RequestMethod.POST })
	public Response dateWiseAttendance(@RequestBody SIP dateWiseAttendance)
	{
		return attendanceService.searchAttendance(dateWiseAttendance);
	}

	@ResponseBody
	@RequestMapping(value = "/getConsolidatedAttCoursewise", method = { RequestMethod.POST })
	public Response getConsolidatedAttCoursewise(@RequestBody Integer courseId)
	{
		return attendanceService.getConsolidatedAttCoursewise(courseId);
	}

	@ResponseBody
	@RequestMapping(value = "/getAllClgForCoursewiseAttReport", method = { RequestMethod.POST })
	public Response getAllClgForCoursewiseAttReport(@RequestBody SIP sip)
	{
		return attendanceService.getAllClgForCoursewiseAttReport(sip);
	}

}