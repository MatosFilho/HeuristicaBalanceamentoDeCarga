package EmissorVersaoSemThread;

import java.util.ArrayList;
import java.util.Random;

public class Computador {
	
	private static final int AMOUNT = 10;
	private static final int TMT = 1000000000;
	
	private static int numProcessos;
	private static int numProcessadores;
	private static int mediaProcessos;
	private static int numMensagens;
	static ArrayList<Processador> multiprocessador;
	static Random gerador = new Random ();
	
	public static void vasculha (int indice) {
		for (int k = 0; k < numProcessadores; k++){
			if (k != indice){
				numMensagens++;
				if (multiprocessador.get(k).getNumProcessos() < mediaProcessos )
					multiprocessador.get(k).addProcesso(multiprocessador.get(indice).transfereProcesso());
			}
		}
	}
	
	public static void gerador () {
		int tempo = 0;
		int numCPU;
		for (int n = 0; n < AMOUNT; n++){
			tempo = (gerador.nextInt(20)+1)*1000000;
			numCPU =  (gerador.nextInt(numProcessadores)+1);
			Processo aux = new Processo(numCPU, 2017, tempo);
			multiprocessador.get(numCPU-1).addProcesso(aux);
			System.out.println("Processo para a CPU " + numCPU + " de tempo " + tempo);
			numProcessos++;
		}
	}
	
	public static void main (String[] args) {
		multiprocessador = new ArrayList<Processador> (); 
		
		Processador intel1 = new Processador (1);
		Processador intel2 = new Processador (2);
		Processador intel3 = new Processador (3);
		Processador intel4 = new Processador (4);
		
		multiprocessador.add(intel1);
		multiprocessador.add(intel2);
		multiprocessador.add(intel3);
		multiprocessador.add(intel4);
		
		numProcessos = 0;
		numProcessadores = multiprocessador.size();
		numMensagens = 0;
		
		gerador ();
		gerador ();
		gerador ();
		
		while (numProcessos > 0)
			for (int k = 0; k < numProcessadores; k++) 
				if (multiprocessador.get(k).getNumProcessos() > 0) 
					if (multiprocessador.get(k).processar() == 1) {
						numProcessos -= 1;
						mediaProcessos = (int) Math.ceil(numProcessos/numProcessadores);
						if (multiprocessador.get(k).getNumProcessos() > mediaProcessos)
							vasculha (k);
					}
		
		System.out.println("Numero de mensagens trocadas: " + numMensagens);
		
	}
}
