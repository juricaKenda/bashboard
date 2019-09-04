package com.bashboard.commandline.model;


public enum Tag {

	COMMAND("-c"),ARGPREFIX("-ap"),ARGUMENT("-a");
	
	private String value;
	
	private Tag(String value) {
		this.value  = value;
	}
	
	
	public static Tag of(String input) {
		for(Tag tag : Tag.values()) {
			if(tag.value.equals(input)) {
				return tag;
			}
		}
		throw new UnsupportedTagException("Tag " + input +" is not supported!");
	}
	
	
	static class UnsupportedTagException extends RuntimeException{
		private String message;
		public UnsupportedTagException(String message) {
			super(message);
			this.message = message;
		}
		
	}
}
