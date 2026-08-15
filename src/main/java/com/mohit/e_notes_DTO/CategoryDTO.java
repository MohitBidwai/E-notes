package com.mohit.e_notes_DTO;

import java.util.Date;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDTO {

	private Integer id;
	@NotBlank
	@Min(value = 10)
	@Max(value=100)
	private String name;
	@Min(value = 10)
	@Max(value=100)
	private String description;
	private Boolean isActive;
	private Date createdOn;
	private Integer updatedBy;
	private Date updatedOn;
}
