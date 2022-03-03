	package Java_Samples;
	
	import org.testng.annotations.Test;
	
	public class samplePrograms {
	
		@Test
		public void sampleJavaExamples() {
			System.out.println(reverseString());
			System.out.println(reverseString_withCode("HARI"));
			swappingNumbers();
			System.out.println(reverseNumber());
			reverseNum();
			palindromeNumber();
			palindromeString();
			countNumberLenth();
			countEvenOddNumbers();
			largestNumber();
			fibonacciSeries();
			sumofElementsinArray();
		}
	
		// Using StringBuilder
		public static String reverseString() {
			StringBuilder SB = new StringBuilder("KONKA");
			SB.reverse();
			return SB.toString();
		}
	
		// by writing logic
		public static String reverseString_withCode(String str) {
			char ch[] = str.toCharArray();
			String rev = "";
			for (int i = ch.length - 1; i >= 0; i--) {
				rev = rev + ch[i];
			}
			return rev;
		}
	
		// Using StringBuilder
		public static String reverseNumber() {
			StringBuilder SB = new StringBuilder("1234");
			SB.reverse();
			return SB.toString();
		}
	
		// Swapping the values
		public static void swappingNumbers() {
			int a = 10;
			int b = 20;
	
			b = a + b - (b - a);
			System.out.println("a Value changed to " + a);
			System.out.println("b Value changed to " + b);
		}
	
		// Reverse Number
		public static void reverseNum() {
			int num = 1234;
			int rev = 0;
	
			while (num != 0) {
				rev = rev * 10 + num % 10; // num%10 will give last digit for 1234
				num = num / 10; // num/10 will give first 3 digits of 1234
			}
			System.out.println("Reverse Number of " + rev);
		}
	
		// Palindrome Number
		public static void palindromeNumber() {
			int num = 12321;
			int rev = 0;
			int Org_num = num;
			while (num != 0) {
				rev = rev * 10 + num % 10; // num%10 will give last degit for 1234
				num = num / 10; // num/10 will give first 3 degitis of 1234
			}
			if (Org_num == rev) {
				System.out.println("Palindrome Number is " + rev);
			} else {
				System.out.println("Not a Palindrome Number " + rev);
	
			}
		}
	
		// Palindrome String
		public static void palindromeString() {
			String str = "MADAM";
			String Org_str = str;
			char ch[] = str.toCharArray();
			String rev = "";
			for (int i = ch.length - 1; i >= 0; i--) {
				rev = rev + ch[i];
			}
			System.out.println(rev);
			if (Org_str.equals(rev)) {
				System.out.println("Provided String is Palindrome");
			} else {
				System.out.println("Provided String Not a Palindrome");
			}
		}
	
		// Count Number Length
		public static void countNumberLenth() {
			int num = 123456;
			int count = 0;
			while (num > 0) {
				num = num / 10;
				count++;
			}
			System.out.println(count);
		}
	
		// Count Even and Odd numbers
		public static void countEvenOddNumbers() {
			int num = 12345;
			int evenCount = 0;
			int oddCount = 0;
			while (num > 0) {
				int rem = num % 10;
				if (rem % 2 == 0) {
					evenCount++;
				} else {
					oddCount++;
				}
	
				num = num / 10;
			}
			System.out.println("Even Count is >> " + evenCount);
			System.out.println("Odd Count is >> " + oddCount);
	
		}
	
		// to get Largest Number
		public static void largestNumber() {
			int a = 10;
			int b = 20;
			int c = 30;
	
			if (a > b && a > c) {
				System.out.println(a + "is largest Number");
			} else if (b > a && b > c) {
				System.out.println(b + "is largest Number");
			} else {
				System.out.println(c + "is largest Number");
			}
		}

		// to get FibonacciSeries
		public static void fibonacciSeries() {
			int x1 = 1;
			int x2 = 0;
			int sum = 0;
			for (int i=2;i<10;i++) {
				sum=x1+x2;
				x1=x2;
				x2=sum;
				System.out.print("" + sum);
			}
		}
		
		// Sum of Elements in Array
		public static void sumofElementsinArray() {
			int myArray [] = {5,6,7,8,9};
			int myArrayLength = myArray.length;
			System.out.println("hello" + myArrayLength);
			int sum=0;
			for (int i = 0;i<=myArrayLength-1;i++)
			{
				sum = sum+myArray[i];
			}
			System.out.println(sum);
			sum = 0;
			// Enhanced For loop
			for(int value:myArray)
			{
				sum=sum+value;
			}
			System.out.println(sum);
		}
		
		@Test
		public void myTest() {
			addNumberintoArray();
		}
		
		// Sum of Elements in Array
				public static void addNumberintoArray() {
				
					byte a[]= {1,2,3};
					Byte b[]= {4,5,6};
					System.out.println(a.length + "My Test ***********" + b.length);
					
				
				}
	}