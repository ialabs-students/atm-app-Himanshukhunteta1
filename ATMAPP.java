package com.atmApp;

import java.util.Scanner;

public class ATMAPP {
	
	public static void deposit(int[] arr) {
		
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Amount to Deposit ");
		
		System.out.println("Enter No. of 2000 Notes: ");
		int Notesof2000 = sc.nextInt();
		System.out.println("Enter No. of 500 Notes:");
		int Notesof500 = sc.nextInt();
		System.out.println("Enter No. of 200 Notes:");
		int Notesof200 = sc.nextInt();
		System.out.println("Enter No. of 100 Notes:");
		int Notesof100 = sc.nextInt();

		if (Notesof2000 < 0 || Notesof500 < 0 || Notesof200 < 0 || Notesof100 < 0) {
			System.out.println("Incorrect Deposit Amount");
		}

		if (Notesof2000 == 0 && Notesof500 == 0 && Notesof200 == 0 && Notesof100 == 0) {
			System.out.println("Deposit amount cannot be zero");
		}

		arr[0] = arr[0] + Notesof2000;
		arr[1] = arr[1] + Notesof500;
		arr[2] = arr[2] + Notesof200;
		arr[3] = arr[3] + Notesof100;

		System.out.println("Balance: 2000s=" + arr[0] + ",500s=" + arr[1] + ",200s=" + arr[2] + ",100s=" + arr[3]
				+ ", Total=" + CurrentBalance(arr));

	}

	private static int CurrentBalance(int[] arr) {

		return (arr[0] * 2000) + (arr[1] * 500) + (arr[2] * 200) + (arr[3] * 100);
	}

	public static void withdraw(int[] arr, Scanner sc) {
		int cb = CurrentBalance(arr);
		System.out.println("Enter amount");
		int amt = sc.nextInt();

		if (amt == 0 || amt < 0 || amt > cb) {
			System.out.println("incorrect or insufficient funds");
			return;
		}
		int twoThousand = 0, fiveHundred = 0, twoHundred = 0, hundred = 0;
		int two2000 = 0, five500 = 0, two200 = 0, one100 = 0;

		if (amt >= 2000) {
			twoThousand = amt / 2000;
			two2000 = twoThousand;
			if (arr[0] >= twoThousand) {
				arr[0] = arr[0] - twoThousand;
				amt = amt - (twoThousand * 2000);
				
			} else {
				two2000 = arr[0];
				twoThousand = twoThousand - arr[0];
				arr[0] = 0;
				amt = amt - (two2000 * 2000);
				
			}
		}
		if (amt >= 500) {
			fiveHundred = amt / 500;
			five500 = fiveHundred;
			if (arr[1] >= fiveHundred) {
				arr[1] = arr[1] - fiveHundred;
				amt = amt - (fiveHundred * 500);
		
			} else {
				five500 = arr[1];
				fiveHundred = fiveHundred - arr[1];
				arr[1] = 0;
				amt = amt - (five500 * 500);
				
			}

		}
		if (amt >= 200) {
			twoHundred = amt / 200;
			two200 = twoHundred;
			if (arr[2] >= twoHundred) {
				arr[2] = arr[2] - twoHundred;
				amt = amt - (twoHundred * 200);
			
			} else {
				two200 = arr[2];
				twoHundred = twoHundred - arr[2];
				arr[2] = 0;
				amt = amt - (two200 * 200);
		
			}
		}
		if (amt >= 100 S) {
			hundred = amt / 100;
			one100 = hundred;
			if (arr[3] > hundred) {
				arr[3] = arr[3] - hundred;
				amt = amt - (hundred * 100);
				
			} else {

				one100 = arr[3];
				hundred = hundred - arr[3];
				arr[3] = 0;
				amt = amt - (one100 * 100);
				
			}
		}

		System.out.println("Dispensed: 2000s=" + two2000 + ",500s=" + five500 + ",200s=" + two200 + ",100s=" + one100);

		System.out.println("Balance: 2000s=" + arr[0] + ",500s=" + arr[1] + ",200s=" + arr[2] + ",100s=" + arr[3]
				+ ", Total=" + CurrentBalance(arr));

	}

	public static void main(String[] args) {
		
		int[] arr = new int[] { 0, 0, 0, 0 };
		int cb = 0;
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("1.For Deposit money \n2.For Withdraw money \n3.Current Account Balance \n4. Exit ");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				deposit(arr);
				cb = CurrentBalance(arr);
				break;
			case 2:
				withdraw(arr, sc);
				break;
			case 3:
				System.out.println("Bank Balance: " + CurrentBalance(arr));
				break;
			case 4:
				return;
			}

		}


	}


}
