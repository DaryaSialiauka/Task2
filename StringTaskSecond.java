package by.it_academy.simpleapp.main;

import java.util.Scanner;

public class StringTaskSecond {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int ia = inarabian();
		
		String s = translate(ia);
		
		System.out.println(s);
	}

	public static String translate(int ia) {
		String s = "";
		int p = 0;
		int x;
		
		while (ia != 0) {
			x = div(ia);
			ia = ia / 10;
			if (x == 0) {
				p++;
			} else {
				s = cipher(x, p) + s;
				p++;
			}
		}
		return s;
	}

	public static int inarabian() {
		Scanner sc;
		sc = new Scanner(System.in);

		while (true) {
			System.out.println("¬ведите число от 1 до 1999>");
			if (sc.hasNextInt()) {
				return sc.nextInt();
			}
			sc.next();
		}

	}

	public static String cipher(int x, int p) {

		int[] a = arabian();
		String[] r = roma();

		String s = "";

		int i = 0;
		while (x > a[i] / Math.pow(10, p)) {
			i++;
		}
		if (x == a[i] / Math.pow(10, p)) {
			s = r[i];
		} else if (a[i] / Math.pow(10, p) - x == 1) {
			if ((i - 1) % 2 == 0) {
				s = r[i - 1] + r[i];
			} else {
				s = r[i - 2] + r[i];
			}
		} else {
			i--;
			if (i % 2 == 0) {
				for (int j = 1; j <= x; j++) {
					s += r[i];
				}
			} else {
				s = r[i];
				for (int j = 1; j <= x - a[i] / Math.pow(10, p); j++) {
					s += r[i - 1];
				}
			}
		}

		return (s);
	}

	public static int div(int i) {
		return i % 10;
	}

	public static int[] arabian() {
		int[] a = { 1, 5, 10, 50, 100, 1000 };
		return a;
	}

	public static String[] roma() {
		String[] r = { "I", "V", "X", "L", "C", "M" };
		return r;
	}

}
