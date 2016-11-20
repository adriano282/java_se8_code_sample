package io;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.DataInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.FileNotFoundException;

import static util.UtilFiles.*;

public class WithDataStreams {
	public static void main(String...args) {
		String dataFile = "../files/dataFile.data";
		
		createIfNotExists(dataFile);

		double[] prices = {19.99, 9.99, 15.99, 3.99};
		int[] units = {12, 8, 13, 48};
		String[] descs = {
			"T-Shirt",
			"Pant",
			"shoes",
			"blouse"
		};

		try (FileOutputStream fos = new FileOutputStream(dataFile);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			DataOutputStream out = new DataOutputStream(bos)) {
			for (int i = 0; i < prices.length; i++) {
				out.writeDouble(prices[i]);
				out.writeInt(units[i]);
				out.writeUTF(descs[i]);
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}

		double price;
		int unit;
		String desc;
		double total = 0.0;

		try (FileInputStream fis = new FileInputStream(dataFile);
			BufferedInputStream bis = new BufferedInputStream(fis);
			DataInputStream in = new DataInputStream(bis)) {
			while (true) {
				price = in.readDouble();
				unit = in.readInt();
				desc = in.readUTF();
				
				System.out.format("You ordered %d units of %s at $%.2f%n", unit, desc, price);
				total += unit*price;
			}
		}
		catch (EOFException e) {}
		catch (IOException e) {}
		System.out.printf("The value total from your order is $%.2f%n", total);
	}
}
