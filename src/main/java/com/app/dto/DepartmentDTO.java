package com.app.dto;

import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Valid
public class DepartmentDTO {
	@JsonProperty(access = Access.READ_ONLY)
    private long id;
	private String deptName;
	private String deptLoc;
}
