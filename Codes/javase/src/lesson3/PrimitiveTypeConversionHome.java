package lesson3;

public class PrimitiveTypeConversionHome {
	public static void main(String[] args) {
		int a = 55;
		byte b = (byte) a;
		System.out.println(b);

		short c = 636;
		byte d = (byte) c;
		System.out.println(d);
		
		long e = 458;
		short f = (short) e;
		System.out.println(f);
		
		long g = 92523635483L;
		int h = (int) g;
		System.out.println(h);
		
		double i = 65787.3;
		int j = (int) i;
		System.out.println(j);
		
		char k = 'q';
		int l = k;
		System.out.println(l);
		
		int m = 266;
		char n = (char) m;
		System.out.println(n);
	}

}
