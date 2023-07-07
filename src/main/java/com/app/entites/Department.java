package com.app.entites;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Department extends BaseEntity {
	
//	dept
//	deptname
//	deptloc
	
	@Column(name = "dept_name")
	private String deptName;
	@Column(name = "dept_loc")
	private String deptLoc;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy ="dept",orphanRemoval = true)
	private List<Employee> empList = new ArrayList<Employee>();

	


}
