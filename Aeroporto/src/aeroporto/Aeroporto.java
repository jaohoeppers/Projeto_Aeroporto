package aeroporto;

import java.util.Scanner;

public class Aeroporto {

	private pista pista1;
	private pista pista2;

	boolean simulando = true;
	Scanner entrada = new Scanner(System.in);
	String val;
	int val2 = 1;
	int val3 = 0;
	int val4 = 0;
	int val5 = 1;
	int val6 = 0;
	int val7 = 0;
	int decola = 0;
	int pousa = 0;
	int acaop1 = 1;
	int acaop2 = 1;
	int pousoemerg = 0;
	float tempop = 0;
	float tempod = 0;
	float mediap = 0;
	float mediad = 0;
	int contador = 1;
	String id = String.valueOf(val2);

	//construtor da classe
	public Aeroporto() {
		this.pista1 = pista1 = new pista();
		this.pista2 = pista2 = new pista();
	}

	//metodo que printa o contador de cliclos
	public void contador() {
		System.out.println(contador + "° ciclo de operação");
	}

	//metodo que troca a acao das pistas
	public void trocaacao() {
		if (acaop1 == 0) {
			acaop1 = 1;
		} else {
			acaop1 = 0;
		}

		if (acaop2 == 0) {
			acaop2 = 1;
		} else {
			acaop2 = 0;
		}
	}

	//metodo que valida se a entrada foi s ou n independente de estar em capslook ou nao
	public void validasn(String val) {
		while (!val.equalsIgnoreCase("s") && !val.equalsIgnoreCase("n")) {
			System.out.println("Digite um valor aceitável:");
			val = entrada.next();
		}
		return;
	}

	//metodo que valida se a entrada foi d ou p independente de estar em capslook ou nao
	public void validadp(String val) {
		while (!val.equalsIgnoreCase("d") && !val.equalsIgnoreCase("p")) {
			System.out.println("Digite um valor aceitável:");
			val = entrada.next();
		}
		return;
	}

	//metodo que adiciona um aviao na lista de decolagem
	public void adddecola() {
		if (decola < 2) {
			decola++;
			if (pista1.getDecola().contarAvioes() > pista2.getDecola().contarAvioes()) {
				pista2.addaviaodecola(id = ((val6 = val6 + 2) + "" + (val7 = val7 + 2)), "decola");
			} else {
				pista1.addaviaodecola(id = ((val6 = val6 + 2) + "" + (val7 = val7 + 2)), "decola");
			}
		} else {
			System.out.println("Já foram adicionados 2 avioes para decolar");
			System.out.println("Deseja adicionar este aviao para pousar? S ou N");
			val = entrada.next();

			while (!val.equalsIgnoreCase("s") && !val.equalsIgnoreCase("n")) {
				System.out.println("Digite um valor aceitável:");
				val = entrada.next();
			}

			if (val.equalsIgnoreCase("s")) {
				System.out.println("Digite o nivel de combustivel deste aviao");
				val3 = entrada.nextInt();
				if (pista1.getPousa().contarAvioes() > pista2.getPousa().contarAvioes()) {
					pista2.addaviaopousa(id = ((val2 = val2 + 2) + "" + (val5 = val5 + 2)), val3, "pousa");
				} else {
					pista1.addaviaopousa(id = ((val2 = val2 + 2) + "" + (val5 = val5 + 2)), val3, "pousa");
				}
			}

		}
	}

	//metodo que adiciona um aviao na lista de pouso
	public void addpousa() {
		if (pousa < 2) {
			pousa++;
			System.out.println("Digite o nivel do combustivel");
			val3 = entrada.nextInt();
			if (pista1.getPousa().contarAvioes() > pista2.getPousa().contarAvioes()) {
				pista2.addaviaopousa(id = ((val2 = val2 + 2) + "" + (val5 = val5 + 2)), val3, "pousa");
			} else {
				pista1.addaviaopousa(id = ((val2 = val2 + 2) + "" + (val5 = val5 + 2)), val3, "pousa");
			}
		} else {
			System.out.println("Já foram adicionados 2 avioes para pousar");
			System.out.println("Deseja adicionar este aviao para decolar? S ou N");
			val = entrada.next();

			while (!val.equalsIgnoreCase("s") && !val.equalsIgnoreCase("n")) {
				System.out.println("Digite um valor aceitável:");
				val = entrada.next();
			}

			if (val.equalsIgnoreCase("s")) {
				if (pista1.getDecola().contarAvioes() > pista2.getDecola().contarAvioes()) {
					pista2.addaviaodecola(id = ((val6 = val6 + 2) + "" + (val7 = val7 + 2)), "decola");
				} else {
					pista1.addaviaodecola(id = ((val6 = val6 + 2) + "" + (val7 = val7 + 2)), "decola");
				}
			}
		}
	}

	//metodo que verifica se tem algum aviao em emergencia
	public void emergencia() {
		if (pista1.getPousa().emergencia() != null) {
			aviao aux = pista1.getPousa().emergencia();
			pista1.getPousa().deletePeloId(aux.getId());
			pista1.getPousa().inseririnicio(aux);
			pousoemerg++;
			acaop1 = 0;
		}
		if (pista2.getPousa().emergencia() != null) {
			aviao aux = pista2.getPousa().emergencia();
			pista2.getPousa().deletePeloId(aux.getId());
			pista2.getPousa().inseririnicio(aux);
			pousoemerg++;
			acaop2 = 0;
		}
	}

	//metodo que faz as medias de tempo
	public void medias() {
		if (pista1.getPousa().getinicio() == null && pista2.getPousa().getinicio() == null) {
			mediap = 0;
		}
		if (pista1.getPousa().getinicio() == null && pista2.getPousa().getinicio() != null) {
			tempop = pista2.getPousa().getinicio().getTempo();
			mediap = tempop;
		}
		if (pista1.getPousa().getinicio() != null && pista2.getPousa().getinicio() == null) {
			tempop = pista1.getPousa().getinicio().getTempo();
			mediap = tempop;
		}
		if (pista1.getPousa().getinicio() != null && pista2.getPousa().getinicio() != null) {
			tempop = pista1.getPousa().getinicio().getTempo() + pista2.getPousa().getinicio().getTempo();
			mediap = tempop / 2;
		}

		if (pista1.getDecola().getinicio() == null && pista2.getDecola().getinicio() == null) {
			mediad = 0;
		}
		if (pista1.getDecola().getinicio() == null && pista2.getDecola().getinicio() != null) {
			tempod = pista2.getDecola().getinicio().getTempo();
			mediad = tempod;
		}
		if (pista1.getDecola().getinicio() != null && pista2.getDecola().getinicio() == null) {
			tempod = pista1.getDecola().getinicio().getTempo();
			mediad = tempod;
		}
		if (pista1.getDecola().getinicio() != null && pista2.getDecola().getinicio() != null) {
			tempod = pista1.getDecola().getinicio().getTempo() + pista2.getDecola().getinicio().getTempo();
			mediad = tempod / 2;
		}
	}

	//metodo que monta o console
	public void montarconsole() {
		if (acaop1 == 0) {
			if (pista1.getPousa().getinicio() != null) {
				System.out.println(pista1.getPousa().getinicio().toStringpousa() + "pousou na pista 1");
				pista1.getPousa().deletePeloId(pista1.getPousa().getinicio().getId());
			} else if (pista1.getDecola().getinicio() != null) {
				System.out.println(pista1.getDecola().getinicio().toStringdecola() + "decolou na pista 1");
				pista1.getDecola().deletePeloId(pista1.getDecola().getinicio().getId());
			} else {
				System.out.println("Listas de decolagem e pouso da pista 1 estão vazias");
			}

		}
		if (acaop2 == 0) {
			if (pista2.getPousa().getinicio() != null) {
				System.out.println(pista2.getPousa().getinicio().toStringpousa() + "pousou na pista 2");
				pista2.getPousa().deletePeloId(pista2.getPousa().getinicio().getId());
			} else if (pista2.getDecola().getinicio() != null) {
				System.out.println(pista2.getDecola().getinicio().toStringdecola() + "decolou na pista 2");
				pista2.getDecola().deletePeloId(pista2.getDecola().getinicio().getId());
			} else {
				System.out.println("Listas de decolagem e pouso da pista 2 estão vazias");
			}

		}
		if (acaop1 == 1) {
			if (pista1.getDecola().getinicio() != null) {
				System.out.println(pista1.getDecola().getinicio().toStringdecola() + "decolou na pista 1");
				pista1.getDecola().deletePeloId(pista1.getDecola().getinicio().getId());
			} else if (pista1.getPousa().getinicio() != null) {
				System.out.println(pista1.getPousa().getinicio().toStringpousa() + "pousou na pista 1");
				pista1.getPousa().deletePeloId(pista1.getPousa().getinicio().getId());
			} else
				System.out.println("Listas de decolagem e pouso da pista 1 estão vazias");
		}
		if (acaop2 == 1) {
			if (pista2.getDecola().getinicio() != null) {
				System.out.println(pista2.getDecola().getinicio().toStringdecola() + "decolou na pista 2");
				pista2.getDecola().deletePeloId(pista2.getDecola().getinicio().getId());
			} else if (pista2.getPousa().getinicio() != null) {
				System.out.println(pista2.getPousa().getinicio().toStringpousa() + "pousou na pista 2");
				pista2.getPousa().deletePeloId(pista2.getPousa().getinicio().getId());
			} else {
				System.out.println("Listas de decolagem e pouso da pista 2 estão vazias");
			}
		}

		// diminui o combustivel de todos os avioes que estao na lista de pouso
		pista1.getPousa().diminuircombustivel();
		pista2.getPousa().diminuircombustivel();

		// aumenta o tempo de todos os avioes nas listas
		pista1.getPousa().aumentatempo();
		pista2.getPousa().aumentatempo();
		pista1.getDecola().aumentatempo();
		pista2.getDecola().aumentatempo();

		// printa o console final
		System.out.println("---------------------------------------");
		System.out.println("LISTA DE POUSO DA PISTA 1:");
		pista1.getPousa().mostraListapousa();

		System.out.println("LISTA DE DECOLAGEM DA PISTA 1:");
		pista1.getDecola().mostraListadecola();

		System.out.println("LISTA DE POUSO DA PISTA 2:");
		pista2.getPousa().mostraListapousa();

		System.out.println("LISTA DE DECOLAGEM DA PISTA 2:");
		pista2.getDecola().mostraListadecola();

		System.out.println("---------------------------------------");
		System.out.println("TEMPO MEDIO DE ESPERA DE POUSO:");
		System.out.println(mediap);

		System.out.println("TEMPO MEDIO DE ESPERA DE DECOLAGEM");
		System.out.println(mediad);

		System.out.println("NUMERO DE AVIOES QUE POUSARAM EM EMERGENCIA");
		System.out.println(pousoemerg);

		System.out.println("---------------------------------------");
		System.out.println("Deseja continuar com a simulação? S ou N");
		val = entrada.next();

		validasn(val);

		if (val.equalsIgnoreCase("n")) {
			simulando = false;
		}
		return;
	}

	//corpo do codigo principal que vai rodar o simuador 
	public void simular() {

		while (simulando) {

			// printa o contador de ciclos
			contador();

			// troca a acao da pista para pouso ou decolagem
			trocaacao();

			tempop = 0;
			tempod = 0;
			decola = 0;
			pousa = 0;

			// adiciona os avioes
			for (int i = 0; i < 4; i++) {

				System.out.println();
				System.out.println("Ja foram feitas " + i + " possiveis adiçoes");
				System.out.println("Deseja adicionar um aviao? S ou N");
				val = entrada.next();

				validasn(val);

				if (val.equalsIgnoreCase("s")) {
					System.out.println("Este aviao vai pousar ou decolar? D ou P");
					val = entrada.next();

					validadp(val);

					if (val.equalsIgnoreCase("d")) {

						adddecola();

					}

					if (val.equalsIgnoreCase("p")) {

						addpousa();

					}
				}
			}

			// ve se tem algum aviao em emergencia(com o combustivel igual a 1)
			emergencia();

			// faz as medias de tempo
			medias();

			System.out.println("---------------------------------------");

			// realiza todos os pousos ou decolagens possiveis
			montarconsole();

			contador++;
			pista1.grandeespaço();

		}

	}
}
