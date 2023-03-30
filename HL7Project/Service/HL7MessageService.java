package com.example.HL7Project.Service;

import java.util.Map;
import java.util.Optional;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.HL7Project.Entity.Acknowledgements;
import com.example.HL7Project.Entity.MessageHeader;
import com.example.HL7Project.Entity.Parser;
import com.example.HL7Project.Entity.Receiver;
import com.example.HL7Project.Entity.Sender;
import com.example.HL7Project.HL7Dto.HL7MessageRequest;
import com.example.HL7Project.Repository.AcknowledgementsRepo;
import com.example.HL7Project.Repository.MessageHeaderRepo;
import com.example.HL7Project.Repository.ReceiverRepo;
import com.example.HL7Project.Repository.SenderRepo;

@Service
public class HL7MessageService implements HL7MessageHandlerItf {

	@Autowired
	private MessageHeaderRepo messageHeaderRepo;

	@Autowired
	private SenderRepo senderRepo;
	@Autowired
	private ReceiverRepo receiverRepo;
	@Autowired
	private AcknowledgementsRepo acknowledgementsRepo;

	public String checkIDExist(HL7MessageRequest request) throws Exception {
		Optional<MessageHeader> checkMessageId = messageHeaderRepo.findByMid(request.getId());
		System.out.println(checkMessageId);
		boolean isExist = !checkMessageId.isEmpty();
		if (!isExist) {
			Map<String, String> messageValues = Parser.messageParser(request.getData());

			MessageHeader msgHeader = new MessageHeader();
			msgHeader.setId(request.getId());
			msgHeader.setFieldSeparator(messageValues.get("Field Separator"));
			msgHeader.setEncodingCharacters(messageValues.get("Encoding Characters"));
			msgHeader.setMessageType(messageValues.get("Message Type"));
			msgHeader.setMessageControlId(messageValues.get("Message Control ID"));
			msgHeader.setProcessingId(messageValues.get("Processing ID"));
			msgHeader.setVersionId(messageValues.get("Version ID"));
			msgHeader.setDateTimeOfMessage(messageValues.get("DateTime Of Message"));
			messageHeaderRepo.save(msgHeader);

			Sender sender = new Sender();
			sender.setIdMessageHeader(messageValues.get("idMessageHeader"));
			sender.setSendingApplicationId(messageValues.get("Sending Application"));
			sender.setSendingFacilityId(messageValues.get("Sending Facility"));
			sender.setUniversalId(messageValues.get("Universal ID"));
			senderRepo.save(sender);

			Receiver receiver = new Receiver();
			receiver.setReceivingApplicationId(messageValues.get("Receiving Application"));
			receiver.setReceivingFacilityId(messageValues.get("Receiving Facility"));
			receiverRepo.save(receiver);

			Acknowledgements acknowledgements = new Acknowledgements();
			acknowledgements.setAcceptAcknowledgmentType(messageValues.get("Accept Acknowledgment Type"));
			acknowledgements.setApplicationAcknowledgmentType(messageValues.get("Application Acknowledgment Type"));
			acknowledgements.setCountryCode(messageValues.get("Country Code"));
			acknowledgementsRepo.save(acknowledgements);

			// Build Response Object
			JSONObject response = new JSONObject();

			JSONObject msh = new JSONObject();
			response.put("MSH", msh);

			msh.put("MSH.1 - Field Separator", messageValues.get("Field Separator"));
			msh.put("MSH.2 - Encoding Characters", messageValues.get("Encoding Characters"));

			
			JSONObject sendingApplication = new JSONObject();
			sendingApplication.put("HD.1 - Namespace ID", messageValues.get("Sending Application"));
			msh.put("MSH.3 - Sending Application", sendingApplication);

			
			JSONObject sendingFacility = new JSONObject();
			String[] sendingFacilityValues = messageValues.get("Sending Facility").split("\\~");
			sendingFacility.put("HD.1 - Namespace ID", sendingFacilityValues[0]);
			sendingFacility.put("HD.2 - Universal ID", sendingFacilityValues[1]);
			sendingFacility.put("HD.3 - Universal ID type", sendingFacilityValues[2]);
			msh.put("MSH.4 - Sending Facility", sendingFacility);

			
			JSONObject receivingApplication = new JSONObject();
			receivingApplication.put("HD.1 - Namespace ID", messageValues.get("Receiving Application"));
			msh.put("MSH.5 - Receiving Application", receivingApplication);

			
			JSONObject receivingFacility = new JSONObject();
			String[] receivingFacilityValues = messageValues.get("Receiving Facility").split("\\~");
			receivingFacility.put("HD.1 - Namespace ID", receivingFacilityValues[0]);
			receivingFacility.put("HD.2 - Universal ID", receivingFacilityValues[1]);
			receivingFacility.put("HD.3 - Universal ID type", receivingFacilityValues[2]);
			msh.put("MSH.6 - Receiving Facility", receivingFacility);

			
			JSONObject dateTime = new JSONObject();
			dateTime.put("TS.1 - Time of an event", messageValues.get("DateTime Of Message"));
			msh.put("MSH.7 - DateTime Of Message", dateTime);

			
			JSONObject messageType = new JSONObject();
			String[] messageTypeValues = messageValues.get("Message Type").split("\\~");
			messageType.put("MSG.1 - Message type", messageTypeValues[0]);
			messageType.put("MSG.2 - Trigger event", messageTypeValues[1]);
			msh.put("MSH.9 - Message Type", messageType);

			
			msh.put("MSH.10 - Message Control ID", messageValues.get("Message Control ID"));

			
			JSONObject processingID = new JSONObject();
			processingID.put("PT.1 - Processing ID", messageValues.get("Processing ID"));
			msh.put("MSH.11 - Processing ID", processingID);

			
			JSONObject versionID = new JSONObject();
			versionID.put("VID.1 - Version ID", messageValues.get("Version ID"));
			msh.put("MSH.12 - Version ID", versionID);

			
			msh.put("MSH.15 - Accept Acknowledgment Type", messageValues.get("Accept Acknowledgment Type"));

			
			msh.put("MSH.16 - Application Acknowledgment Type", messageValues.get("Application Acknowledgment Type"));

			
			msh.put("MSH.17 - Country Code", messageValues.get("Country Code"));

			return response.toString();
		} else {
			return "Already exist ";
		}
	}

	@Override
	public boolean checkIfIdExist(String Id) {
		// TODO Auto-generated method stub
		return false;
	}

}
