package in.apssdc.controller;

import in.apssdc.model.College;
import in.apssdc.model.Student;
import in.apssdc.service.ServiceService;

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
@RequestMapping("/service")
public class ServiceController
{
	@Autowired
	ServiceService serviceService;

	@ResponseBody
	@RequestMapping(value = "/getDistricts", method = { RequestMethod.POST, RequestMethod.GET })
	private Response getDistricts()
	{
		return serviceService.getDistricts();
	}

	@ResponseBody
	@RequestMapping(value = "/getCollegeDetails", method = { RequestMethod.POST })
	private Response getCollegeDetails(@RequestBody Integer districtId)
	{
		return serviceService.getCollegeDetails(districtId);
	}

	@ResponseBody
	@RequestMapping(value = "/getLink", method = { RequestMethod.POST })
	private Response getLink(@RequestBody College college) throws JSONException
	{
		return serviceService.getLink(college);
	}

	@ResponseBody
	@RequestMapping(value = { "/checkAadhaar" }, method = { RequestMethod.POST })
	public Response checkAadhaar(@RequestBody String aadhaar)
	{
		return serviceService.checkAadhaar(aadhaar);
	}

	@ResponseBody
	@RequestMapping(value = { "/getStudentDetails" }, method = { RequestMethod.POST })
	public Response getStudentDetails(@RequestBody String registrationId)
	{
		return serviceService.getStudentDetails(registrationId);
	}

	@ResponseBody
	@RequestMapping(value = { "/changeStudentCourse" }, method = { RequestMethod.POST })
	public Response changeStudentCourse(@RequestBody Student student,
			HttpServletRequest httpServletRequest)
	{
		String clientProxyIp = HttpUtils.getClientProxyAddress(httpServletRequest);
		String clientIp = HttpUtils.getClientAddress(httpServletRequest);
		String ipAddress = "CLIENT:" + clientIp + ", CLIENT_PROXY:" + clientProxyIp;
		student.setIpAddress(ipAddress);

		/*System.out.println("--> Student details");
		System.out.println(student);*/

		return serviceService.changeStudentCourse(student);
	}

	@ResponseBody
	@RequestMapping(value = { "/getTrainingPrograms" }, method = { RequestMethod.POST })
	public Response getTrainingPrograms(@RequestBody College details)
	{
		return serviceService.getTrainingPrograms(details);
	}

	@ResponseBody
	@RequestMapping(value = { "/getProgramsDetails" }, method = { RequestMethod.POST })
	public Response getProgramsDetails(@RequestBody Integer trainingProgramId)
	{
		return serviceService.getProgramsDetails(trainingProgramId);
	}
}