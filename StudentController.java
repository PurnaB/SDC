package in.apssdc.controller;

import in.apssdc.model.SdcModel;
import in.apssdc.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.andromeda.commons.model.Response;

@RestController
@RequestMapping("/student")
public class StudentController
{
	@Autowired
	StudentService studentService;

	@ResponseBody
	@RequestMapping(value = "/getAssignedStudents", method = { RequestMethod.POST })
	private Response getAssignedStudents(@RequestBody String employeeId)
	{
		return studentService.getAssignedStudents(employeeId);
	}
	
	@ResponseBody
	@RequestMapping(value = { "saveAssignedStdAttendance" }, method = { RequestMethod.POST })
	public Response saveAssignedStdAttendance(@RequestBody SdcModel sdcModel)
	{
		return studentService.saveAssignedStdAttendance(sdcModel);
	}
}