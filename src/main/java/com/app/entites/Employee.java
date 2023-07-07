package com.app.entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
@Entity
public class Employee extends BaseEntity {
	@Column(name = "first_name" ,length = 30)
	private String firstName;
	@Column(name = "last_name" ,length = 30)
	private String lastName;
	@Column(length = 30)
	private String email;
	private double sal;
	
	@ManyToOne
	@JoinColumn(name ="dept_id")
	private Department dept;

	public Employee(String firstName, String lastName, String email, double sal) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.sal = sal;
	}
	
	

}


//emp
//firname
//lastname
//email
//sal
//dept
