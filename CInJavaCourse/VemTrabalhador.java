
public class VemTrabalhador extends ValeEletronico {
	private String empresa;
	
	public void VemEstudante (String id, String nome, String cpf, double saldo, String empresa){
		super.ValeEletronico (id, nome, cpf, saldo);
		this.empresa = empresa;
	}
	
	public void UsarPassagem(double valor){
		double temp = (super.GetSaldo())-valor;
		super.SetSaldo(temp);
	}
}
