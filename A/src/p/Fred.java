package p;

public class Fred {

	Fred() {
	}
	
	public static void main(String[] args) {
		George g;
		g = new George();	
		
		double a =1;
		double b = 12;
		double c = 9;
		g.quadraticRoot(a,b,c);
	
		
		double x = g.quadraticRoot(a, b, c);
System.out.println(x);

System.out.println(a);
System.out.println(b);
System.out.println(c);
	}
	
	
}
 