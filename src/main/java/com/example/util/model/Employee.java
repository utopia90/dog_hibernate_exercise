package com.example.util.model;


import com.mysql.cj.x.protobuf.MysqlxCrud;

import javax.persistence.*;

@Entity
@Table(name="employees")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name", length = 300)
	private String name;

	private Integer age;

	private boolean married;

	private Double salary;

	@OneToOne
	@JoinColumn(name = "id_direction")
	private Direction direction;

	@OneToOne
	@JoinColumn(name = "id_qualifications")
	private Qualifications qualifications;


	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_company")
	private Company company;

	public Employee() {
	}
	public Employee(String name, Integer age, boolean married, Double salary) {
		this.name = name;
		this.age = age;
		this.married = married;
		this.salary = salary;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public boolean isMarried() {
		return married;
	}

	public Direction getDirection() {
		return direction;
	}

	public Qualifications getQualifications() {
		return qualifications;
	}

	public void setQualifications(Qualifications qualifications) {
		this.qualifications = qualifications;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public void setMarried(boolean married) {
		this.married = married;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}


	@Override
	public String toString() {
		return "Employee{" +
				"id=" + id +
				", name='" + name + '\'' +
				", age=" + age +
				", married=" + married +
				", salary=" + salary +
				'}';
	}
}
