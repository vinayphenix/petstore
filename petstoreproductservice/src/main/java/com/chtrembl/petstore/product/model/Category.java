package com.chtrembl.petstore.product.model;

import static javax.persistence.GenerationType.SEQUENCE;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-12-20T15:31:39.272-05:00")
@Entity
@Table(name = "category")
public class Category {
	@JsonProperty("id")
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = SEQUENCE, generator = "ID_SEQ")
	private Long id = null;

	@JsonProperty("name")
	@Column(name = "name", unique = true, nullable = false)
	private String name;

	public Category id(Long id) {
		this.id = id;
		return this;
	}

	@ApiModelProperty(value = "")

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Category name(String name) {
		this.name = name;
		return this;
	}

	@ApiModelProperty(value = "")

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Category category = (Category) o;
		return Objects.equals(this.id, category.id) && Objects.equals(this.name, category.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Category {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}
