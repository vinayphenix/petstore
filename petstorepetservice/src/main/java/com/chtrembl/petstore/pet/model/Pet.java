package com.chtrembl.petstore.pet.model;

import static javax.persistence.GenerationType.SEQUENCE;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.annotations.ApiModelProperty;

@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-12-20T15:31:39.272-05:00")
@Entity
@Table(name = "pet")
public class Pet {
	@JsonProperty("id")
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = SEQUENCE, generator = "ID_SEQ")
	private Long id;

	@JsonProperty("category")
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;

	@JsonProperty("name")
	@Column(name = "name", unique = true, nullable = false)
	private String name;

	@JsonProperty("photoURL")
	@Valid
	@Column(name = "photoURL", nullable = false)
	private String photoURL;

	@JsonProperty("tags")
	@Valid
	@OneToMany
	@JoinTable(
			name = "pet_tag",
			joinColumns = @JoinColumn(
					name = "pet_id",
					referencedColumnName = "id"
			),
			inverseJoinColumns = @JoinColumn(
					name = "tag_id",
					referencedColumnName = "id"
			)
	)
	private List<Tag> tags;

	public enum StatusEnum {
		AVAILABLE("available"),

		PENDING("pending"),

		SOLD("sold");

		private String value;

		StatusEnum(String value) {
			this.value = value;
		}

		@JsonValue
		public String getValue() {
			return value;
		}

		@Override
		public String toString() {
			return String.valueOf(value);
		}

		@JsonCreator
		public static StatusEnum fromValue(String value) {
			for (StatusEnum b : StatusEnum.values()) {
				if (b.value.equalsIgnoreCase(value)) {
					return b;
				}
			}
			throw new IllegalArgumentException("Unexpected value '" + value + "'");
		}
	}

	@JsonProperty("status")
	@Convert(converter = StatusConverter.class)
	@Column(name = "status", nullable = false)
	private StatusEnum status;

	public Pet id(Long id) {
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

	public Pet category(Category category) {
		this.category = category;
		return this;
	}

	@ApiModelProperty(value = "")

	@Valid

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Pet name(String name) {
		this.name = name;
		return this;
	}

	@ApiModelProperty(example = "doggie", required = true, value = "")
	@NotNull

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@ApiModelProperty(required = true, value = "")
	@NotNull

	public String getPhotoURL() {
		return photoURL;
	}

	public void setPhotoURL(String photoURL) {
		this.photoURL = photoURL;
	}

	public Pet tags(List<Tag> tags) {
		this.tags = tags;
		return this;
	}

	public Pet addTagsItem(Tag tagsItem) {
		if (this.tags == null) {
			this.tags = new ArrayList<>();
		}
		this.tags.add(tagsItem);
		return this;
	}

	@ApiModelProperty(value = "")

	@Valid

	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	public Pet status(StatusEnum status) {
		this.status = status;
		return this;
	}

	@ApiModelProperty(value = "pet status in the store")

	public StatusEnum getStatus() {
		return status;
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Pet pet = (Pet) o;
		return Objects.equals(this.id, pet.id) && Objects.equals(this.category, pet.category)
				&& Objects.equals(this.name, pet.name) && Objects.equals(this.photoURL, pet.photoURL)
				&& Objects.equals(this.tags, pet.tags) && Objects.equals(this.status, pet.status);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, category, name, photoURL, tags, status);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Pet {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    category: ").append(toIndentedString(category)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    photoUrls: ").append(toIndentedString(photoURL)).append("\n");
		sb.append("    tags: ").append(toIndentedString(tags)).append("\n");
		sb.append("    status: ").append(toIndentedString(status)).append("\n");
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
