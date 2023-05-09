package org.hpayg.mozakio.attendance;

import org.hpayg.mozakio.weeklyForumEvent.WeeklyForumEvent;
import org.hpayg.mozakio.youth.Youth;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Attendance {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	public Integer id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "youth_id")
	public Youth youth;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "weekly_forum_event_id")
	public WeeklyForumEvent wfEvent;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Youth getYouth() {
		return youth;
	}

	public void setYouth(Youth youth) {
		this.youth = youth;
	}

	public WeeklyForumEvent getWfEvent() {
		return wfEvent;
	}

	public void setWfEvent(WeeklyForumEvent wfEvent) {
		this.wfEvent = wfEvent;
	}
}
