package com.example.HL7Project.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Receiver")
public class Receiver {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name="id_message_header")
	private String idMessageHeader;
	
	
	@Column(name="Sending_Application_ID")
	private String receivingApplicationId;
	
	

	public String getIdMessageHeader() {
		return idMessageHeader;
	}

	public void setIdMessageHeader(String idMessageHeader) {
		this.idMessageHeader = idMessageHeader;
	}

	
	public String getReceivingApplicationId() {
		return receivingApplicationId;
	}

	public void setReceivingApplicationId(String receivingApplicationId) {
		this.receivingApplicationId = receivingApplicationId;
	}

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getReceivingFacilityId() {
		return receivingFacilityId;
	}

	public void setReceivingFacilityId(String receivingFacilityId) {
		this.receivingFacilityId = receivingFacilityId;
	}

	public String getUniversalId() {
		return universalId;
	}

	public void setUniversalId(String universalId) {
		this.universalId = universalId;
	}

	public String getUniversalIdType() {
		return universalIdType;
	}

	public void setUniversalIdType(String universalIdType) {
		this.universalIdType = universalIdType;
	}

	@Column(name="Sending_Facility_ID ")
	private String receivingFacilityId;
	
	
	@Column(name="Universal_ID")
	private String universalId;
	
	@Column(name="Universal_ID_type")
	private String universalIdType;

}

