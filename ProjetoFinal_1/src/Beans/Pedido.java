package Beans;

public class Pedido {

	private double valorTotal;
	private int codigoCliente;

	public Pedido() {
	}

	public Pedido(double valorTotal, int codigoCliente) {
		super();
		this.valorTotal = valorTotal;
		this.codigoCliente = codigoCliente;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public int getCodigoCliente() {
		return codigoCliente;
	}

	public void setCodigoCliente(int codigoCliente) {
		this.codigoCliente = codigoCliente;
	}
}
