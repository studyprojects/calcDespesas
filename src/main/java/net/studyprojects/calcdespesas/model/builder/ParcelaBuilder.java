package net.studyprojects.calcdespesas.model.builder;

import java.math.BigDecimal;
import java.util.Calendar;

import net.studyprojects.calcdespesas.model.Compra;
import net.studyprojects.calcdespesas.model.Parcela;

public class ParcelaBuilder {

	private Calendar data;
	private BigDecimal valor;
	private Compra compra;
	private Calendar dataDeLancamento;

	public ParcelaBuilder comData(Calendar data) {
		this.data = data;
		return this;
	}

	public ParcelaBuilder comValor(BigDecimal valor) {
		this.valor = valor;
		return this;
	}

	public ParcelaBuilder referenteACompra(Compra compra) {
		this.compra = compra;
		return this;
	}

	public ParcelaBuilder comDataDeLancamento(Calendar dataDeLancamento) {
		this.dataDeLancamento = dataDeLancamento;
		return this;
	}

	public Parcela geraParcela() {
		return new Parcela(data, valor, compra, dataDeLancamento);
	}

}
