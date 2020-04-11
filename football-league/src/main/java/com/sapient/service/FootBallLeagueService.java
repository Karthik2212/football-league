package com.sapient.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sapient.dto.FootBallLeagueRequest;
import com.sapient.dto.FootBallLeagueResponse;

@Service
public class FootBallLeagueService {

	private static final Logger LOGGER = LoggerFactory.getLogger(FootBallLeagueService.class);
	private static final String URL = "https://apiv2.apifootball.com/";
	private static final String API_KEY = "9bb66184e0c8145384fd2cc0f7b914ada57b4e8fd2e4d6d586adcc27c257a978";
	private static RestTemplate restTemplate = new RestTemplate();

	public FootBallLeagueResponse getFootBallLeagueDetails(FootBallLeagueRequest footBallLeagueRequest)
			throws JsonMappingException, JsonProcessingException, Exception {
		LOGGER.info("In Service layer {}", footBallLeagueRequest);
		String countryId = getCountryId(footBallLeagueRequest.getCountryName());
		String leagueId = getLeagueId(countryId);
		String teamId = getTeamKey(leagueId, footBallLeagueRequest.getTeamName());
		String overallLeaguePosition = getOverallLeaguePosition(leagueId);
		return new FootBallLeagueResponse(countryId, footBallLeagueRequest.getCountryName(), leagueId,
				footBallLeagueRequest.getLeagueName(), teamId, footBallLeagueRequest.getTeamName(),
				overallLeaguePosition);
	}

	private String getCountryId(String countryName) throws JsonMappingException, JsonProcessingException {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> request = new HttpEntity<String>(headers);
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(URL).queryParam("action", "get_countries")
				.queryParam("APIkey", API_KEY);
		String response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, request, String.class).getBody();
		if (StringUtils.hasText(response)) {
			ObjectMapper objectMapper = new ObjectMapper();
			JsonNode root = objectMapper.readTree(response);
			if (root.isArray()) {
				for (JsonNode objNode : root) {
					if (objNode.get("country_name").asText().equals(countryName)) {
						return objNode.get("country_id").asText();
					}
				}
			}
		}
		return null;
	}

	private String getLeagueId(String countryId) throws JsonMappingException, JsonProcessingException {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> request = new HttpEntity<String>(headers);
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(URL).queryParam("action", "get_leagues")
				.queryParam("country_id", countryId).queryParam("APIkey", API_KEY);
		String response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, request, String.class).getBody();
		if (StringUtils.hasText(response)) {
			ObjectMapper objectMapper = new ObjectMapper();
			JsonNode root = objectMapper.readTree(response);
			return root.get(0).get("league_id").asText();
		}
		return null;
	}

	private String getTeamKey(String leagueId, String teamName) throws JsonMappingException, JsonProcessingException {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> request = new HttpEntity<String>(headers);
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(URL).queryParam("action", "get_teams")
				.queryParam("league_id", leagueId).queryParam("APIkey", API_KEY);
		String response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, request, String.class).getBody();
		if (StringUtils.hasText(response)) {
			ObjectMapper objectMapper = new ObjectMapper();
			JsonNode root = objectMapper.readTree(response);
			JsonNode team = null;
			if (root.isArray()) {
				for (JsonNode objNode : root) {
					if (objNode.get("team_name").asText().equals(teamName)) {
						return objNode.get("team_key").asText();
					}
				}
			}
		}
		return null;
	}

	private String getOverallLeaguePosition(String leagueId) throws JsonMappingException, JsonProcessingException {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> request = new HttpEntity<String>(headers);
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(URL).queryParam("action", "get_standings")
				.queryParam("league_id", leagueId).queryParam("APIkey", API_KEY);
		String response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, request, String.class).getBody();
		if (StringUtils.hasText(response)) {
			ObjectMapper objectMapper = new ObjectMapper();
			JsonNode root = objectMapper.readTree(response);
			JsonNode team = null;
			if (root.isArray()) {
				for (JsonNode objNode : root) {
					if (objNode.get("league_id").asText().equals(leagueId)) {
						return objNode.get("overall_league_position").asText();
					}
				}
			}
		}
		return null;
	}

}
