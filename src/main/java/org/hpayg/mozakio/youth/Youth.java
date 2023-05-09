package org.hpayg.mozakio.youth;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="youth")
public class Youth {
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	public Integer id;
	public String rollno;
	public String team;
	public String youthFullName;
	public LocalDate dob;
	public String mobile1;
	public String mobile2;
	public String emailid;
	public String status;
	public String tlCode;
	public String pincode;
	
	@Override
	public String toString() {
		return rollno + " " + youthFullName ;
	}
	
}

