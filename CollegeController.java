package in.apssdc.controller;

import java.text.ParseException;

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

import in.apssdc.model.CollegeModel;
import in.apssdc.model.Program;
import in.apssdc.model.Workshop;
import in.apssdc.service.CollegeService;

@RestController
@RequestMapping(value = { "/college" })
public class CollegeController
{
	@Autowired
	private CollegeService collegeService;

	@ResponseBody
	@RequestMapping(value = "getAllColleges", method = { RequestMethod.GET, RequestMethod.POST })
	public Response getPrograms()
	{
		return collegeService.getAllColleges();
	}
	
	@ResponseBody
	@RequestMapping(value = "getActiveTrainingPrograms", method = { RequestMethod.GET, RequestMethod.POST })
	public Response getActiveTrainingPrograms()
	{
		return collegeService.getActiveTrainingPrograms();
	}

	@ResponseBody
	@RequestMapping(value = "getWorkshopCourses",
			method = { RequestMethod.GET, RequestMethod.POST })
	public Response getWorkshopCourses(@RequestBody Integer programId)
	{
		return collegeService.getWorkshopCourses(programId);
	}

	@ResponseBody
	@RequestMapping(value = "saveUpcoming", method = { RequestMethod.GET, RequestMethod.POST })
	public Response saveUpcoming(@RequestBody Program program,
			HttpServletRequest httpServletRequest)
	{
		String clientProxyIp = HttpUtils.getClientProxyAddress(httpServletRequest);
		String clientIp = HttpUtils.getClientAddress(httpServletRequest);
		String ipAddress = "CLIENT:" + clientIp + ", CLIENT_PROXY:" + clientProxyIp;
		program.setIpAddress(ipAddress);
		return collegeService.saveUpcoming(program);
	}
	
	@ResponseBody
	@RequestMapping(value = "saveProgramPause", method = { RequestMethod.GET, RequestMethod.POST })
	public Response saveProgramPause(@RequestBody Program program,
			HttpServletRequest httpServletRequest)
	{
		String clientProxyIp = HttpUtils.getClientProxyAddress(httpServletRequest);
		String clientIp = HttpUtils.getClientAddress(httpServletRequest);
		String ipAddress = "CLIENT:" + clientIp + ", CLIENT_PROXY:" + clientProxyIp;
		program.setIpAddress(ipAddress);
		return collegeService.saveProgramPause(program);
	}
	
	@ResponseBody
	@RequestMapping(value = "saveStatus", method = { RequestMethod.GET, RequestMethod.POST })
	public Response saveStatus(@RequestBody Program program)
	{
		return collegeService.saveStatus(program);
	}

	@ResponseBody
	@RequestMapping(value = "getTrainingPrograms",
			method = { RequestMethod.GET, RequestMethod.POST })
	public Response getTrainingPrograms()
	{
		return collegeService.getTrainingPrograms();
	}

	@ResponseBody
	@RequestMapping(value = "getDistricts", method = { RequestMethod.POST, RequestMethod.GET })
	public Response getDsitricts()
	{
		return collegeService.getDistricts();
	}

	@ResponseBody
	@RequestMapping(value = "getDistricts1", method = { RequestMethod.POST, RequestMethod.GET })
	public Response getDistricts1()
	{
		return collegeService.getDistricts1();
	}

	@ResponseBody
	@RequestMapping(value = "getColleges", method = { RequestMethod.GET, RequestMethod.POST })
	public Response getColleges(@RequestBody Integer districtId)
	{
		return collegeService.getColleges(districtId);
	}

	@ResponseBody
	@RequestMapping(value = "saveWorkshop", method = { RequestMethod.POST, RequestMethod.GET })
	public Response saveWorkshop(@RequestBody Workshop workshop)
	{
		return collegeService.saveWorkshop(workshop);
	}

	@ResponseBody
	@RequestMapping(value = "getCourses", method = { RequestMethod.POST, RequestMethod.GET })
	public Response getCourses()
	{
		return collegeService.getCourses();
	}

	@ResponseBody
	@RequestMapping(value = "getUniversities", method = { RequestMethod.POST, RequestMethod.GET })
	public Response getUniversities()
	{
		return collegeService.getUniversities();
	}

	@ResponseBody
	@RequestMapping(value = "saveCourse", method = { RequestMethod.POST })
	public Response saveCourse(@RequestBody Program program)
	{
		return collegeService.saveCourse(program);
	}

	@ResponseBody
	@RequestMapping(value = "addCollege", method = { RequestMethod.POST })
	public Response addCollege(@RequestBody CollegeModel college)
			throws JSONException, ParseException
	{
		return collegeService.addCollege(college);
	}

	@ResponseBody
	@RequestMapping(value = "editById", method = { RequestMethod.POST })
	public Response editById(@RequestBody CollegeModel college)
	{
		return collegeService.editById(college);
	}

	@ResponseBody
	@RequestMapping(value = "updateData", method = { RequestMethod.POST })
	public Response updateData(@RequestBody CollegeModel college)
	{
		System.out.println("----------------Leave request-------------" + college);
		return collegeService.updateData(college);

	}

}