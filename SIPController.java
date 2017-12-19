package in.apssdc.controller;

import in.apssdc.model.Payment;
import in.apssdc.model.SIP;
import in.apssdc.model.SdcModel;
import in.apssdc.model.Student;
import in.apssdc.service.SIPService;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.andromeda.commons.model.Response;

@RestController
@RequestMapping("/sip")
public class SIPController
{
	@Autowired
	SIPService sipService;

	@ResponseBody
	@RequestMapping(value = "allWorkshopPrograms", method = { RequestMethod.POST })
	public Response getWorkshopPrograms(@RequestBody Integer collegeId)
	{
		return sipService.getWorkshopPrograms(collegeId);
	}

	@ResponseBody
	@RequestMapping(value = "getWorkshopProgmCourses", method = { RequestMethod.POST })
	public Response getWorkshopProgmCourses(@RequestBody Student student)
	{
		return sipService.getWorkshopProgmCourses(student);
	}

	@ResponseBody
	@RequestMapping(value = "/getWorkshopStudents", method = { RequestMethod.POST })
	public Response getWorkshopStudents(@RequestBody SdcModel sdcModel)
	{
		return sipService.getWorkshopStudents(sdcModel);
	}

	@ResponseBody
	@RequestMapping(value = "/getCollegeId", method = { RequestMethod.POST })
	private Response getCollegeId(@RequestBody String userName)
	{
		return sipService.getCollegeId(userName);
	}

	@ResponseBody
	@RequestMapping(value = "/getCollegeCount", method = { RequestMethod.POST })
	private Response sipService(@RequestBody Integer collegeId)
	{
		return sipService.getCollegeCount(collegeId);
	}

	@ResponseBody
	@RequestMapping(value = "/getCollegeYearWiseCount", method = { RequestMethod.POST })
	private Response getCollegeYearWiseCount(@RequestBody SIP sip)
	{
		return sipService.getCollegeYearWiseCount(sip);
	}

	@ResponseBody
	@RequestMapping(value = "/saveProjectInfo", method = { RequestMethod.POST })
	private Response saveProjectInfo(@RequestBody Student student)
	{
		return sipService.saveProjectInfo(student);
	}

	@ResponseBody
	@RequestMapping(value = "/getSummaryCounts", method = { RequestMethod.POST })
	private Response getSummaryCounts(@RequestBody SIP sip)
	{
		return sipService.getSummaryCounts(sip);
	}

	@ResponseBody
	@RequestMapping(value = "/getMentorsDetails", method = { RequestMethod.POST })
	private Response getMentorsDetails(@RequestBody SIP sip)
	{
		return sipService.getMentorsDetails(sip);
	}

	@ResponseBody
	@RequestMapping(value = "/getCollegeYearWiseCount1", method = { RequestMethod.POST })
	private Response getCollegeYearWiseCount1(@RequestBody SIP sip)
	{
		return sipService.getCollegeYearWiseCount1(sip);
	}

	@ResponseBody
	@RequestMapping(value = "/getProgramWise", method = { RequestMethod.POST })
	private Response getProgramWise(@RequestBody SIP sip)
	{
		return sipService.getProgramWise(sip);
	}

	@ResponseBody
	@RequestMapping(value = "/getProgramNames", method = { RequestMethod.POST })
	private Response getProgramNames(@RequestBody SIP sip)
	{
		return sipService.getProgramNames(sip);
	}

	@ResponseBody
	@RequestMapping(value = "/getStudentsDetails", method = { RequestMethod.POST })
	private Response getStudentsDetails(@RequestBody SIP sip)
	{
		return sipService.getStudentsDetails(sip);
	}

	@ResponseBody
	@RequestMapping(value = "/getStudentAllDetails", method = { RequestMethod.POST })
	private Response getStudentAllDetails(@RequestBody String registrationId)
	{
		return sipService.getStudentAllDetails(registrationId);
	}

	@ResponseBody
	@RequestMapping(value = "/getCollegeDetails",
			method = { RequestMethod.POST, RequestMethod.GET })
	private Response getCollegeDetails()
	{
		return sipService.getCollegeDetails();
	}

	@ResponseBody
	@RequestMapping(value = "/getLink", method = { RequestMethod.POST })
	private Response getLink(@RequestBody SIP sip) throws JSONException
	{
		return sipService.getLink(sip);
	}

	@ResponseBody
	@RequestMapping(value = "/getToopleLink", method = { RequestMethod.POST })
	private Response getToopleLink(@RequestBody SIP sip) throws JSONException
	{
		return sipService.getToopleLink(sip);
	}

	@ResponseBody
	@RequestMapping(value = "/getToopleRegStudents",
			method = { RequestMethod.POST, RequestMethod.GET })
	private Response getToopleRegStudents()
	{
		return sipService.getToopleRegStudents();
	}

	@ResponseBody
	@RequestMapping(value = { "getCollegeWiseStudents" }, method = { RequestMethod.POST })
	public Response getCollegeWiseStudents(@RequestBody Integer collegeId)
	{
		return sipService.getCollegeWiseStudents(collegeId);
	}

	@ResponseBody
	@RequestMapping(value = { "getCollegeWisePaidStudents" }, method = { RequestMethod.POST })
	public Response getCollegeWisePaidStudents(@RequestBody Integer collegeId)
	{
		return sipService.getCollegeWisePaidStudents(collegeId);
	}

	@ResponseBody
	@RequestMapping(value = { "validateAadhaar" }, method = { RequestMethod.POST })
	public Response validateAadhaar(@RequestBody SIP spocDetails)
	{
		return sipService.validateAadhaar(spocDetails);
	}

	@ResponseBody
	@RequestMapping(value = { "validateAadhaar1" }, method = { RequestMethod.POST })
	public Response validateAadhaar1(@RequestBody SIP spocDetails)
	{
		return sipService.validateAadhaar1(spocDetails);
	}

	@ResponseBody
	@RequestMapping(value = { "getCollegePaymentDetails" }, method = { RequestMethod.POST })
	public Response getCollegePaymentDetails(@RequestBody Integer collegeId)
	{
		return sipService.getCollegePaymentDetails(collegeId);
	}

	@ResponseBody
	@RequestMapping(value = { "getUnPaidDetails" }, method = { RequestMethod.POST })
	public Response getUnPaidDetails(@RequestBody Student student)
	{
		return sipService.getUnPaidDetails(student);
	}

	@ResponseBody
	@RequestMapping(value = { "getCourseWise" }, method = { RequestMethod.POST })
	public Response getCourseWise(@RequestBody Integer collegeId)
	{
		return sipService.getCourseWise(collegeId);
	}

	@ResponseBody
	@RequestMapping(value = { "getCourseWiseSCST" }, method = { RequestMethod.POST })
	public Response getTotalSCST(@RequestBody Integer collegeId)
	{
		return sipService.getCourseWiseSCST(collegeId);
	}

	@ResponseBody
	@RequestMapping(value = { "getCourseWiseSCSTDetails" }, method = { RequestMethod.POST })
	public Response getCourseWiseSCSTDetails(@RequestBody Student student)
	{
		return sipService.getCourseWiseSCSTDetails(student);
	}

	@ResponseBody
	@RequestMapping(value = { "getIBMExtraCollegeDetails" },
			method = { RequestMethod.GET, RequestMethod.POST })
	public Response getIBMExtraCollegeDetails()
	{
		return sipService.getIBMExtraCollegeDetails();
	}

	@ResponseBody
	@RequestMapping(value = { "paymentOption" }, method = { RequestMethod.POST })
	public Response paymentOption(@RequestBody Payment payment) throws JSONException
	{
		/*
		 * System.out.println("-----Payment"); System.out.println(payment);
		 */
		return sipService.paymentOption(payment);
	}

	@ResponseBody
	@RequestMapping(value = { "checkAadhaar" }, method = { RequestMethod.POST })
	public Response checkAadhaar(@RequestBody SIP details) throws JSONException
	{
		return sipService.checkAadhaar(details);
	}
}