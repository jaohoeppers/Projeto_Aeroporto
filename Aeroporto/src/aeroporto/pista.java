package aeroporto;

public class pista {
	
	private filadeaviao decola;
	private filadeaviao pousa;
	
	public pista() {
		filadeaviao decola=new filadeaviao();
		filadeaviao pousa=new filadeaviao();
		this.decola=decola;
		this.pousa=pousa;
	}
	
	//adiciona o aviao na lista de pouso
	public void addaviaopousa(String id, int combustivel, String status) {
		
		aviao aux=new aviao(id,combustivel,status);
		
			pousa.inserirFinalpousa(aux);
			//arrumarlistapousa2();
			System.out.println("Aviao ID: "+id+" inserido");
	}
	
	//adiciona o aviao na lista de decolagem
	public void addaviaodecola(String id, String status) {
		
		aviao aux=new aviao(id,status);
					
			decola.inserirFinaldecola(aux);
			System.out.println("Aviao ID: "+id+" inserido");
	}

	public filadeaviao getDecola() {
		return decola;
	}

	public void setDecola(filadeaviao decola) {
		this.decola = decola;
	}

	public filadeaviao getPousa() {
		return pousa;
	}

	public void setPousa(filadeaviao pousa) {
		this.pousa = pousa;
	}
	
	public void grandeespaço() {
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("pista [lista decolagem=");
		builder.append(decola);
		builder.append(",lista pouso=");
		builder.append(pousa);
		builder.append("]");
		return builder.toString();
	}

	

}
