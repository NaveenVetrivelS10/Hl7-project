package com.example.HL7Project.Entity;



import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Sender")
public class Sender {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name="id_message_header")
	private String idMessageHeader;
	


	public String getIdMessageHeader() {
		return idMessageHeader;
	}

	public void setIdMessageHeader(String idMessageHeader) {
		this.idMessageHeader = idMessageHeader;
	}

	
	@Column(name="Receiving_Application_ID")
	private  String sendingApplicationId;
	
	@Column(name="Sending Facility ID")
	private String sendingFacilityId;
	
	@Column(name="Universal_ID")
	private String universalId;
	
	

	public void setSendingApplicationId(String sendingApplicationId) {
		this.sendingApplicationId = sendingApplicationId;
	}

	public void setUniversalId(String universalId) {
		this.universalId = universalId;
	}

	@Column(name="Universal_ID_type")
	private String universalIdType;



	

	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSendingFacilityId() {
		return sendingFacilityId;
	}

	public void setSendingFacilityId(String sendingFacilityId) {
		this.sendingFacilityId = sendingFacilityId;
	}

	public String getUniversalIdType() {
		return universalIdType;
	}

	public void setUniversalIdType(String universalIdType) {
		this.universalIdType = universalIdType;
	}


	
	public String getSendingApplicationId() {
		return sendingApplicationId;
	}

	public String getUniversalId() {
		return universalId;
	}

}
