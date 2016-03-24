package test_package5;

public class Curs implements Finalizabil {
	public String finalizare (boolean b){
	if (b == true){
		System.out.println("Cursul s-a finalizat cu succes!");
		return "Finalizat";
	}
	else {System.out.println("Cursul nu s-a putut finaliza.");
	return "Nefinalizat";
	}
	} 
}
