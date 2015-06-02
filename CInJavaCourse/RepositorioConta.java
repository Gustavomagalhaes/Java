
public class RepositorioConta {
	private	String[][] contas = new String[2][3];
	private int dex = 0;
	public RepositorioConta(){}
	
	public void inserir(Conta conta){
		contas[dex][0] = conta.getNome();
		contas[dex][1] = conta.getCPF();
		contas[dex][2] = conta.getConta();
		this.dex++;
	}
	public void getPrint(){
		System.out.println(contas[0][0]+" "+contas[0][1]+" "+contas[0][2]);	
	}

	}
