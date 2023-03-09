package CircleManager;

import java.util.Scanner;

import Circle.Circle;

public class CircleManager {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Circle c [] = new Circle[3];
		for (int i = 0; i<c.length; i++) {
			System.out.print("x, y, raius >> ");
			double x = scanner.nextDouble();
			double y = scanner.nextDouble();
			int radius = scanner.nextInt();
			c[i] = new Circle(x, y, radius);
		}
		for (int i = 0; i < c.length; i++) {
			c[i].show();
		}
		scanner.close();
	}
}
