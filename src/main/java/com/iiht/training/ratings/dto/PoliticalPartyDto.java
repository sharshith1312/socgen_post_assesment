package com.iiht.training.ratings.dto;

import java.util.Objects;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class PoliticalPartyDto {

	private Long politicalPartyId;

	@NotNull
	@Size(min = 3,max = 100, message = "Political party name should have at least 3 characters and atmost 100 characters")
	private String partyName;
	
	@NotNull
	@Size(min = 3,max = 100, message = "Political party founder name should have at least 3 characters and atmost 100 characters")
	private String founderName;

	public Long getPoliticalPartyId() {
		return politicalPartyId;
	}

	public void setPoliticalPartyId(Long partyId) {
		this.politicalPartyId = partyId;
	}

	public String getPartyName() {
		return partyName;
	}

	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}

	public String getFounderName() {
		return founderName;
	}

	public void setFounderName(String founderName) {
		this.founderName = founderName;
	}

	@Override
	public int hashCode() {
		return Objects.hash(founderName, politicalPartyId, partyName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PoliticalPartyDto other = (PoliticalPartyDto) obj;
		return Objects.equals(founderName, other.founderName) && Objects.equals(politicalPartyId, other.politicalPartyId)
				&& Objects.equals(partyName, other.partyName);
	}

}
