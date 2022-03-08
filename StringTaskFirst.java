package by.it_academy.simpleapp.main;

import java.util.Scanner;

public class StringTaskFirst {

	public static void main(String[] args) {

		String s = "MVEZ MZUZ MZTZ";
		int n = cipher(s);
		
		printelement("����� = " + n + " ��������");

	}

	public static int cipher(String strcipher) { // �����������

		int n = 0;
		String[] s;

		String[] scipher = alphabet();
		String[] strorig = new String[strcipher.length()];

		boolean b = true;

		while (b) {
			s = alphabetshift(n);
			for (int i = 0; i < strcipher.length(); i++) {
				int j = 0;
				while (j < s.length) {
					if (strcipher.charAt(i) == ' ') {
						strorig[i] = Character.toString(strcipher.charAt(i));
					} else {
						if (Character.toString(strcipher.charAt(i)).equals(s[j])) {
							strorig[i] = scipher[j];
						}
					}
					j++;
				}
			}

			if (or(strorig)) {
				b = false;
			} else {
				n++;
			}
		}

		return n;
	}

	public static String[] alphabetshift(int k) { // ������� �� �������

		char c;
		int i = k;
		int n = 26;
		String[] str = new String[n];

		for (c = 'A'; c <= 'Z'; c++) {
			str[i] = Character.toString(c);
			if (i < n - 1) {
				i++;
			} else {
				i = 0;
			}
		}
		return str;
	}

	public static String[] alphabet() { // �������

		char c;
		int i;
		int n = 26;
		String[] str = new String[n];

		for (c = 'A', i = 0; c <= 'Z'; c++, i++) {
			str[i] = Character.toString(c);
		}
		return str;
	}

	public static boolean or(String[] s) { // ������������� �� ������������
		Scanner sc;
		sc = new Scanner(System.in);
		
		for (String e : s) {
			printelement(e);
		}
		printelement("\n�����?(y/n)");
		return sc.nextLine().equals("y");
	}

	public static void printelement(String s) { // ������
		System.out.print(s);
	}

}
