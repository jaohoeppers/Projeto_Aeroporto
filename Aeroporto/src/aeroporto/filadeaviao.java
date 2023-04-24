package aeroporto;

public class filadeaviao {

	private aviao inicio;
	private aviao fim;

	public filadeaviao() {
		inicio = null;
		fim = null;

	}

	public boolean vazia() {
		return inicio == null;

	}

	public aviao getinicio() {
		return inicio;
	}

	public void setinicio(aviao inicio) {
		this.inicio = inicio;
	}

	public aviao getfim() {
		return fim;
	}

	public void setfim(aviao fim) {
		this.fim = fim;
	}

	// insere o aviao no inicio da lista
	public void inseririnicio(aviao aviao) {
		aviao novoNodo = new aviao(aviao.getId(), aviao.getCombustivel(), aviao.getStatus());
		novoNodo.setProx(inicio);
		inicio = novoNodo;
	}

	// mostra a lista de decolagem
	public void mostraListadecola() {
		if (vazia()) {
			System.out.println("Lista Vazia");
			return;
		}
		aviao aux = inicio;
		int val = 0;
		while (aux != null) {
			val++;
			System.out.println(val + "° " + aux.toStringdecola() + " ");

			aux = aux.getProx();
		}
		System.out.println();
	}

	// mostra a lista de pouso
	public void mostraListapousa() {
		if (vazia()) {
			System.out.println("Lista Vazia");
			return;
		}
		aviao aux = inicio;
		int val = 0;
		while (aux != null) {
			val++;
			System.out.println(val + "° " + aux.toStringpousa() + " ");

			aux = aux.getProx();
		}
		System.out.println();
	}

	// busca na lista pelo id e deleta
	public void deletePeloId(String id) {
		if (vazia())
			return;
		if (inicio.getId() == id) {
			inicio = inicio.getProx();
			return;
		}
		aviao aux = inicio;

		while (aux != null) {

			if (aux.getProx().getId() == id) {
				aux.setProx(aux.getProx().getProx());
				return;
			}
			aux = aux.getProx();
		}
		System.out.println("aviao nao encontrado");

	}

	//insere o aviao no final da lista de pouso
	public void inserirFinalpousa(aviao aviao) {
		aviao novonodo = new aviao(aviao.getId(), aviao.getCombustivel(), aviao.getStatus());
		aviao aux = inicio;

		if (inicio == null) {
			inicio = novonodo;
			return;
		}

		if (novonodo.getCombustivel() <= 5) {
			inseririnicio(novonodo);
			return;
		}

		while (aux.getProx() != null) {
			aux = aux.getProx();
		}
		aux.setProx(novonodo);
	}

	//insere o aviao no final da lista de decolagem
	public void inserirFinaldecola(aviao aviao) {
		aviao novonodo = new aviao(aviao.getId(), aviao.getStatus());
		aviao aux = inicio;

		if (inicio == null) {
			inicio = novonodo;
			return;
		}

		while (aux.getProx() != null) {
			aux = aux.getProx();

		}

		aux.setProx(novonodo);

	}

	//verifica a lista de pouso
	public void verificarListapousa() {
		if (vazia()) {
			System.out.println("Lista Vazia");
			return;
		}
		aviao aux = inicio;
		while (aux != null) {
			// System.out.println("1");
			if (aux.getCombustivel() <= 5) {
				inseririnicio(aux);
			}
			aux = aux.getProx();
		}
		return;
	}

	//conta os avioes da lista
	public int contarAvioes() {
		int con = 0;
		if (vazia()) {
			// System.out.println("Lista Vazia");
			return con;
		}
		aviao aux = inicio;
		while (aux != null) {
			// System.out.println("1");
			con++;
			aux = aux.getProx();
		}
		return con;
	}

	//verifica se tem algum aviao em emergencia
	public aviao emergencia() {
		aviao aux = inicio;
		while (aux != null) {
			if (aux.getCombustivel() == 1) {
				return aux;
			}
			return null;
		}
		return null;
	}

	//diminui o combustivel 
	public void diminuircombustivel() {
		if (vazia()) {
			// System.out.println("Lista Vazia");
			return;
		}
		aviao aux = inicio;
		while (aux != null) {
			// System.out.println("1");
			aux.setCombustivel(aux.getCombustivel() - 1);
			aux = aux.getProx();
		}
		return;
	}

	//aumenta o tempo de todos os avioes
	public void aumentatempo() {
		if (vazia()) {
			// System.out.println("Lista Vazia");
			return;
		}
		aviao aux = inicio;
		while (aux != null) {
			// System.out.println("1");
			aux.setTempo(aux.getTempo() + 1);
			aux = aux.getProx();
		}
		return;
	}

	public String toString(aviao aviao, int con) {
		StringBuilder builder = new StringBuilder();
		builder.append("filadecolagem [");
		builder.append(con);
		builder.append("° aviao");
		builder.append(aviao);
		builder.append("]");
		return builder.toString();
	}

}
