package com.dgit;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class codingTest {

	public static void main(String[] args) {
		int wordCount = 0;
		int size = 0;
		String line;
		BufferedReader br;

		try {
			if (args.length > 0) {

				for (int i = 0; i < args.length; i++) {

					File newFile = new File(args[i]);
					if (newFile.length() != 0) {
						br = new BufferedReader(new FileReader(args[i]));

						while ((line = br.readLine()) != null) { // reads every line in the given file
							String[] words = line.split(" "); // splits every line with an array of words in the line
							wordCount = wordCount + wordCount(words).get(0);
							size = size + wordCount(words).get(1); // if the business rules change just update the
																	// wordCount method

						}
					} else {
						throw new Exception("Empty file uploaded please upload another file");
					}

				}

			}

		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("File Does Not Exist Please Upload Another file");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("Number of words starting with either 'm' or 'M' is: " + wordCount);
			System.out.println("Number of words with length greater than 5 is: " + size);
		}

	}

	private static ArrayList<Integer> wordCount(final String[] words) {

		ArrayList<Integer> list = new ArrayList<Integer>();

		int count = 0;
		int length = 0;

		for (String word : words) {

			if (word.charAt(0) == word.toUpperCase().charAt(0)) {
				count++;

			}

			if (word.length() > 5) {
				length++;
			}
		}

		list.add(count);
		list.add(length);

		return list;

	}

}
