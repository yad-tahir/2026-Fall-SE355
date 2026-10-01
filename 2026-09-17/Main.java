public class Main {
	public static void test(Student arg) {
		arg.id = -1;
	}

	public static void main(String... args) {
		System.out.println("Hello");

		// Student s1 = new Student();
		// s1.id = 20;

		Student s2 = new Student();
		s2.id = 30;
		test(s2);

		// System.out.println(s1.id);
		// System.out.println(s2.id);

		// Student s3 = s1;
		// s3.id = -20;
		// System.out.println(s1.id);
		for (int i = 0; i < 10; i++) {
			int name;

		}

	}

}
