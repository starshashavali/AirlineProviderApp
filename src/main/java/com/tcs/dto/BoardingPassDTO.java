package com.tcs.dto;

import lombok.Data;

@Data

public class BoardingPassDTO {
	
	private Long ticketNumber;

	private String name;

	private Integer age;

	private String contact;

	private String source;

	private String destination;

	private String status;

	private Double price;


}
