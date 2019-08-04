package Beans;

public class Items {

	private int cdPedido;
	private int cdProduto;

	public Items(int cdPedido, int cdProduto) {
		super();
		this.cdPedido = cdPedido;
		this.cdProduto = cdProduto;
	}

	public int getCdPedido() {
		return cdPedido;
	}

	public void setCdPedido(int cdPedido) {
		this.cdPedido = cdPedido;
	}

	public int getCdProduto() {
		return cdProduto;
	}

	public void setCdProduto(int cdProduto) {
		this.cdProduto = cdProduto;
	}
}
