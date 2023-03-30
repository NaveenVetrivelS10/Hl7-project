package com.example.HL7Project.Entity;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



@Entity
@Table(name = "Acknowledgements")
public class Acknowledgements {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name="id_message_header")
	private String idMessageHeader;
	
	@Column(name="Accept_Acknowledgment_Type")
	private String acceptAcknowledgmentType;
	
	@Column(name="Application_Acknowledgment_Type")
	private String applicationAcknowledgmentType;
	
	@Column(name="Country_Code")
	private String countryCode;

	

	public String getIdMessageHeader() {
		return idMessageHeader;
	}

	public void setIdMessageHeader(String idMessageHeader) {
		this.idMessageHeader = idMessageHeader;
	}

	public String getAcceptAcknowledgmentType() {
		return acceptAcknowledgmentType;
	}

	public void setAcceptAcknowledgmentType(String acceptAcknowledgmentType) {
		this.acceptAcknowledgmentType = acceptAcknowledgmentType;
	}

	public String getApplicationAcknowledgmentType() {
		return applicationAcknowledgmentType;
	}

	public void setApplicationAcknowledgmentType(String applicationAcknowledgmentType) {
		this.applicationAcknowledgmentType = applicationAcknowledgmentType;
	}

	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	
	
	
	
}
