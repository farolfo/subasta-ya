package com.example.subastaya;

public class NoItemsFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Boolean canGoPrev; //says if the user is able to go prev for this has happened in a non first page of the search
	
	NoItemsFoundException(Integer page) {
		super();
		this.canGoPrev = page == 0 ? false : true;
	}

	public Boolean canGoPrev() {
		return canGoPrev;
	}
}
