package test_package5;

public class Profesor extends Persoana implements Notabil{
	
	public Profesor (String nume){
		setNume (nume);
			
	}

	public void primesteNota (int nota){
		System.out.println("Profesorul are nota: " + nota);
		
	}
}
