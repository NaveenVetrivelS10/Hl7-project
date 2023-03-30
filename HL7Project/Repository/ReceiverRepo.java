package com.example.HL7Project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.HL7Project.Entity.Receiver;
import com.example.HL7Project.Entity.Sender;

	@Repository
	public interface ReceiverRepo extends JpaRepository<Receiver, String>
	{

	} 
	
