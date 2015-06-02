
public class VemEstudante extends ValeEletronico {
	private String instituicaoDeEnsino;
	
	public void VemEstudante (String id, String nome, String cpf, double saldo, String instituicaoDeEnsino){
		super.ValeEletronico (id, nome, cpf, saldo);
		this.instituicaoDeEnsino = instituicaoDeEnsino;
	}
	
	public void UsarPassagem(double valor){
		double temp = (super.GetSaldo())-valor;
		super.SetSaldo(temp);
	}
}
