package net.studyprojects.calcdespesas.model.builder;

import java.math.BigDecimal;
import java.util.Calendar;

import net.studyprojects.calcdespesas.model.CartaoDeCredito;
import net.studyprojects.calcdespesas.model.Fatura;

public class FaturaBuilder {

	private Calendar dataDeVencimento;
	private Calendar dataDePagamento;
	private BigDecimal valor; // Nao seria a soma das despesas?
	private BigDecimal valorPago;
	private CartaoDeCredito cartaoDeCredito;

	public FaturaBuilder comDataDeVencimento(Calendar dataDeVencimento) {
		this.dataDeVencimento = dataDeVencimento;
		return this;
	}

	public FaturaBuilder comDataDePagamento(Calendar dataDePagamento) {
		this.dataDePagamento = dataDePagamento;
		return this;
	}

	public FaturaBuilder comValor(BigDecimal valor) {
		this.valor = valor;
		return this;
	}

	public FaturaBuilder comValorPago(BigDecimal valorPago) {
		this.valorPago = valorPago;
		return this;
	}

	public FaturaBuilder comCartaoDeCredito(CartaoDeCredito cartaoDeCredito) {
		this.cartaoDeCredito = cartaoDeCredito;
		return this;
	}

	public Fatura geraFatura() {
		return new Fatura(dataDeVencimento, dataDePagamento, valor, valorPago,
				cartaoDeCredito);
	}

}
