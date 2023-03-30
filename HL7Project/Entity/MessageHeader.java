package com.example.HL7Project.Entity;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



@Entity
@Table(name = "message_header")
public class MessageHeader {

	@Id
	private String mid;
	
	@Column(name="Field_Separator")
	private String fieldSeparator;
	
	@Column(name="Encoding_Charactersr")
	private String encodingCharacters;
	
	@Column(name="Message_Type")
	private String messageType;
	
	@Column(name="Trigger_event")
	private String triggerEvent;
	
	@Column(name="Message_Control_ID")
	private String messageControlId;
	
	@Column(name="Processing_ID")
	private String processingId;
	
	@Column(name="Version_Id")
	private String versionId;
	
	@Column(name="Date_Time_of_Message")
	private String dateTimeOfMessage;


	public String getId() {
		return mid;
	}


	public void setId(String mid) {
		this.mid = mid;
	}


	public String getFieldSeparator() {
		return fieldSeparator;
	}


	public void setFieldSeparator(String fieldSeparator) {
		this.fieldSeparator = fieldSeparator;
	}


	public String getEncodingCharacters() {
		return encodingCharacters;
	}


	public void setEncodingCharacters(String encodingCharacters) {
		this.encodingCharacters = encodingCharacters;
	}


	public String getMessageType() {
		return messageType;
	}


	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}


	public String getTriggerEvent() {
		return triggerEvent;
	}


	public void setTriggerEvent(String triggerEvent) {
		this.triggerEvent = triggerEvent;
	}


	

	public String getMessageControlId() {
		return messageControlId;
	}


	public void setMessageControlId(String string) {
		this.messageControlId = string;
	}


	public String getProcessingId() {
		return processingId;
	}


	public void setProcessingId(String processingId) {
		this.processingId = processingId;
	}


	public String getVersionId() {
		return versionId;
	}

	public void setVersionId(String versionId) {
		this.versionId = versionId;
	}


	public String getDateTimeOfMessage() {
		return dateTimeOfMessage;
	}


	public void setDateTimeOfMessage(String dateTimeOfMessage) {
		this.dateTimeOfMessage = dateTimeOfMessage;
	}


	

}