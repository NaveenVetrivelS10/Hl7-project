package com.example.HL7Project.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.HL7Project.Entity.MessageHeader;
@Repository
public interface MessageHeaderRepo extends JpaRepository<MessageHeader, String>
{
	public Optional<MessageHeader> findByMid(String id );
	
}
	