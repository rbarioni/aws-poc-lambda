package com.capco.sqs.handler;

import java.math.BigDecimal;

public class Teste {

	static String removeNonAlphabetic(String str) {
		 
        // Use regular expression to match all non-alphabetic characters and replace with empty string
        String result = str.replaceAll("[^0-9]", "");
 
        return result; // Return the resulting string
    }
	public static void main(String[] args) {
		Double d = Double.valueOf("68.0");
		System.out.println(d.toString());
		BigDecimal teste = new BigDecimal("68.0");
		System.out.println(teste);
		String t = teste.toString();
		System.out.println(t);
		System.out.println("1234567".replaceAll("^(\\d{3})(\\d{4})$", "$1-$2"));
		String str = "LT10"; // Initialize a sample string
        String result = removeNonAlphabetic(str); // Call the removeNonAlphabetic function with input string
        System.out.println(result); // Print the resulting string with non-alp
	}

}
