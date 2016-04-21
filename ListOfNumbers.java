package test_package7;

import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class ListOfNumbers {
	private List<Integer> list;
	private static int SIZE = 10;

	public ListOfNumbers() {
		list = new ArrayList<Integer>(SIZE);
		for (int i = 0; i < SIZE; i++)
			list.add(new Integer(i));
	}

	public void readList(String numefisier) {
		BufferedReader br = null ;
		try {
			br = new BufferedReader(new FileReader(numefisier));
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();

			while (line != null) {
				sb.append(line);
				sb.append(System.lineSeparator());
				System.out.println(line);
				int i = Integer.parseInt(line);
				SIZE++;
				list.add(i);
				line = br.readLine();
			}
			String everything = sb.toString();
		} catch (IOException e) {
			System.out.println("a aparut o exceptie " + e);
		}
		finally {
			try{
				br.close();
			} catch (IOException e) {
				System.out.println("a aparut a doua exceptie");
			} catch (NullPointerException e){
				System.out.println("a aparut a treia exceptie");
			}
		}
		
		
	}

	public void writeList() {
		PrintWriter out = null;

		try {
			System.out.println("Entering try statement");
			out = new PrintWriter(new FileWriter("OutFile.txt"));

			for (int i = 0; i < SIZE; i++)
				out.println("Value at: " + i + " = " + list.get(i));
		} catch (IndexOutOfBoundsException e) {
			System.err.println("Caught IndexOutOfBoundsException: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Caught IOException: " + e.getMessage());
		} finally {
			if (out != null) {
				System.out.println("Closing PrintWriter");
				out.close();
			} else {
				System.out.println("PrintWriter not open");
			}
		}
	}
}