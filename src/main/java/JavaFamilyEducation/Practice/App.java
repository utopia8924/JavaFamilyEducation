package JavaFamilyEducation.Practice;

import java.util.*;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		int[] monthDay = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		int[] monthStart = new int[13];
		int oneYear = 365;
		Scanner myin = new Scanner(System.in);

		System.out.print("Give me the year :");
		int year = myin.nextInt();
		System.out.print("Give me the weekday of 1/1  :");
		monthStart[1] = myin.nextInt();

		// if ((西元年分是400的倍數)或(西元年分是4的倍數但不是100的倍數)): 閏年
		// else : 平年

		if ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))) {
			monthDay[2] = 29;
			oneYear = 366;
		}

		for (int i = 2; i <= 12; i++) {
			monthStart[i] = (monthStart[i - 1] + monthDay[i-1]) % 7;
		}
		System.out.print("Month for print ?");
		int target = myin.nextInt();
		System.out.println("Sun     Mon     Thu     Wed     Tur     Fri     Sat");
		for (int i = 0 ; i < monthStart[target]; i++) {
			System.out.printf("        ");
		}
		for (int i = 1; i <= monthDay[target]; i++) {
			System.out.printf("%3d     ", i );
			if ((i+monthStart[target]) % 7 == 0) {
				System.out.println();
			}
		}
		System.out.println();
		myin.close();
	}
}