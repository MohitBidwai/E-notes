package com.mohit.e_notes_DTO;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDTO {

	private Integer id;
	private String name;
	private String description;
	private Boolean isActive;
	private Date createdOn;
	private Integer updatedBy;
	private Date updatedOn;
}
