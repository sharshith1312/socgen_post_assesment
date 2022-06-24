package com.iiht.training.ratings.entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "development")
public class Development {

	@Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)
	private Long developmentId;
	private Long politicalLeaderId;
	private String title;
	private String activity;
	private String budget;
	private String state;
	private Integer activityMonth;
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

}
