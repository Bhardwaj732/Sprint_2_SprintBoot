package com.cg.bookstore.entities;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
public class ContactUs {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int contactId;
	private String heading;
	@NotEmpty
	private String comment;
	private LocalDate date;
	@NotEmpty
	private String email;
	
	public ContactUs() {
		super();
	}

	

	public ContactUs(int contactId, String heading, @NotEmpty String comment, LocalDate date,
			@NotEmpty String email) {
		super();
		this.contactId = contactId;
		this.heading = heading;
		this.comment = comment;
		this.date = LocalDate.now();
		this.email = email;
	}



	public int getContactId() {
		return contactId;
	}

	public void setContactId(int contactId) {
		this.contactId = contactId;
	}

	public String getHeading() {
		return heading;
	}

	public void setHeading(String heading) {
		this.heading = heading;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
