package EmissorVersaoSemThread;

import java.util.ArrayList;

public class Processador {
	private ArrayList<Processo> filaProcessos;
	private int ID;
	private int numProcessos;
	
	Processador (int id) {
		this.filaProcessos = new ArrayList<Processo> ();
		this.ID = id;
		numProcessos = 0;
	}
	
	public void addProcesso (Processo p) {
		filaProcessos.add(p);
		numProcessos++;
	}
	
	public int getNumProcessos () {
		return this.numProcessos;
	}
	
	public int processar () {
		if (filaProcessos.get(0).getTempo() > 0) {
			filaProcessos.get(0).processa();
			return 0;
		}
		else {
			System.out.println("Processo do processador " + filaProcessos.get(0).getNumeroCPU() + 
					" processado pelo processador " + ID);
			filaProcessos.remove(0);
			numProcessos--;
			return 1;
		}
	}

	public Processo transfereProcesso() {
		Processo procTransferido = filaProcessos.get(numProcessos-1);
		filaProcessos.remove(numProcessos - 1);
		numProcessos--;
		return procTransferido;
	}
}
