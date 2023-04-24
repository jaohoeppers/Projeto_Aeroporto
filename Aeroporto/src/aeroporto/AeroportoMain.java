package aeroporto;

public class AeroportoMain {

	public static void main(String[] args) {
		
		
		Aeroporto aero=new Aeroporto();
		
		aero.simular();
		
		
		/*
		String val;
		Scanner entrada = new Scanner(System.in);
		val = entrada.next();

		while(!val.equalsIgnoreCase("s") && !val.equalsIgnoreCase("n")) {
		    System.out.println("Digite um valor aceitável:");
		    val = entrada.next();
		}

		
		
		String val;
		Scanner entrada = new Scanner(System.in);
		val = entrada.next();

		while(!val.equalsIgnoreCase("s") || !val.equalsIgnoreCase("n")) {
		    System.out.println("Digite um valor aceitável:");
		    val = entrada.next();
		}

		
		
		String val;
		Scanner entrada=new Scanner(System.in);
		val=entrada.nextLine();
		
		while(val.equalsIgnoreCase("s")||val.equalsIgnoreCase("n")) {
			System.out.println("digite um valor aceitavel");
			val=entrada.next();
		}
		
		
		
		
		
		
		
		
		
		
		while(val.equals("s")) {
			System.out.println("digite um valor aceitavel");
			val=entrada.next();
		}
		
		
		
		
		filadeaviao decola=new filadeaviao();
		filadeaviao pousa=new filadeaviao();
		boolean add=true;
		
		
		int val2=1;
		String id=String.valueOf(val2);
		id=((val2+2)+""+(val2+2));
		System.out.println(id);
		
		//while(add) {
		//	System.out.println("digite o nivel de combustivel");
			
		//}
		
		
		
		
		
		
		
		aviao novo=new aviao(1,13,"pousa");
		pousa.inseririnicio(novo);
		
		novo.setCombustivel(10);
		pousa.inseririnicio(novo);
		//nova.inseririnicio(1,10,"pousa");
		
		novo.setCombustivel(15);
		pousa.inseririnicio(novo);
		//nova.inseririnicio(1,15,"pousa");
		
		novo.setCombustivel(2);
		novo.setId(2);
		novo.setStatus("decola");
		decola.inseririnicio(novo);
		//nova.inseririnicio(1,18,"decola");
		
		novo.setCombustivel(3);
		decola.inseririnicio(novo);
		//nova.inseririnicio(1,7,"decola");
		
		novo.setCombustivel(7);
		decola.inseririnicio(novo);
		//nova.inseririnicio(1,3,"decola");
		
		decola.mostraLista();
		pousa.mostraLista();
		
		//System.out.println( nova.contarAvioes());
		
		pista pista1=new pista();
		pista1.setDecola(decola);
		pista1.arrumarlistadecola2();
		pista1.getDecola().mostraLista();//
		System.out.println(pista1.getDecola().contarAvioes());
		System.out.println("------------------");
		pista1.setPousa(pousa);
		pista1.arrumarlistapousa2();
		pista1.getPousa().mostraLista();
		System.out.println(pista1.getPousa().contarAvioes());
*/
	}

}
