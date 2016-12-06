/**
* Copyright Schantz A/S, all rights reserved
*/

package com.blogspot.jpdevelopment.util;

import java.util.*;

public class Guid {

	static final private int shift = 6;
	static final private long mask = (1 << 6) - 1;
	static final private int guidLength = 19;
	static private final Random random = new Random();
	static int sequence = 0;
	static private byte[] digits = new byte[64];

	static {
		int j = 0;
		digits[j++] = (byte) '$';
		for (int i = '0'; i <= '9'; i++) {
			digits[j++] = (byte) i;
		}
		digits[j++] = (byte) '@';
		for (int i = 'A'; i <= 'Z'; i++) {
			digits[j++] = (byte) i;
		}
		for (int i = 'a'; i <= 'z'; i++) {
			digits[j++] = (byte) i;
		}
	}

	private byte[] value;
	
	private transient String toString = null;

	private Guid(byte[] value) {
		this.value = value;
	}

	static public Guid create() {
		byte[] buf = new byte[guidLength];
		int charPos = guidLength - 1;

		long rnd = random.nextLong();
		while (charPos >= 11) {
			buf[charPos--] = digits[(int) (rnd & mask)];
			rnd >>>= shift;
		}

		int seq = sequence++;
		while (charPos >= 8) {
			buf[charPos--] = digits[(int) (seq & mask)];
			seq >>>= shift;
		}

		long time = System.currentTimeMillis();
		while (charPos >= 0) {
			buf[charPos--] = digits[(int) (time & mask)];
			time >>>= shift;
		}

		return new Guid(buf);
	}

	static public Guid create(String guidAsString){
	  byte[] val = new byte[guidAsString.length()];
	  for(int i=0; i<val.length; i++){
	    val[i] = (byte)guidAsString.charAt(i);
	  }
	  return new Guid(val);
	}


	@Override
	public String toString() {
		if (toString == null)
			toString = new String(value);
		return toString;
	}

}
