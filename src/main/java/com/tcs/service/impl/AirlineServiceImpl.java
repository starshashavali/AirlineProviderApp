package com.tcs.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.tcs.dto.BoardingPassDTO;
import com.tcs.dto.CustomerDtlsDTO;
import com.tcs.exception.InvalidBoardingPassException;
import com.tcs.service.IAirlineService;

@Service
public class AirlineServiceImpl implements IAirlineService {

	private static final Logger logger = LoggerFactory.getLogger(AirlineServiceImpl.class);

	private Map<Long, BoardingPassDTO> response = new HashMap<>();

	private static Long ticketNumber = 1l;

	@Override
	public BoardingPassDTO bookTicket(CustomerDtlsDTO customerDtls) {
		logger.info("Booked Ticket is executed..." + customerDtls);
		BoardingPassDTO dto = new BoardingPassDTO();
		BeanUtils.copyProperties(customerDtls, dto);
		dto.setPrice(399.9);
		dto.setStatus("Confirmed");
		dto.setTicketNumber(ticketNumber);
		response.put(ticketNumber, dto);
		ticketNumber++;
		return dto;
	}
	@Override
	public List<BoardingPassDTO> getAllTicket() {
		return new ArrayList<>(response.values());
	}

	@Override
    public BoardingPassDTO getTicket(Long ticketNumber) {
        if (response.containsKey(ticketNumber)) {
            return response.get(ticketNumber);
        }
        throw new InvalidBoardingPassException("Invalid Boarding Pass No: " + ticketNumber);
    }



	@Override
	public String cancelTicket(Long boardingPassNo) {
        if (response.containsKey(boardingPassNo)) {
            response.remove(boardingPassNo);
            return "Ticket with number " + boardingPassNo + " has been canceled.";
        }
        throw new InvalidBoardingPassException("Invalid Boarding Pass No: " + boardingPassNo);
    }
}


