package org.hpayg.mozakio.models;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="weekly_forum")
public class WeeklyForumEvent {
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public String id;
	
	@Id public String branchId;
	public LocalDate date;
	
}
