package in.apssdc.controller;

import in.apssdc.model.COE;
import in.apssdc.model.CRT;
import in.apssdc.model.College;
import in.apssdc.model.CollegeManagementModel;
import in.apssdc.model.CollegeModel;
import in.apssdc.model.CollegeStudentsSummary;
import in.apssdc.model.FileModel;
import in.apssdc.model.Infrastructure;
import in.apssdc.model.Internet;
import in.apssdc.model.Residence;
import in.apssdc.model.SDCTimings;
import in.apssdc.model.Servers;
import in.apssdc.model.SocialActivity;
import in.apssdc.model.Softwares;
import in.apssdc.model.StudentRegistrationModal;
import in.apssdc.service.EoIService;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

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

import commons.util.Base64;

@RestController
@RequestMapping("/eoi")
public class EoIController
{
	@Autowired
	private EoIService eoiService;

	@ResponseBody
	@RequestMapping(value = "/getPrimaryDetails", method = { RequestMethod.POST })
	private Response getPrimaryDetails(@RequestBody CollegeModel college)
	{
		
		return eoiService.getPrimaryDetails(college);
	}
	
	@ResponseBody
	@RequestMapping(value = "/savePrimaryDetails", method = { RequestMethod.POST })
	private Response savePrimaryDetails(@RequestBody CollegeModel college, HttpServletRequest httpServletRequest)
	{
		String clientIp = HttpUtils.getClientAddress(httpServletRequest);
		String clientProxyIp = HttpUtils.getClientProxyAddress(httpServletRequest);
		String ipAddress = "CLIENT:" + clientIp + ", CLIENT_PROXY:" + clientProxyIp;
		college.setIpAddress(ipAddress);
		return eoiService.savePrimaryDetails(college);
	}
	@ResponseBody
	@RequestMapping(value = "/saveAllPrimaryDetails", method = { RequestMethod.POST })
	private Response saveAllPrimaryDetails(@RequestBody CollegeModel college, HttpServletRequest httpServletRequest)
	{
		String clientIp = HttpUtils.getClientAddress(httpServletRequest);
		String clientProxyIp = HttpUtils.getClientProxyAddress(httpServletRequest);
		String ipAddress = "CLIENT:" + clientIp + ", CLIENT_PROXY:" + clientProxyIp;
		college.setIpAddress(ipAddress);
		return eoiService.saveAllPrimaryDetails(college);
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/getCollegeManagementDetails", method = { RequestMethod.POST })
	private Response getCollegeManagementDetails(@RequestBody College college)
	{
		return eoiService.getCollegeManagementDetails(college);
	}
	@ResponseBody
	@RequestMapping(value = { "validateAadhaar" }, method = { RequestMethod.POST })
	public Response validateAadhaar(@RequestBody College spocDetails)
	{
		return eoiService.validateAadhaar(spocDetails);
	}
	@ResponseBody
	@RequestMapping(value = { "validateAadhaar1" }, method = { RequestMethod.POST })
	public Response validateAadhaar1(@RequestBody College spocDetails)
	{
		return eoiService.validateAadhaar1(spocDetails);
	}
	
	@ResponseBody
	@RequestMapping(value = "/saveCollegeManagementDetails", method = { RequestMethod.POST })
	private Response saveCollegeManagementDetails(@RequestBody CollegeManagementModel college)
	{
		return eoiService.saveCollegeManagementDetails(college);
	}
	@ResponseBody
	@RequestMapping(value = "/saveCollegeStudentsSummaryDetails", method = { RequestMethod.POST })
	private Response saveCollegeStudentsSummaryDetails(@RequestBody College college)
	{
		return eoiService.saveCollegeStudentsSummaryDetails(college);
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/saveSingleCollegeStudentsSummary", method = { RequestMethod.POST })
	private Response saveSingleCollegeStudentsSummary(@RequestBody CollegeStudentsSummary college, HttpServletRequest httpServletRequest)
	{
		String clientIp = HttpUtils.getClientAddress(httpServletRequest);
		String clientProxyIp = HttpUtils.getClientProxyAddress(httpServletRequest);
		String ipAddress = "CLIENT:" + clientIp + ", CLIENT_PROXY:" + clientProxyIp;
		college.setIpAddress(ipAddress);
		return eoiService.saveSingleCollegeStudentsSummary(college);
	}
	@ResponseBody
	@RequestMapping(value = "/saveCollegeSoftwaresDetails", method = { RequestMethod.POST })
	private Response saveCollegeSoftwaresDetails(@RequestBody Softwares college)
	{
		return eoiService.saveCollegeSoftwaresDetails(college);
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/saveSoftwareDetails", method = { RequestMethod.POST })
	private Response saveSoftwareDetails(@RequestBody Softwares college, HttpServletRequest httpServletRequest)
	{
		String clientIp = HttpUtils.getClientAddress(httpServletRequest);
		String clientProxyIp = HttpUtils.getClientProxyAddress(httpServletRequest);
		String ipAddress = "CLIENT:" + clientIp + ", CLIENT_PROXY:" + clientProxyIp;
		college.setIpAddress(ipAddress);
		return eoiService.saveSoftwareDetails(college);
	}
	
	@ResponseBody
	@RequestMapping(value = "/saveCollegeServersDetails", method = { RequestMethod.POST })
	private Response saveCollegeServersDetails(@RequestBody Softwares college)
	{
		return eoiService.saveCollegeServersDetails(college);
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/saveServerDetails", method = { RequestMethod.POST })
	private Response saveServerDetails(@RequestBody Servers college, HttpServletRequest httpServletRequest)
	{
		String clientIp = HttpUtils.getClientAddress(httpServletRequest);
		String clientProxyIp = HttpUtils.getClientProxyAddress(httpServletRequest);
		String ipAddress = "CLIENT:" + clientIp + ", CLIENT_PROXY:" + clientProxyIp;
		college.setIpAddress(ipAddress);
		return eoiService.saveServerDetails(college);
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/getClgBasicDetails", method = { RequestMethod.POST })
	private Response getClgBasicDetails(@RequestBody Integer collegeId)
	{
		return eoiService.getClgBasicDetails(collegeId);
	}

	@ResponseBody
	@RequestMapping(value = "/saveClgBasicDetails", method = {  RequestMethod.POST, RequestMethod.GET  })
	private Response saveClgBasicDetails(@RequestBody CollegeModel college)
	{
		return eoiService.saveClgBasicDetails(college);
	}
	
	@ResponseBody
	@RequestMapping(value = "/getCollegeManagementDetails1", method = {  RequestMethod.POST, RequestMethod.GET  })
	private Response getCollegeManagementDetails1(@RequestBody CollegeModel college)
	{
		return eoiService.getCollegeManagementDetails1(college);
	}

	@ResponseBody
	@RequestMapping(value = "/getStatus", method = { RequestMethod.POST })
	private Response getStatus(@RequestBody Integer collegeId)
	{
		return eoiService.getStatus(collegeId);
	}

	@ResponseBody
	@RequestMapping(value = "/saveCRTDetails", method = { RequestMethod.POST })
	private Response saveCRTDetails(@RequestBody CRT crt, HttpServletRequest httpServletRequest)
			throws JSONException
	{
		String clientProxyIp = HttpUtils.getClientProxyAddress(httpServletRequest);
		String clientIp = HttpUtils.getClientAddress(httpServletRequest);
		String ipAddress = "CLIENT:" + clientIp + ", CLIENT_PROXY:" + clientProxyIp;
		crt.setIpAddress(ipAddress);
		return eoiService.saveCRTDetails(crt);
	}
	
	@ResponseBody
	@RequestMapping(value = "/saveResidentialDetails", method = { RequestMethod.POST })
	private Response saveResidentialDetails(@RequestBody Residence residence, HttpServletRequest httpServletRequest)
			throws JSONException
	{
		String clientProxyIp = HttpUtils.getClientProxyAddress(httpServletRequest);
		String clientIp = HttpUtils.getClientAddress(httpServletRequest);
		String ipAddress = "CLIENT:" + clientIp + ", CLIENT_PROXY:" + clientProxyIp;
		residence.setIpAddress(ipAddress);
		return eoiService.saveResidentialDetails(residence);
	}
	
	@ResponseBody
	@RequestMapping(value = "/getCRTDetails", method = { RequestMethod.POST })
	private Response getCRTDetails(@RequestBody Integer collegeId)
	{
		return eoiService.getCRTDetails(collegeId);
	}
	
	@ResponseBody
	@RequestMapping(value = "/getResidentialDetails", method = { RequestMethod.POST })
	private Response getResidentialDetails(@RequestBody Integer collegeId)
	{
		return eoiService.getResidentialDetails(collegeId);
	}
	
	@ResponseBody
	@RequestMapping(value = "/saveTimingsDetails", method = { RequestMethod.POST })
	private Response saveTimingsDetails(@RequestBody SDCTimings sdcTimings, HttpServletRequest httpServletRequest)
			throws JSONException
	{
		String clientProxyIp = HttpUtils.getClientProxyAddress(httpServletRequest);
		String clientIp = HttpUtils.getClientAddress(httpServletRequest);
		String ipAddress = "CLIENT:" + clientIp + ", CLIENT_PROXY:" + clientProxyIp;
		sdcTimings.setIpAddress(ipAddress);
		return eoiService.saveTimingsDetails(sdcTimings);
	}

	@ResponseBody
	@RequestMapping(value = "/getTimingsDetails", method = { RequestMethod.POST })
	private Response getTimingsDetails(@RequestBody Integer collegeId)
	{
		return eoiService.getTimingsDetails(collegeId);
	}
	
	@ResponseBody
	@RequestMapping(value = "/getMandals", method = { RequestMethod.POST })
	private Response getMandals(@RequestBody Integer districtId)
	{
		return eoiService.getMandals(districtId);
	}
	
	@ResponseBody
	@RequestMapping(value = "/getPanchayats", method = { RequestMethod.POST })
	private Response getPanchayats(@RequestBody SocialActivity activity)
	{
		return eoiService.getPanchayats(activity);
	}
	
	@ResponseBody
	@RequestMapping(value = "/getVillages", method = { RequestMethod.POST })
	private Response getVillages(@RequestBody SocialActivity activity)
	{
		return eoiService.getVillages(activity);
	}
	
	@ResponseBody
	@RequestMapping(value = "/saveSocialActivities", method = { RequestMethod.POST })
	private Response saveSocialActivities(@RequestBody SocialActivity activity, HttpServletRequest httpServletRequest)
			throws JSONException
	{
		String clientProxyIp = HttpUtils.getClientProxyAddress(httpServletRequest);
		String clientIp = HttpUtils.getClientAddress(httpServletRequest);
		String ipAddress = "CLIENT:" + clientIp + ", CLIENT_PROXY:" + clientProxyIp;
		activity.setIpAddress(ipAddress);
		return eoiService.saveSocialActivities(activity);
	}
	
	@ResponseBody
	@RequestMapping(value = "/getSocialActivities", method = { RequestMethod.POST })
	private Response getSocialActivities(@RequestBody Integer collegeId)
	{
		return eoiService.getSocialActivities(collegeId);
	}
	@ResponseBody
	@RequestMapping(value = "/getInternetDetails", method = { RequestMethod.POST })
	private Response getInternetDetails(@RequestBody Integer collegeId)
	{
		return eoiService.getInternetDetails(collegeId);
	}
	
	@ResponseBody
	@RequestMapping(value = "/saveInternetDetails", method = { RequestMethod.POST })
	private Response saveInternetDetails(@RequestBody Internet internet, HttpServletRequest httpServletRequest)
			throws JSONException
	{
		String clientProxyIp = HttpUtils.getClientProxyAddress(httpServletRequest);
		String clientIp = HttpUtils.getClientAddress(httpServletRequest);
		String ipAddress = "CLIENT:" + clientIp + ", CLIENT_PROXY:" + clientProxyIp;
		internet.setIpAddress(ipAddress);
		return eoiService.saveInternetDetails(internet);
	}
	
	@ResponseBody
	@RequestMapping(value = "/saveLabDetails", method = { RequestMethod.POST })
	private Response saveLabDetails(@RequestBody Infrastructure infrastructure, HttpServletRequest httpServletRequest)
			throws JSONException
	{
		String clientProxyIp = HttpUtils.getClientProxyAddress(httpServletRequest);
		String clientIp = HttpUtils.getClientAddress(httpServletRequest);
		String ipAddress = "CLIENT:" + clientIp + ", CLIENT_PROXY:" + clientProxyIp;
		infrastructure.setIpAddress(ipAddress);
		return eoiService.saveLabDetails(infrastructure);
	}
	
	@ResponseBody
	@RequestMapping(value = "/getLabDetails", method = { RequestMethod.POST })
	private Response getLabDetails(@RequestBody Integer collegeId)
	{
		return eoiService.getLabDetails(collegeId);
	}
	@ResponseBody
	@RequestMapping(value = "/getCOEDetails", method = { RequestMethod.POST })
	private Response getCOEDetails(@RequestBody Integer collegeId)
	{
		return eoiService.getCOEDetails(collegeId);
	}
	
	@ResponseBody
	@RequestMapping(value = "/saveCOEDetails", method = { RequestMethod.POST })
	private Response saveCOEDetails(@RequestBody COE coe, HttpServletRequest httpServletRequest)
			throws JSONException
	{
		String clientProxyIp = HttpUtils.getClientProxyAddress(httpServletRequest);
		String clientIp = HttpUtils.getClientAddress(httpServletRequest);
		String ipAddress = "CLIENT:" + clientIp + ", CLIENT_PROXY:" + clientProxyIp;
		coe.setIpAddress(ipAddress);
		return eoiService.saveCOEDetails(coe);
	}
	
	
	 
	  @ResponseBody
	  @RequestMapping(value={"saveDetails"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
	  public Response saveDetails(@RequestBody List<StudentRegistrationModal> student, HttpServletRequest httpServletRequest)
	  {
	    String clientAddress = HttpUtils.getClientAddress(httpServletRequest);
	    String proxyAddress = HttpUtils.getClientProxyAddress(httpServletRequest);
	    String ipAddress = 
	      "Client Address: " + clientAddress + "Client Proxy Address: " + proxyAddress;
	    
	    List<String> pathsList = new ArrayList();
	    
	    StudentRegistrationModal studentRegistrationModal = (StudentRegistrationModal)student.get(0);
	    for (int i = 0; i < studentRegistrationModal.getFilePaths().size(); i++)
	    {
	      ((FileModel)studentRegistrationModal.getFilePaths().get(i)).setFolderName(studentRegistrationModal.getCollegeName());
	      String fileDetails = handleFileUpload((FileModel)studentRegistrationModal.getFilePaths().get(i));
	      pathsList.add(fileDetails);
	    }
	    System.out.println("========================="+pathsList);
	    return this.eoiService.saveDetails(student, ipAddress, pathsList);
	  }
	  
	  public String handleFileUpload(@RequestBody FileModel fileModel)
	  {
	    FileOutputStream fos = null;
	    String file = null;
	    try
	    {
	      String folderName = fileModel.getFolderName();
	      String imageValue = fileModel.getBase64String();
	      byte[] imageByteArray = decodeImage(imageValue);
	      
	      String baseDir = 
	        System.getProperty("catalina.base") + "/webapps/EOIDocs/" + folderName;
	      File dir = new File(baseDir);
	      if (!Files.isDirectory(Paths.get(baseDir, new String[0]), new LinkOption[0])) {
	        dir.mkdirs();
	      }
	      fos = new FileOutputStream(baseDir + "/" + fileModel.getName());
	      file = 
	        System.getProperty("catalina.base") + "/webapps/EOIDocs/" + folderName + 
	        "/" + fileModel.getName();
	      
	      fos.write(imageByteArray);
	      fos.close();
	    }
	    catch (Exception e)
	    {
	      System.out.println("Exception: " + e.getMessage());
	    }
	    return file;
	  }
	  
	  public static byte[] decodeImage(String imageValue)
	  {
	    return Base64.decode(imageValue);
	  }
	
	  @ResponseBody
		@RequestMapping(value = "getCollegeDetailsById", method = {RequestMethod.GET, RequestMethod.POST })
		public Response getCollegeDetailsById(@RequestBody College college)
		{
			return eoiService.getCollegeDetailsById(college);
		}
	
}