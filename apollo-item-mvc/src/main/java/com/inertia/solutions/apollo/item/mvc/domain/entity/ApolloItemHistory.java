/**
 * 
 */
package com.inertia.solutions.apollo.item.mvc.domain.entity;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Ian Hamilton Standard Bean (Pojo)
 *
 */
@Document(collection="apolloItemHistory")
public class ApolloItemHistory {
	
	@Id
	String id;
	
	public String getId() {
		return id;
	}
	
	@NotNull
	@Indexed
	String apolloItemId;
	
	@NotNull
	Date itemUpdateDate;
	
	@NotNull
	String itemUpdateBy;
	
	String itemUpdateNote;

	public Date getItemUpdateDate() {
		return itemUpdateDate;
	}

	public void setItemUpdateDate(Date itemUpdateDate) {
		this.itemUpdateDate = itemUpdateDate;
	}

	public String getItemUpdateBy() {
		return itemUpdateBy;
	}

	public void setItemUpdateBy(String itemUpdateBy) {
		this.itemUpdateBy = itemUpdateBy;
	}

	public String getItemUpdateNote() {
		return itemUpdateNote;
	}

	public void setItemUpdateNote(String itemUpdateNote) {
		this.itemUpdateNote = itemUpdateNote;
	}

	public String getApolloItemId() {
		return apolloItemId;
	}

	public void setApolloItemId(String apolloItemId) {
		this.apolloItemId = apolloItemId;
	}

	@Override
	public String toString() {
		return "ApolloItemHistory [id=" + id + ", apolloItemId=" + apolloItemId
				+ ", itemUpdateDate=" + itemUpdateDate + ", itemUpdateBy="
				+ itemUpdateBy + ", itemUpdateNote=" + itemUpdateNote + "]";
	}	
	
}
