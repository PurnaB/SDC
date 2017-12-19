package in.apssdc.controller;

import in.apssdc.model.College;
import in.apssdc.model.DateWiseAttendance;
import in.apssdc.model.District;
import in.apssdc.model.Employee;
import in.apssdc.model.FeedBack;
import in.apssdc.model.Program;
import in.apssdc.model.SdcModel;
import in.apssdc.model.StudentRegistration;
import in.apssdc.service.SdcService;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.andromeda.commons.model.Response;
import com.andromeda.commons.util.HttpUtils;

@RestController
@RequestMapping("/sdc")
public class SdcController
{
	@Autowired
	private SdcService sdcService;

	@ResponseBody
	@RequestMapping(value = "getSIPPrograms", method = { RequestMethod.POST, RequestMethod.GET })
	public Response getSIPPrograms()
	{
		return sdcService.getSIPPrograms();
	}

	@ResponseBody
	@RequestMapping(value = "getAllBranches", method = { RequestMethod.POST, RequestMethod.GET })
	public Response getAllBranches()
	{
		return sdcService.getAllBranches();
	}

	@ResponseBody
	@RequestMapping(value = "getBranchWisePrograms", method = { RequestMethod.POST })
	public Response getBranchWisePrograms(@RequestBody Integer branchId)
	{
		return sdcService.getBranchWisePrograms(branchId);
	}

	@ResponseBody
	@RequestMapping(value = "getBranchWiseColleges", method = { RequestMethod.POST })
	public Response getBranchWiseColleges(@RequestBody Program program)
	{
		return sdcService.getBranchWiseColleges(program);
	}

	@ResponseBody
	@RequestMapping(value = "getBranchWiseStudents", method = { RequestMethod.POST })
	public Response getBranchWiseStudents(@RequestBody Program program)
	{
		return sdcService.getBranchWiseStudents(program);
	}

	@ResponseBody
	@RequestMapping(value = "getColeges", method = { RequestMethod.POST, RequestMethod.GET })
	public Response getColeges()
	{
		return sdcService.getColeges();
	}

	@ResponseBody
	@RequestMapping(value = "getDistrictWiseTrained", method = { RequestMethod.POST })
	public Response getDistrictWiseTrained(@RequestBody String year)
	{
		return sdcService.getDistrictWiseTrained(year);
	}

	@ResponseBody
	@RequestMapping(value = "getDistrictWiseTrainedTotal", method = { RequestMethod.POST })
	public Response getDistrictWiseTrainedTotal(@RequestBody String year)
	{
		return sdcService.getDistrictWiseTrainedTotal(year);
	}

	@ResponseBody
	@RequestMapping(value = "getDistrictWiseStudents", method = { RequestMethod.POST })
	public Response getDistrictWiseStudents(@RequestBody District district)
	{
		return sdcService.getDistrictWiseStudents(district);
	}

	@ResponseBody
	@RequestMapping(value = "getDistrictWiseStudentsTotal", method = { RequestMethod.POST })
	public Response getDistrictWiseStudentsTotal(@RequestBody District district)
	{
		return sdcService.getDistrictWiseStudentsTotal(district);
	}

	@ResponseBody
	@RequestMapping(value = "getActiveColleges", method = { RequestMethod.GET, RequestMethod.POST })
	public Response getActiveColleges()
	{
		return sdcService.getActiveColleges();
	}

	@ResponseBody
	@RequestMapping(value = "getAllocationPrograms",
			method = { RequestMethod.GET, RequestMethod.POST })
	public Response getAllocationPrograms()
	{
		return sdcService.getAllocationPrograms();
	}

	@ResponseBody
	@RequestMapping(value = "getAllocationCourses", method = { RequestMethod.POST })
	public Response getAllocationCourses(@RequestBody Program program)
	{
		return sdcService.getAllocationCourses(program);
	}

	@ResponseBody
	@RequestMapping(value = "getAllocationColleges", method = { RequestMethod.POST })
	public Response getAllocationColleges(@RequestBody Program program)
	{
		return sdcService.getAllocationColleges(program);
	}

	@ResponseBody
	@RequestMapping(value = "getAllocationStudents", method = { RequestMethod.POST })
	public Response getAllocationStudents(@RequestBody Program program)
	{
		return sdcService.getAllocationStudents(program);
	}

	@ResponseBody
	@RequestMapping(value = "getStudentsForAlloc", method = { RequestMethod.POST })
	public Response getStudentsForAlloc(@RequestBody Integer batchId)
	{
		return sdcService.getStudentsForAlloc(batchId);
	}

	@ResponseBody
	@RequestMapping(value = "getPrograms", method = { RequestMethod.POST })
	public Response getPrograms(@RequestBody Integer collegeId)
	{
		return sdcService.getPrograms(collegeId);
	}

	@ResponseBody
	@RequestMapping(value = "getCourses", method = { RequestMethod.POST })
	public Response getCourses(@RequestBody Integer programId)
	{
		return sdcService.getCourses(programId);
	}

	@ResponseBody
	@RequestMapping(value = "getMentorsAndBatches", method = { RequestMethod.POST })
	public Response getMentorsAndBatches(@RequestBody StudentRegistration details)
	{
		return sdcService.getMentorsAndBatches(details);
	}

	@ResponseBody
	@RequestMapping(value = "getMentorsAndStudents", method = { RequestMethod.POST })
	public Response getMentorsAndStudentsDetails(@RequestBody StudentRegistration details)
	{
		return sdcService.getMentorsAndStudentsDetails(details);
	}

	@ResponseBody
	@RequestMapping(value = "assignStudents", method = { RequestMethod.POST })
	public Response assignStudents(@RequestBody Employee employee)
	{
		return sdcService.assignStudents(employee);
	}

	@ResponseBody
	@RequestMapping(value = "universityRegistration", method = { RequestMethod.GET })
	public Response universityRegistration(@RequestBody Object object) throws JSONException
	{
		return sdcService.universityRegistration(object);
	}

	@ResponseBody
	@RequestMapping(value = "dateWise", method = { RequestMethod.POST })
	public Response searchAttendance(@RequestBody DateWiseAttendance dateWiseAttendance)
	{
		return sdcService.searchAttendance(dateWiseAttendance);
	}

	@ResponseBody
	@RequestMapping(value = "locationWise", method = { RequestMethod.POST })
	public Response locationWise(@RequestBody DateWiseAttendance dateWiseAttendance)
	{
		System.out.println("=====================>" + dateWiseAttendance);
		return sdcService.locationWise(dateWiseAttendance);
	}

	@ResponseBody
	@RequestMapping(value = "programWise", method = { RequestMethod.POST })
	public Response programWise(@RequestBody DateWiseAttendance dateWiseAttendance)
			throws UnsupportedEncodingException
	{
		return sdcService.programWise(dateWiseAttendance);
	}

	@ResponseBody
	@RequestMapping(value = "allPrograms", method = { RequestMethod.POST })
	public Response allPrograms()
	{
		return sdcService.allPrograms();
	}

	@ResponseBody
	@RequestMapping(value = { "getReport" }, method = { RequestMethod.POST })
	public Response getReport()
	{
		return sdcService.getReport();
	}

	@ResponseBody
	@RequestMapping(value = { "getDistricts" }, method = { RequestMethod.POST, RequestMethod.GET })
	public Response getDistricts()
	{
		return sdcService.getDistricts();
	}

	@ResponseBody
	@RequestMapping(value = { "saveCollege" }, method = { RequestMethod.POST })
	public Response saveCollege(@RequestBody College college)
	{
		return sdcService.saveCollege(college);
	}

	@ResponseBody
	@RequestMapping(value = { "saveSPOCDetails" }, method = { RequestMethod.POST })
	public Response saveSPOCDetails(@RequestBody College spocDetails)
	{
		return sdcService.saveSPOCDetails(spocDetails);
	}

	@ResponseBody
	@RequestMapping(value = { "validateAadhaar" }, method = { RequestMethod.POST })
	public Response validateAadhaar(@RequestBody College spocDetails)
	{
		return sdcService.validateAadhaar(spocDetails);
	}

	@ResponseBody
	@RequestMapping(value = { "sendSIPLink" }, method = { RequestMethod.POST })
	public Response sendSIPLink(@RequestBody College spocDetails) throws JSONException
	{
		return sdcService.sendSIPLink(spocDetails);
	}

	@ResponseBody
	@RequestMapping(value = { "sendSIPLogins" }, method = { RequestMethod.POST })
	public Response sendSIPLogins(@RequestBody College spocDetails,
			HttpServletRequest httpServletRequest) throws JSONException
	{
		String clientProxyIp = HttpUtils.getClientProxyAddress(httpServletRequest);
		String clientIp = HttpUtils.getClientAddress(httpServletRequest);
		String ipAddress = "CLIENT:" + clientIp + ", CLIENT_PROXY:" + clientProxyIp;
		spocDetails.setIpAddress(ipAddress);

		return sdcService.sendSIPLogins(spocDetails);
	}

	@ResponseBody
	@RequestMapping(value = { "getSummaryOfPrograms" },
			method = { RequestMethod.POST, RequestMethod.GET })
	public Response getSummaryOfPrograms()
	{
		return sdcService.getSummaryOfPrograms();
	}

	@ResponseBody
	@RequestMapping(value = "/getFeedbackReport",
			method = { RequestMethod.POST, RequestMethod.GET })
	public Response getFeedbackReport() throws JSONException
	{
		return sdcService.getFeedbackReport();
	}

	@ResponseBody
	@RequestMapping(value = "getYearWise", method = { RequestMethod.POST, RequestMethod.GET })
	public Response getYearWise()
	{
		return sdcService.getYearWise();
	}

	@ResponseBody
	@RequestMapping(value = "getYearWisePrograms", method = { RequestMethod.POST })
	public Response getYearWisePrograms(@RequestBody Integer year)
	{
		return sdcService.getYearWisePrograms(year);
	}

	@ResponseBody
	@RequestMapping(value = "getYearWiseColleges", method = { RequestMethod.POST })
	public Response getYearWiseColleges(@RequestBody Program program)
	{
		return sdcService.getYearWiseColleges(program);
	}

	@ResponseBody
	@RequestMapping(value = "getYearWiseStudents", method = { RequestMethod.POST })
	public Response getYearWiseStudents(@RequestBody Program program)
	{
		return sdcService.getYearWiseStudents(program);
	}

	@ResponseBody
	@RequestMapping(value = { "allWorkshopPrograms" },
			method = { org.springframework.web.bind.annotation.RequestMethod.GET,
					org.springframework.web.bind.annotation.RequestMethod.POST })
	public Response getWorkshopPrograms()
	{
		return this.sdcService.getWorkshopPrograms();
	}

	@ResponseBody
	@RequestMapping(value = { "getWorkshopCourseWiseDetails" },
			method = { org.springframework.web.bind.annotation.RequestMethod.GET,
					org.springframework.web.bind.annotation.RequestMethod.POST })
	public Response getWorkshopCourseWiseDetails(@RequestBody SdcModel sdcModel)
	{
		return this.sdcService.getWorkshopCourseWiseDetails(sdcModel);
	}

	@ResponseBody
	@RequestMapping(value = { "getWorkshopCourseWiseColleges" },
			method = { org.springframework.web.bind.annotation.RequestMethod.GET,
					org.springframework.web.bind.annotation.RequestMethod.POST })
	public Response getWorkshopCourseWiseColleges(@RequestBody SdcModel sdcModel)
	{
		return this.sdcService.getWorkshopCourseWiseColleges(sdcModel);
	}

	@ResponseBody
	@RequestMapping(value = { "getWorkshopStudents" },
			method = { org.springframework.web.bind.annotation.RequestMethod.GET,
					org.springframework.web.bind.annotation.RequestMethod.POST })
	public Response getWorkshopStudents(@RequestBody FeedBack sdcModel)
	{
		return this.sdcService.getWorkshopStudents(sdcModel);
	}

	@ResponseBody
	@RequestMapping(value = "/getWorkshopFeedbackDetails",
			method = { RequestMethod.POST, RequestMethod.GET })
	public Response getWorkshopFeedbackDetails(@RequestBody SdcModel sdcModel) throws JSONException
	{
		return sdcService.getWorkshopFeedbackDetails(sdcModel);
	}
}