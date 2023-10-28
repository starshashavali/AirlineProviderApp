package com.tcs.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.dto.BoardingPassDTO;
import com.tcs.dto.CustomerDtlsDTO;
import com.tcs.service.IAirlineService;

@RestController
public class AirlineRestController {

	@Autowired
	private IAirlineService iairlineService;

	@PostMapping("/save")
	public ResponseEntity<?> bookedBoardIngPass(@Valid @RequestBody CustomerDtlsDTO customerDtls) {
		BoardingPassDTO boardingPassDTO = iairlineService.bookTicket(customerDtls);
		return ResponseEntity.status(HttpStatus.CREATED).body(boardingPassDTO);
	}

	@GetMapping("/getTicket/{ticketNumber}")
	public ResponseEntity<?> getTicket(@PathVariable Long ticketNumber) {
		BoardingPassDTO dto = iairlineService.getTicket(ticketNumber);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
	}

	@GetMapping("/getAllBoardingpass")
	public ResponseEntity<?> getAllBoardingPass() {
		List<BoardingPassDTO> list = iairlineService.getAllTicket();
		return ResponseEntity.status(HttpStatus.OK).body(list);
	}

	@DeleteMapping("/cancelTicket/{boardingPassNo}")
	public ResponseEntity<?> cancelTicket(@PathVariable Long boardingPassNo) {
		String cancelTicket = iairlineService.cancelTicket(boardingPassNo);
		return ResponseEntity.status(HttpStatus.OK).body(cancelTicket);

	}

}
