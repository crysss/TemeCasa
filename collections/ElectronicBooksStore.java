/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collections;

import java.util.HashMap;
import java.util.TreeSet;

/**
 * This application manages a store of electronic books format.
 * 
 * @author gheorgheaurelpacurar
 */
public class ElectronicBooksStore {

	public static void printDetails(ElectronicBook electronicbook) {
		System.out.println("Book title: " + electronicbook.getTitle());
		System.out.println("Book ISBN: " + electronicbook.getISBN());
		System.out.println("Book Publisher: " + electronicbook.getPublisher());
		String[] authorsOfThisBook = electronicbook.getAuthors();
		int numberOfAuthors = authorsOfThisBook.length;
		for (int currentAuthor = 0; currentAuthor < numberOfAuthors; currentAuthor++) {
			System.out.println("Book author: " + authorsOfThisBook[currentAuthor]);
		}
		System.out.println("Book Price: " + electronicbook.getPrice());
		System.out.println("Book format: " + electronicbook.getElectronicFormat());
		System.out.println("Book year of publication: " + electronicbook.getYearOfPublication());
		System.out.println("------------------------------------------------------------------");
	}

	public static void main(String[] args) {

		// declare an array of ElectronicBooks
		ElectronicBook[] books;
		books = new ElectronicBook[3];

		// create a new eBook
		String isbn = "978-606-758-671-8";
		String[] authors = new String[] { "Lev Grossman", "Mira Grossman" };
		EBook eBook = new EBook(isbn, authors);
		eBook.setTitle("Taramul Magicianului");
		eBook.setPrice(20.93f);
		eBook.setElectronicFormat(ElectronicBook.FormatOfElectronicBook.DRM);
		eBook.setRecommendedReader(EBook.eBooksReaders.AMAZON);
		eBook.setPublisher("Nemira");
		eBook.setYearOfPublication(ElectronicBook.YearOfPublication.Y2016);
		String[] downloadLinks = new String[] {
				"http://www.elefant.ro/ebooks/fictiune/literatura-de-divertisment/sf-fantasy/taramul-magicianului-al-treilea-volum-al-seriei-magicienii-322807.html" };
		eBook.setRemarksAndNotes(new String[] { "" });
		eBook.setDownloadLinks(downloadLinks);
		// Add eBook to the books
		books[0] = eBook;
		// create a new eBook
		isbn = "978-606-758-667-1";
		authors = new String[] { "Bogdan Munteanu" };
		eBook = new EBook(isbn, authors);
		eBook.setTitle("Ai uitat sa zambesti.");
		eBook.setPrice(12.53f);
		eBook.setElectronicFormat(ElectronicBook.FormatOfElectronicBook.DRM);
		eBook.setRecommendedReader(EBook.eBooksReaders.AMAZON);
		eBook.setPublisher("Nemira");
		eBook.setYearOfPublication(ElectronicBook.YearOfPublication.Y2016);
		downloadLinks = new String[] {
				"http://www.elefant.ro/ebooks/fictiune/literatura-romana/literatura-romana-contemporana/ai-uitat-sa-razi-322805.html" };
		eBook.setDownloadLinks(downloadLinks);
		eBook.setRemarksAndNotes(new String[] { "" });
		// Add eBook to the books
		books[1] = eBook;
		// create a new eBook
		isbn = "978-606-758-667-3";
		authors = new String[] { "Dany Ionathan", "Sandy Marion", "Leonore Bittman" };
		IBook iBook = new IBook(isbn, authors);
		iBook.setTitle("The Swift Programming Language (Swift 2.2)");
		iBook.setPrice(0.00f);
		iBook.setElectronicFormat(ElectronicBook.FormatOfElectronicBook.IBA);
		iBook.setRecommendedReader(IBook.iBooksReaders.APPIPAD);
		iBook.setPublisher("Apple");
		iBook.setYearOfPublication(ElectronicBook.YearOfPublication.Y2014);
		downloadLinks = new String[] { "https://itunes.apple.com/us/store?mt=11" };
		iBook.setDownloadLinks(downloadLinks);
		eBook.setRemarksAndNotes(new String[] { "This is a great iBook!", "I recommend it!" });
		// Add eBook to the books
		books[2] = iBook;

		// check the list of Books
		for (int index = 0; index < 3; index++) {

			ElectronicBooksStore.printDetails(books[index]);

		}

		HashMap<Rating, ElectronicBook> ratings = new HashMap<Rating, ElectronicBook>();
		Rating first_rating = new Rating(3, "Mike", "Average book");
		Rating second_rating = new Rating(5, "Anna", "Very interesting book");
		Rating third_rating = new Rating(5, "Anna", "Very interesting book");

		ratings.put(first_rating, books[0]);
		ratings.put(second_rating, books[1]);
		ratings.put(third_rating, books[2]);

		ElectronicBook electronicbook1 = ratings.get(first_rating);

		ElectronicBooksStore.printDetails(electronicbook1);

		electronicbook1 = ratings.get(second_rating);

		ElectronicBooksStore.printDetails(electronicbook1);

		electronicbook1 = ratings.get(third_rating);

		ElectronicBooksStore.printDetails(electronicbook1);
		
		
		TreeSet<ElectronicBook> tree = new TreeSet<ElectronicBook> ();
		tree.add(books[0]);
		tree.add(books[1]);
		tree.add(books[2]);
		
		for (ElectronicBook electronicb : tree){
			ElectronicBooksStore.printDetails(electronicb);
		}
		

	}
}