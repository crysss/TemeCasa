package test_package;

public class NumberHolder {
	
    public int anInt;
    public float aFloat;
    
    public void afiseaza () {
    	System.out.println("Afiseaza numarul int: " + anInt);
    	System.out.println("Afiseaza numarul float: " + aFloat);
    }


	public static void main(String[] args) {
	NumberHolder a = new NumberHolder ();
	
	a.anInt = 56;
	a.aFloat = 56.6f;
	a.afiseaza();

	}

}
