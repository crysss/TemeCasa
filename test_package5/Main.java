package test_package5;

public class Main {

	public static void main(String[] args) {
		Student pers = new Student ("Ana");
		Student pers2 = new Student ("Radu");
		Profesor prof = new Profesor ("Ion");
		pers.setNivelPregatire(NivelPregatire.BEGINNER);
		
		System.out.println(pers.getNume () + " are nivelul de pregatire " + pers.getNivelPregatire());
		pers.primesteNota(5);		
		
		System.out.println(pers2.getNume ());
		pers2.primesteNota(7);
		System.out.println(prof.getNume ());
		prof.primesteNota(8);
		
		Curs curs = new Curs ();
		curs.finalizare(true);
				
	}
}
