package in.apssdc.controller;

import in.apssdc.model.FIP;
import in.apssdc.service.FIPService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.andromeda.commons.model.Response;

@RestController
@RequestMapping("/fip")
public class FIPController
{
	@Autowired
	FIPService fipService;

	@ResponseBody
	@RequestMapping(value = "/getFipPrograms", method = { RequestMethod.POST })
	private Response getFipPrograms(@RequestBody FIP fip)
	{
		return fipService.getFipPrograms(fip);
	}

	@ResponseBody
	@RequestMapping(value = "/getFacultyDetails", method = { RequestMethod.POST })
	private Response getFacultyDetails(@RequestBody FIP fip)
	{
		return fipService.getFacultyDetails(fip);
	}

}