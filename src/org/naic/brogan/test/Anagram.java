package org.naic.brogan.test;

import java.util.Arrays;
import java.util.Objects;

/**
 * @author Andrew Brogan
 * @since 1/7/2019
 *
 */
public class Anagram {
	public static void main(String[] args) {
		try {
			if (args.length < 2) {
				throw new Exception();
			}
			if (args.length > 2) {
				throw new IllegalArgumentException();
			}

			System.out.println(checkForAnagram(args[0], args[1]));
		} catch (IllegalArgumentException e) {
			// If there are more than two arguments throw an IllegalArgumentException that
			// there only needs to be two arguments
			System.out.println("There only needs to be two arguments.");
		} catch (Exception e) {
			// If there are less than two arguments throw an Exception explaining there must
			// be two arguments
			System.out.println("There must be two arguments.");
		}
	}

	/**
	 * Takes two Strings and compares them to see if they are anagrams.
	 * 
	 * @param a - first String to be checked
	 * @param b - second String to be checked
	 * @return true - arguments were anagrams, false - arguments were not anagrams
	 */
	public static boolean checkForAnagram(String a, String b) {
		// Check if both strings are the same. Since the characters have not been
		// rearranged, I do not consider two of the same to be an anagram.
		// Ex: food food, " " " ", "" ""
		if (Objects.equals(a.trim(), b.trim())) {
			// If they are equal, not an anagram
			return false;
		}

		return Objects.equals(trimAndSortString(a), trimAndSortString(b));
	}

	/**
	 * Takes a String and removes all whitespace & punctuation, reduces to lower
	 * case, and sorts by character.
	 * 
	 * @param str String to be trimmed and sorted
	 * @return trimmed and sorted String
	 */
	private static String trimAndSortString(String str) {
		// Regex modified from this source:
		// https://stackoverflow.com/a/18831709
		// Remove whitespace and punctuation, then reduce to lower case
		str = str.replaceAll("[^a-zA-Z]", "").toLowerCase();

		// Convert to character array and sort characters
		char[] tempCharArr = str.toCharArray();
		Arrays.sort(tempCharArr);

		// Return as String for comparison
		return new String(tempCharArr);
	}
}
