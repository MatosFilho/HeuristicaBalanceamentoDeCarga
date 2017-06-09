package EmissorVersaoSemThread;

public class Processo {
	
	/* Atributos de cada processo */
	
	private int numeroCPUQueCriou;
	private int horaCriacaoTarefa;
	private int tempoDeCPUNecessario;
	
	public Processo (int id, int hora, int tempo) {
		this.numeroCPUQueCriou = id;
		this.horaCriacaoTarefa = hora;
		this.tempoDeCPUNecessario = tempo;
	}
	
	public int getNumeroCPU () {return this.numeroCPUQueCriou;}
	
	public int getTempo () {return this.tempoDeCPUNecessario;}
	
	public int getHoraCriacao () {return this.horaCriacaoTarefa;}
	
	/* Fun��o que a cada clock diminui o tempo de CPU necess�rio */
	
	public void processa () {this.tempoDeCPUNecessario-=1;}
	
}
