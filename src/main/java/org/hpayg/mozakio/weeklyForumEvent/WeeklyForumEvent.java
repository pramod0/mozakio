package org.hpayg.mozakio.weeklyForumEvent;

import java.time.LocalDate;

import org.hpayg.mozakio.center.Center;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="weekly_forum_Event")
public class WeeklyForumEvent {
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")	
	public Integer id;
	public LocalDate date;
	
	 @ManyToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name = "center_id")
	 public Center center;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Center getCenter() {
		return center;
	}

	public void setCenter(Center center) {
		this.center = center;
	}	
	
	
}
