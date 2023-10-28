package com.tcs.service;

import java.util.List;

import com.tcs.dto.BoardingPassDTO;
import com.tcs.dto.CustomerDtlsDTO;

public interface IAirlineService {
	
	public BoardingPassDTO bookTicket(CustomerDtlsDTO customerDtls);
	
	public BoardingPassDTO getTicket(Long ticketNumber);

	public List<BoardingPassDTO> getAllTicket();

	public String cancelTicket(Long ticketNumber);

}
