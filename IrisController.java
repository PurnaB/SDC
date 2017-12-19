package in.apssdc.controller;

import in.apssdc.model.CandidateDetails;
import in.apssdc.model.FDPModel;
import in.apssdc.model.IrisIdentificationModel;
import in.apssdc.model.StudentRegistration;
import in.apssdc.model.TraineeModel;
import in.apssdc.service.IrisService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.andromeda.commons.model.Response;

@RestController
@RequestMapping("/iris")
public class IrisController {

	@Autowired
	private IrisService irisService;

	@ResponseBody
	@RequestMapping(value = "insert", method = { RequestMethod.POST })
	public Response irisData(@RequestBody IrisIdentificationModel irisIdentificationModel) throws Exception {
		return irisService.irisData(irisIdentificationModel);
	}
	
	@ResponseBody
	@RequestMapping(value = "studentRegistraion", method = { RequestMethod.POST })
	public Response studentRegistration(@RequestBody StudentRegistration studentRegistration) throws Exception {
		return irisService.studentRegistration(studentRegistration);
	}
	
	@ResponseBody
	@RequestMapping(value = "enrollment", method = { RequestMethod.POST })
	public Response irisEnroll(@RequestBody TraineeModel traineeModel) throws Exception {
		return irisService.irisEnroll(traineeModel);
	}
	
	@ResponseBody
	@RequestMapping(value = "add", method = { RequestMethod.POST })
	public Response enroll(@RequestBody CandidateDetails candidateDetails) throws Exception {
		return irisService.enroll(candidateDetails);
	}
	
	@ResponseBody
	@RequestMapping(value = "sirisData", method = { RequestMethod.POST })
	public Response sirisEnroll(@RequestBody StudentRegistration studentRegistration) throws Exception {
		return irisService.sirisEnroll(studentRegistration);
	}
	
	@ResponseBody
	@RequestMapping(value = "reports", method = { RequestMethod.POST })
	public Response showReports() throws Exception {
		return irisService.showReports();
	}
	
	@ResponseBody
	@RequestMapping(value = "fdpreport", method = { RequestMethod.POST })
	public Response fdpreport() throws Exception {
		return irisService.fdpreport();
	}
	
	@ResponseBody
	@RequestMapping(value = "fdpCollegeReport", method = { RequestMethod.POST })
	public Response fdpCollegeReport(@RequestBody String assigned_to) throws Exception {
		return irisService.fdpCollegeReport(assigned_to);
	}
	
	@ResponseBody
	@RequestMapping(value = "collegeWise", method = { RequestMethod.POST })
	public Response collegeWise(@RequestBody String college) throws Exception {
		System.out.println("-------Controller------");
		return irisService.collegeWise(college);
	}
	
	@ResponseBody
	@RequestMapping(value = "getId", method = { RequestMethod.POST })
	public Response getId(@RequestBody String collegeid) throws Exception {
		return irisService.getId(collegeid);
	}
	
	@ResponseBody
	@RequestMapping(value = "fdpTrainerReport", method = { RequestMethod.POST })
	public Response fdpTrainerReport() throws Exception {
		return irisService.fdpTrainerReport();
	}
	
	@ResponseBody
	@RequestMapping(value = "fdpTrainerDistrictWise", method = { RequestMethod.POST })
	public Response fdpTrainerDistrictWise(@RequestBody String something) throws Exception {
		return irisService.fdpTrainerDistrictWise(something);
	}
	
	@ResponseBody
	@RequestMapping(value = "fdpTrainersList", method = { RequestMethod.POST })
	public Response fdpTrainersList(@RequestBody String collegeid) throws Exception {
		return irisService.fdpTrainersList(collegeid);
	}
	
	@ResponseBody
	@RequestMapping(value = "attendanceReport", method = { RequestMethod.POST })
	public Response attendanceReport() throws Exception {
		return irisService.attendanceReport();
	}
	
	@ResponseBody
	@RequestMapping(value = "attendanceTrainersReport", method = { RequestMethod.POST })
	public Response attendanceTrainersReport(@RequestBody String districtid) throws Exception {
		return irisService.attendanceTrainersReport(districtid);
	}
	
	@ResponseBody
	@RequestMapping(value = "fdpAttendanceFinal", method = { RequestMethod.POST })
	public Response fdpAttendanceFinal(@RequestBody FDPModel fdpModel) throws Exception {
		return irisService.fdpAttendanceFinal(fdpModel);
	}
}