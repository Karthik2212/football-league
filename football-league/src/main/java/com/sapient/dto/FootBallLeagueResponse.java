package com.sapient.dto;

public class FootBallLeagueResponse {

	private String countryId;
	private String countryName;
	private String LeagueId;
	private String LeagueName;
	private String teamId;
	private String teamName;
	private String overallLeaguePosition;

	public FootBallLeagueResponse() {

	}

	public FootBallLeagueResponse(String countryId, String countryName, String leagueId, String leagueName,
			String teamId, String teamName, String overallLeaguePosition) {
		super();
		this.countryId = countryId;
		this.countryName = countryName;
		LeagueId = leagueId;
		LeagueName = leagueName;
		this.teamId = teamId;
		this.teamName = teamName;
		this.overallLeaguePosition = overallLeaguePosition;
	}

	public String getCountryId() {
		return countryId;
	}

	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getLeagueId() {
		return LeagueId;
	}

	public void setLeagueId(String leagueId) {
		LeagueId = leagueId;
	}

	public String getLeagueName() {
		return LeagueName;
	}

	public void setLeagueName(String leagueName) {
		LeagueName = leagueName;
	}

	public String getTeamId() {
		return teamId;
	}

	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getOverallLeaguePosition() {
		return overallLeaguePosition;
	}

	public void setOverallLeaguePosition(String overallLeaguePosition) {
		this.overallLeaguePosition = overallLeaguePosition;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((LeagueId == null) ? 0 : LeagueId.hashCode());
		result = prime * result + ((LeagueName == null) ? 0 : LeagueName.hashCode());
		result = prime * result + ((countryId == null) ? 0 : countryId.hashCode());
		result = prime * result + ((countryName == null) ? 0 : countryName.hashCode());
		result = prime * result + ((overallLeaguePosition == null) ? 0 : overallLeaguePosition.hashCode());
		result = prime * result + ((teamId == null) ? 0 : teamId.hashCode());
		result = prime * result + ((teamName == null) ? 0 : teamName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FootBallLeagueResponse other = (FootBallLeagueResponse) obj;
		if (LeagueId == null) {
			if (other.LeagueId != null)
				return false;
		} else if (!LeagueId.equals(other.LeagueId))
			return false;
		if (LeagueName == null) {
			if (other.LeagueName != null)
				return false;
		} else if (!LeagueName.equals(other.LeagueName))
			return false;
		if (countryId == null) {
			if (other.countryId != null)
				return false;
		} else if (!countryId.equals(other.countryId))
			return false;
		if (countryName == null) {
			if (other.countryName != null)
				return false;
		} else if (!countryName.equals(other.countryName))
			return false;
		if (overallLeaguePosition == null) {
			if (other.overallLeaguePosition != null)
				return false;
		} else if (!overallLeaguePosition.equals(other.overallLeaguePosition))
			return false;
		if (teamId == null) {
			if (other.teamId != null)
				return false;
		} else if (!teamId.equals(other.teamId))
			return false;
		if (teamName == null) {
			if (other.teamName != null)
				return false;
		} else if (!teamName.equals(other.teamName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FootBallLeagueResponse [countryId=" + countryId + ", countryName=" + countryName + ", LeagueId="
				+ LeagueId + ", LeagueName=" + LeagueName + ", teamId=" + teamId + ", teamName=" + teamName
				+ ", overallLeaguePosition=" + overallLeaguePosition + "]";
	}

}
