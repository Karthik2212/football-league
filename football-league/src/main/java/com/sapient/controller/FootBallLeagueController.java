package com.sapient.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.dto.FootBallLeagueRequest;
import com.sapient.dto.FootBallLeagueResponse;
import com.sapient.service.FootBallLeagueService;

@RestController
@RequestMapping(value = "/")
public class FootBallLeagueController {

	private static final Logger LOGGER = LoggerFactory.getLogger(FootBallLeagueController.class);

	@Autowired
	private FootBallLeagueService service;

	@GetMapping
	public FootBallLeagueResponse getCountries(
			@RequestParam(name = "country_name", required = false) String countryName,
			@RequestParam(name = "league_Name", required = false) String leagueName,
			@RequestParam(name = "team_name", required = false) String teamName) {
		try {
			FootBallLeagueRequest footBallLeagueRequest = new FootBallLeagueRequest(countryName, leagueName, teamName);
			LOGGER.info("Entering into Application {} ", footBallLeagueRequest);
			return service.getFootBallLeagueDetails(footBallLeagueRequest);
		} catch (Exception e) {
			LOGGER.error("Please contact Admin-{}", e.getMessage());
		}
		return new FootBallLeagueResponse();
	}

}
