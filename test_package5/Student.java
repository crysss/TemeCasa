package test_package5;

enum NivelPregatire {BEGINNER, INTERMEDIATE, ADVANCED};

public class Student extends Persoana implements Notabil {
	private int varsta;
	private NivelPregatire nivel_de_pregatire;
	
	public int getVarsta () {
		return this.varsta;
	}
	
	public void setVarsta (int v){
		this.varsta = v;
	}
	
	public void setNivelPregatire (NivelPregatire niv){
		this.nivel_de_pregatire = niv;
	}
	
	public NivelPregatire getNivelPregatire (){
		return this.nivel_de_pregatire;
	}
	
	public Student (String nume){
		setNume (nume);
	}
	
	public void primesteNota (int nota){
		
		if (nota < 5){
			System.out.println("respins");}
			else System.out.println("admis cu nota: " + nota);
		if (nota == 10){
			System.out.println("premiant");
		}
	}
}
