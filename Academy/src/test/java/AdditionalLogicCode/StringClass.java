package AdditionalLogicCode;

public class StringClass {

	public static void main(String[] args) {

		String original = "Hello World";
		String Reverse = "";

		System.out.println(original.indexOf("W"));
		System.out.println(original.charAt(4));
		System.out.println(original.substring(5, 10));
		System.out.println(original.substring(0));
		System.out.println(original.toUpperCase());
		System.out.println(original.toLowerCase());

		System.out.println(original.trim());
		System.out.println(original.replace("Hello", "Divy"));

		String[] lit = original.split(" ");

		System.out.println(lit[0]);
		System.out.println(lit[1]);

		for (int i = original.length() - 1; i >= 0; i--) {

			Reverse = Reverse + original.charAt(i);
		}

		System.out.println(Reverse);

		if (original == Reverse) {

			System.out.println("String is Palindrome");

		} else {

			System.out.println("String is not palindrome");
		}

	}

}
