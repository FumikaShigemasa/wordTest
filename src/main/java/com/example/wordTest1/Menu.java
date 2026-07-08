package com.example.wordTest1;

import java.util.Scanner;

public class Menu {

	Scanner scan = new Scanner(System.in);

	public Integer mainMenu() {

		System.out.println("分野を選択してください");
		System.out.println("1：テクノロジ系");
		System.out.println("2：マネジメント系");
		System.out.println("3：ストラテジ系");
		System.out.println("4：全分野");

		Integer select = scan.nextInt();

		return select - 1;
	}

}
