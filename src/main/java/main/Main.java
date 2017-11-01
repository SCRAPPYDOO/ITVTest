package main;

import java.util.Scanner;

import main.till.Till;

public class Main {

	public static void main(String... args) {
		Till till = new Till();
		Scanner scanner = new Scanner(System.in);
		boolean isRunning = true;
		while (isRunning) {
			System.out.println("SHOPPING SCANNER");
			System.out.println("1: Set new list of items");
			System.out.println("2: Scan your items");
			System.out.println("3: Quit");
			int option;
			try {
				option = Integer.parseInt(scanner.nextLine());
			} catch (Exception e) {
				System.out.println("Invalid choice");
				continue;
			}

			switch (option) {
				case 1:
					System.out.println("NEW LIST OF ITEMS: example: A 50 3 130, B 30 2 45, etc");
					till.updateItems(scanner.nextLine());
					break;
				case 2:
					System.out.println("SCAN YOUR ITEMS: example: AAABBCCDDAACD");
					till.scanItems(scanner.nextLine());
					till.checkout();
					break;
				case 3:
					isRunning = false;
					break;
				default:
					break;
			}
			System.out.println("");
			System.out.println("");
		}
		scanner.close();
	}
}
