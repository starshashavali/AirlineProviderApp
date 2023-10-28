package com.tcs.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDtlsDTO {

	private String name;

	private Integer age;

	private String contact;

	private String source;

	private String destination;

}
