package com.example.HL7Project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.HL7Project.Entity.MessageHeader;
import com.example.HL7Project.Entity.Sender;


	@Repository
	public interface SenderRepo extends JpaRepository<Sender, String>
	{

	}
		

