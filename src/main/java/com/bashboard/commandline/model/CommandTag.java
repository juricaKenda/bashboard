package com.bashboard.commandline.model;


public enum CommandTag {

	COMMAND("-c"),ARGPREFIX("-ap"),ARGUMENT("-a");
	
	private String value;
	
	private CommandTag(String value) {
		this.value  = value;
	}
	
	
	public static CommandTag of(String input) {
		for(CommandTag tag : CommandTag.values()) {
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
