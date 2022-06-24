package com.iiht.training.ratings.dto;

import java.util.Objects;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Min;
import javax.validation.constraints.Max;
public class DevelopmentDto {
	
	private Long developmentId;
	@NotNull
	private Long politicalLeaderId;
	
	@NotNull
	@Size(min = 3,max = 100, message = "Title should have at least 3 characters and atmost 100 characters")
	private String title;
	
	@NotNull
	@Size(min = 3,max = 100, message = "activity should have at least 3 characters and atmost 100 characters")
	private String activity;
	
	@NotNull
	@Size(min = 3,max = 100, message = "budget should have at least 3 characters and atmost 100 characters")
	private String budget;
	
	@NotNull
	@Size(min = 3,max = 100, message = "state should have at least 3 characters and atmost 100 characters")
	private String state;
	
	@NotNull
	@Min(value = 1, message="Activity Month should start with >= 1")
	@Max(value = 12, message="Activity Month should start with <= 12")
	private Integer activityMonth;
	
	@NotNull
	@Min(value = 2021, message="Activity Year should start with >= 2021")
	@Max(value = 2040, message="Activity Year should start with <= 2040")
	private Integer activityYear;

	public Long getDevelopmentId() {
		return developmentId;
	}

	public void setDevelopmentId(Long developmentId) {
		this.developmentId = developmentId;
	}

	public Long getPoliticalLeaderId() {
		return politicalLeaderId;
	}

	public void setPoliticalLeaderId(Long candidateId) {
		this.politicalLeaderId = candidateId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

	public String getBudget() {
		return budget;
	}

	public void setBudget(String budget) {
		this.budget = budget;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Integer getActivityMonth() {
		return activityMonth;
	}

	public void setActivityMonth(Integer activityMonth) {
		this.activityMonth = activityMonth;
	}

	public Integer getActivityYear() {
		return activityYear;
	}

	public void setActivityYear(Integer activityYear) {
		this.activityYear = activityYear;
	}

	@Override
	public int hashCode() {
		return Objects.hash(activity, activityMonth, activityYear, budget, politicalLeaderId, developmentId, state, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DevelopmentDto other = (DevelopmentDto) obj;
		return Objects.equals(activity, other.activity) && Objects.equals(activityMonth, other.activityMonth)
				&& Objects.equals(activityYear, other.activityYear) && Objects.equals(budget, other.budget)
				&& Objects.equals(politicalLeaderId, other.politicalLeaderId) && Objects.equals(developmentId, other.developmentId)
				&& Objects.equals(state, other.state) && Objects.equals(title, other.title);
	}

}
