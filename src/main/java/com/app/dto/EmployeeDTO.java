package com.app.dto;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Valid
@Getter
@Setter
@ToString
@NoArgsConstructor
public class EmployeeDTO {
	@JsonProperty(access = Access.READ_ONLY)
	private long id;
	private String firstName;
	private String lastName;
	@Email
	private String email;
	private long deptId;
	private double sal;

	public EmployeeDTO(long id, String firstName, String lastName, @Email String email, double sal) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.sal = sal;
	}

}
