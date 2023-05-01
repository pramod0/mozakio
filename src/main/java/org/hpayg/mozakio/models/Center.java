package org.hpayg.mozakio.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="center")
public class Center {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	public String id;
	public String name;
	public String location;
	
}
