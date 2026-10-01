public class Main {
	public void main() {
		// // version 1
		// int x = 19;
		// System.out.println("Hello " + x);

		// // version 2
		// int y = 18;
		// y++;
		// System.out.println("Hello " + ++y);

		// // version 3
		// int z = 19;
		// if (a == 1) {
		// System.out.println("Hello " + z);
		// return;
		// }
		// System.out.println("Bye");

		// // version 4
		// int z = 19;
		// if (a == 1) {
		// System.out.println("Hello " + z);
		// } else {
		// System.out.println("Bye");
		// }
		// System.out.println("End");

		// version 5

		for (int i = 0; i < 5; i += 1000) {
			System.out.println(i);
		}

		int i = 0;
		while (i < 5) {
			System.out.println(i);
			i += 1000;
		}

		for (; a < b;) {
			System.out.println(i);
		}

		while (a < b) {
			System.out.println(i);
		}

	}
}
