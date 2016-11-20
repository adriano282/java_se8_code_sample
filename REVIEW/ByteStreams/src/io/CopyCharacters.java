package io;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import util.UtilFiles;

public class CopyCharacters {
	public static void main(String...args) {
		String fileIn = "../files/copy_characters_in.txt";
		String fileOut = "../files/copy_characters_out.txt";
		int c;
		
		UtilFiles.createIfNotExists(fileIn);

		try (FileReader fr = new FileReader(fileIn);
			FileWriter fw = new FileWriter(fileOut);) {
		
			while ((c = fr.read()) != -1) {
				fw.write(c);
			}
		}
		catch (IOException e) {}
	}
}
