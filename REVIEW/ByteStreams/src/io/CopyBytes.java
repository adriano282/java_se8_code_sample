package io;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import static util.UtilFiles;

public class CopyBytes {
	public static void main(String...args) {
		String nameFileIn = "files/copy_bytes.txt";
		String nameFileOut = "files/copy_bytes_out.txt";
		int c;
		
		createIFNotExists(nameFileIn);

		try (InputStream in = new FileInputStream(nameFileIn);
			OutputStream out = new FileOutputStream(nameFileOut);) {
			while ((c = in.read()) != -1) { 
				out.write(c);
			}
		}
		catch (IOException e) {e.printStackTrace();}
	}
}

