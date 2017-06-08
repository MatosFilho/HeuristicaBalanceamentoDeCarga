package EmissorVersaoSemThread;

public class Processo {
	private int numeroCPUQueCriou;
	private long horaCriacaoTarefa;
	private int tempoDeCPUNecessario;
	
	public Processo (int id, long hora, int tempo) {
		this.numeroCPUQueCriou = id;
		this.horaCriacaoTarefa = hora;
		this.tempoDeCPUNecessario = tempo;
	}
	
	public int getNumeroCPU () {
		return this.numeroCPUQueCriou;
	}
	
	public int getTempo () {
		return this.tempoDeCPUNecessario;
	}
	
	public void processa () {
		this.tempoDeCPUNecessario-=1;
	}
}
