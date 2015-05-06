/**
 * 
 */
package com.inertia.solutions.apollo.item.mvc.domain.entity;

import java.util.Set;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Ian Hamilton. Basic Bean (Pojo) 
 *
 *{  
   "type":"object",
   "id":"urn:jsonschema:com:inertia:solutions:apollo:item:mvc:domain:entity:ApolloItem",
   "properties":{  
      "apolloItemDesc":{  
         "type":"string"
      },
      "id":{  
         "type":"string"
      },
      "apolloItemAmount":{  
         "type":"number"
      },
      "itemHistorySet":{  
         "type":"array",
         "items":{  
            "type":"object",
            "id":"urn:jsonschema:com:inertia:solutions:apollo:item:mvc:domain:entity:ApolloItemHistory",
            "properties":{  
               "id":{  
                  "type":"string"
               },
               "itemUpdateDate":{  
                  "type":"integer",
                  "format":"UTC_MILLISEC"
               },
               "itemUpdateBy":{  
                  "type":"string"
               },
               "itemUpdateNote":{  
                  "type":"string"
               },
               "apolloItemId":{  
                  "type":"string"
               }
            }
         }
      },
      "apolloItemName":{  
         "type":"string"
      }
   }
}
 */
@Document(collection = "apolloItem")
public class ApolloItem  {
	
	@Id
	private String id;

	public String getId() {
		return id;
	}
	
	@NotNull
	private String apolloItemName;

	@NotNull
	private String ApolloItemDesc;


	@NotNull
	private Double apolloItemAmount;
	
	@DBRef
	@Transient
	Set<ApolloItemHistory> itemHistorySet;
	

	public String getApolloItemName() {
		return apolloItemName;
	}



	public void setApolloItemName(String apolloItemName) {
		this.apolloItemName = apolloItemName;
	}



	public String getApolloItemDesc() {
		return ApolloItemDesc;
	}



	public void setApolloItemDesc(String apolloItemDesc) {
		ApolloItemDesc = apolloItemDesc;
	}



	public Double getApolloItemAmount() {
		return apolloItemAmount;
	}



	public void setApolloItemAmount(Double apolloItemAmount) {
		this.apolloItemAmount = apolloItemAmount;
	}


	public Set<ApolloItemHistory> getItemHistorySet() {
		return itemHistorySet;
	}



	public void setItemHistorySet(Set<ApolloItemHistory> itemHistorySet) {
		this.itemHistorySet = itemHistorySet;
	}


	@Override
	public String toString() {
		return "ApolloItem [id=" + id + ", apolloItemName=" + apolloItemName
				+ ", ApolloItemDesc=" + ApolloItemDesc + ", apolloItemAmount="
				+ apolloItemAmount + ", itemHistorySet=" + itemHistorySet + "]";
	}

}
