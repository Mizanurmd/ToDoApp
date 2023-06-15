package com.Spring.toDoApp.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vuser {
	private String userName;
	private String toAddress;
	private String subject;
	private String message;
	private String fromAddress;
}
