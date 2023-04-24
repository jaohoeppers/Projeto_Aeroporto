package aeroporto;

import java.util.Scanner;

public class aviao {
	
	private String id;
	private int combustivel;
	private String status;
	private aviao prox;
	private float tempo;
	
	Scanner entrada=new Scanner(System.in);
	
	public aviao(String id) {
		this.id=id;
		this.prox=null;
	}
	public aviao(String id,String status) {
		this.id=id;
		this.status=status;
		this.prox=null;
	}
	public aviao(String id, int combustivel, String status) {
		setCombustivel(combustivel);
		this.id=id;
		this.status=status;
		this.prox=null;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getCombustivel() {
		return combustivel;
	}
	
	//se o combustivel for menor ou igual a zero ou maior que 20 ele entra em um loop ate digitar um valor valor aceitavel
	public void setCombustivel(int combustivel) {
		while(combustivel<0||combustivel>20) {
			System.out.println("valor de combustivel invalido");
			System.out.println("digite um valor valido: ");
			combustivel=entrada.nextInt();
		}
		this.combustivel = combustivel;
	}
	public aviao getProx() {
		return prox;
	}
	public void setProx(aviao prox) {
		this.prox = prox;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public float getTempo() {
		return tempo;
	}
	public void setTempo(float tempo) {
		this.tempo = tempo;
	}
	
	public String toStringdecola() {
		StringBuilder builder = new StringBuilder();
		builder.append("aviao [id=");
		builder.append(id);
		builder.append(", status=");
		builder.append(status);
		builder.append("]");
		return builder.toString();
	}
	public String toStringpousa() {
		StringBuilder builder = new StringBuilder();
		builder.append("aviao [id=");
		builder.append(id);
		builder.append(", combustivel=");
		builder.append(combustivel);
		builder.append(", status=");
		builder.append(status);
		builder.append("]");
		return builder.toString();
	}
	
	

}
