/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.geeklythings.fm.type;

/**
 *
 * @author khooks
 */
public enum EventFormatType {
	
	SR2013 ("Steam Roller 2013"),
	MANGLEDMETAL ("Mangled Metal"),
	HARDCORE ("Hardcore"),
	IRONGAUNTLET ("Iron Gauntlet"),
        RELEASE ("Release Event");

	 
	private final String name;
	
	private EventFormatType(String s) {
		name = s;
	}
	
        public String getName()
        {
            return name;    
        }
        
        @Override 
        public String toString()
        {
            return name;
        }
        
	public static String[] enumsToStringArray() {
		
		String result[] = new String[EventFormatType.values().length];
	
		int count = 0;
		for ( EventFormatType each : EventFormatType.values()) {
			result[count] = each.getName();
			count++;
		}
	
		return result;
	}
}