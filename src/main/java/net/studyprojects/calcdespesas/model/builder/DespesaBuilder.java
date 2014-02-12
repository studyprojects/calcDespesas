package net.studyprojects.calcdespesas.model.builder;

import java.math.BigDecimal;
import java.util.Calendar;

import net.studyprojects.calcdespesas.model.Despesa;
import net.studyprojects.calcdespesas.model.Parcela;

public class DespesaBuilder {

	// private double fracao;
	private BigDecimal valor;
	private Calendar dataDeLancamento;
	private Parcela parcela;

	public DespesaBuilder comData(Calendar dataDeLancamento) {
		this.dataDeLancamento = dataDeLancamento;
		return this;
	}

	public DespesaBuilder comValor(BigDecimal valor) {
		this.valor = valor;
		return this;
	}

	public DespesaBuilder referenteAParcela(Parcela parcela) {
		this.parcela = parcela;
		return this;
	}

	public Despesa geraDespesa() {
		return new Despesa(valor, dataDeLancamento, parcela);
	}
}
