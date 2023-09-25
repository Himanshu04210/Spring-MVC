package com.masai.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import jakarta.annotation.Nonnull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity

public class VaccinatedUsers {
	
	@Id
	private int id;
	
	private String name;
	private int age;
	
	@Column(unique = true)
	@Nonnull
	private String email;
	private String designation;
	private String address;
	private String priority;
	private String vaccine;
	
}