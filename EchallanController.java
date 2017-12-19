package in.apssdc.controller;

import in.apssdc.model.Echallan;
import in.apssdc.service.EchallanService;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.andromeda.commons.model.Response;
import com.andromeda.commons.util.HttpUtils;

@RestController
@RequestMapping("/echallan")
public class EchallanController
{
	Response response = new Response();

	@Autowired
	private EchallanService echallanService;

	@ResponseBody
	@RequestMapping(value = "add", method = { RequestMethod.GET, RequestMethod.POST })
	public Response add(@RequestBody Echallan echallan, HttpServletRequest httpServletRequest)
	{
		String clientProxyIp = HttpUtils.getClientProxyAddress(httpServletRequest);
		String clientIp = HttpUtils.getClientAddress(httpServletRequest);
		String ipAddress = "CLIENT:" + clientIp + ", CLIENT_PROXY:" + clientProxyIp;
		echallan.setIpAddress(ipAddress);
		return echallanService.add(echallan);
	}

}