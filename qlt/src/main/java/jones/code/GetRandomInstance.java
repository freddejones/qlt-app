package jones.code;

import java.util.Random;

public class GetRandomInstance {

	private static Random rand = null;
	
	public static Random getRandomInstance() 
	{
		if (rand == null)
		{
			rand = new Random();
		}
		
		return rand;
	}
}
