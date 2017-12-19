package in.apssdc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatsController
{
	@RequestMapping(value = "stats", method = { RequestMethod.GET, RequestMethod.POST })
	public boolean stats()
	{
		return true;
	}
}