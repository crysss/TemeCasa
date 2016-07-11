package test_package9;

import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Test3 {
	static FileWriter fw;
	// Using Atomic variable instead of our our counter
	static AtomicLong otherCounter;

	public static void main(String[] args) {

		// create a new counter type (atomic long) which is by default
		// synchronized
		otherCounter = new AtomicLong();
		try {
			fw = new FileWriter("F:\\Java\\Teme curs\\MultithreadingFile.txt");

			fw.append("TEST1 THREAD ------------------------------------------------------\n");
		} catch (IOException ex) {
			Logger.getLogger(Test3.class.getName()).log(Level.SEVERE, null, ex);
		}

		// Using executors to start Callable tasks
		ExecutorService executor = Executors.newFixedThreadPool(2);

		Callable<Integer> taskAdunare = new Callable<Integer>() {
			public Integer call() {
				for (int i = 0; i < 500; i++) {
					if (null != otherCounter) {
						long value = otherCounter.incrementAndGet();
						try {
							if (null != otherCounter)
								fw.append(" ADUNARE - La citirea " + i + " contorul double are valoarea:" + value + "\n");
						} catch (IOException ex) {
							Logger.getLogger(Test2.class.getName()).log(Level.SEVERE, null, ex);
						}
					}
				}
				return 1;
			}
		};

		Callable<Integer> taskScadere = new Callable<Integer>() {
			public Integer call() {
				for (int i = 0; i < 500; i++) {
					if (null != otherCounter) {
						long value = otherCounter.decrementAndGet();
						try {
							if (null != otherCounter)
								fw.append(" SCADERE - La citirea " + i + " contorul double are valoarea:" + value + "\n");
						} catch (IOException ex) {
							Logger.getLogger(Test2.class.getName()).log(Level.SEVERE, null, ex);
						}
					}
				}
				return 1;
			}
		};
		Future<Integer> rezultatAdunare = executor.submit(taskAdunare);
		Future<Integer> rezultatScadere = executor.submit(taskScadere);

		// Print value of counter in the third parallel thread
		for (int i = 0; i < 500; i++) {
			System.out.println("La citirea " + i + " Contorul Double are valoarea:" + otherCounter.get());
			writeCounterInFile(i, "F:\\Java\\Teme curs\\MultithreadingFile.txt");

		}
		// Executor shutdown
		while (!rezultatAdunare.isDone() || !rezultatScadere.isDone()) {
			System.out.println("One of our tasks is still running...nothing to do...adunare=" + rezultatAdunare.isDone() + " scadere=" + rezultatScadere.isDone());
		}
		System.out.println("Our tasks ended....we will shutdown the executor");
		executor.shutdownNow();

	}

	synchronized private static void writeCounterInFile(int count, String filePath) {
		try {
			fw.append("TEST1 THREAD - La citirea " + count + " Contorul double are valoarea:" + otherCounter.get() + "\n");
		} catch (IOException ex) {
			Logger.getLogger(Test3.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}