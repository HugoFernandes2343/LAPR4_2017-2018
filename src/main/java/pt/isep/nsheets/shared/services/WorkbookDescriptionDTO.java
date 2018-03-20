package pt.isep.nsheets.shared.services;

import java.io.Serializable;

@SuppressWarnings("serial")
public class WorkbookDescriptionDTO implements Serializable {
	
	private String name;
	
	public WorkbookDescriptionDTO(String name) {
		this.name=name;
	}

	// It is mandatory to have a default constructor with no arguments to be serializable!
	public WorkbookDescriptionDTO() {
		this.name="";
	}
	
	public String getName() {
		return this.name;
	}

}
