package test;

import org.apache.log4j.Logger;

public class SuperMegaHiper {

	Logger log = Logger.getLogger("SuperMegaHiper");
	
	public static final Integer PEREMENNAJA = 12;
	/**
	 * This Method checks if the Summ bigger,equal than 0
	 * 
	 * Throws Exceptions if one of the Arguments is NULL
	 * 
	 * @param i1 - Integer 1
	 * @param i2 - Integer 2
	 * @return - booleab true if bigger than Zero
	 */
	public boolean isMoreThenZero(Integer i1, Integer i2) throws Exception{
		log.trace("Enterging isMoreThenZero");
		
		//		System.out.println("Usinbg MEthod with argumentrs: [" + i1 + "] ["+i2+"]");
		log.info("Usinbg MEthod with argumentrs: [" + i1 + "] ["+i2+"]");
		log.trace("Leaving isMoreThenZero");
		return i1+i2 >= 0;
	}
}
