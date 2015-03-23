package Implement_C_memcpy;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * Implement C's memcpy() 
	 * http://www.glassdoor.com/Interview/Implement-C-s-memcpy-QTN_886547.htm
	 */
	
	// http://stackoverflow.com/questions/11876361/implementing-own-memcpy-size-in-bytes
	
	//C code below:
/*	void memcpy(void* dest, void* src, int size)
	{
	    uint8_t *pdest = (uint8_t*) dest;
	    uint8_t *psrc = (uint8_t*) src;

	    int loops = (size / sizeof(uint32_t));
	    for(int index = 0; index < loops; ++index)
	    {
	        *((uint32_t*)pdest) = *((uint32_t*)psrc);
	        pdest += sizeof(uint32_t);
	        psrc += sizeof(uint32_t);
	    }

	    loops = (size % sizeof(uint32_t));
	    for (int index = 0; index < loops; ++index)
	    {
	        *pdest = *psrc;
	        ++pdest;
	        ++psrc;
	    }
	}*/

}
