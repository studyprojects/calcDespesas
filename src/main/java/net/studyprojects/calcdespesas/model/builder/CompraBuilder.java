package net.studyprojects.calcdespesas.model.builder;

import java.math.BigDecimal;
import java.util.Calendar;

import net.studyprojects.calcdespesas.model.Compra;

public class CompraBuilder {

	private String titulo;
	private String descricao;
	private Calendar data;
	private BigDecimal valor;
	private Integer numeroDeParcelas;

	public CompraBuilder comTitulo(String titulo) {
		this.titulo = titulo;
		return this;
	}

	public CompraBuilder comDescricao(String descricao) {
		this.descricao = descricao;
		return this;
	}

	public CompraBuilder comDataDaCompra(Calendar data) {
		this.data = data;
		return this;
	}

	public CompraBuilder comValor(BigDecimal valor) {
		this.valor = valor;
		return this;
	}

	public CompraBuilder comNumeroDeParcelas(Integer numeroDeParcelas) {
		this.numeroDeParcelas = numeroDeParcelas;
		return this;
	}

	public Compra geraCompra() {
		return new Compra(titulo, descricao, data, valor, numeroDeParcelas);
	}

}
