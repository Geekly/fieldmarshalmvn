/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.geeklythings.fm.type;

/**
 *
 * @author khooks
 */
public enum ClockType {
    
    TIMEDTURNS ("Timed Turns"),
    DEATHCLOCK ("Death Clock"),
    CASUAL ("Casual");
    
    	private final String name;
	
	private ClockType(String s) {
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
        
        // use ClockType.values() instead
        
	public static String[] enumsToStringArray() {
		
		String result[] = new String[ClockType.values().length];
	
		int count = 0;
		for ( ClockType each : ClockType.values()) {
			result[count] = each.getName();
			count++;
		}
	
		return result;
	}
}
