package com.greatlearning.db.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
	
	private String username;
    private String id;
    private String revision;
    

   	/**
	 * @return the username
	 */
    @JsonProperty("username")
	public String getUsername() {
		return username;
	}


	/**
	 * @param username the username to set
	 */
    @JsonProperty("username")
	public void setUsername(String username) {
		this.username = username;
	}


	/**
	 * @return the id
	 */
    @JsonProperty("id")
	public String getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
    @JsonProperty("id")
	public void setId(String id) {
		this.id = id;
	}

    @JsonProperty("_rev")
    public String getRevision() {
        return revision;
    }

    @JsonProperty("_rev")
    public void setRevision(String revision) {
        this.revision = revision;
    }
   

}
