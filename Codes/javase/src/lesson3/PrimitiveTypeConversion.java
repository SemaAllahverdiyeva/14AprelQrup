package lesson3;

public class PrimitiveTypeConversion {
	public static void main(String[] args) {
		short a = 69;
		byte b = (byte) a;
		System.out.println(b);

		short c = 589;
		byte d = (byte) c;
		System.out.println(d);

		long e = 458;
		int f = (int) e;
		System.out.println(f);

		long g = 52523635483L;
		int h = (int) g;
		System.out.println(h);

		double i = 5632.6;
		float j = (float) i;
		System.out.println(j);

		char k = 'D';
		int l = k;
		System.out.println(l);

		int m = 123;
		char n = (char) m;
		System.out.println(n);
	}
}
