package test_package7;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Cat {

	public static void cat(File file) {
		RandomAccessFile input = null;
		String line = null;
		try {
			input = new RandomAccessFile(file, "r");
			while ((line = input.readLine()) != null) {
				System.out.println(line);
			}
			return;
		} catch (FileNotFoundException e) {
			System.out.println("This is an exception");
		} catch (IOException e) {
			System.out.println("This is another exception");
		}

		finally {
			if (input != null) {

				try {
					input.close();
				} catch (IOException e) {
					System.out.println("This is another exception");
				}
			}
		}
	}
}
