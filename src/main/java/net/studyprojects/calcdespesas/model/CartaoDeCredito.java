package net.studyprojects.calcdespesas.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class CartaoDeCredito {

	@Id
	@GeneratedValue
	private Long id;

	private String titulo; // Ex.: Diners Club International Micha

	private String descricao;

	@Temporal(TemporalType.DATE)
	private Calendar dataDeExpiracao;

	@Enumerated(EnumType.STRING)
	private Bandeira bandeira; // Ex.: DINNERS

	// Relationships

	@OneToMany(mappedBy = "cartaoDeCredito")
	private List<Fatura> faturas = new ArrayList<>();

	@OneToMany(mappedBy = "cartaoDeCredito")
	private List<Compra> compras = new ArrayList<>();

	// Getters & Setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Calendar getDataDeExpiracao() {
		return dataDeExpiracao;
	}

	public void setDataDeExpiracao(Calendar dataDeExpiracao) {
		this.dataDeExpiracao = dataDeExpiracao;
	}

	public Bandeira getBandeira() {
		return bandeira;
	}

	public void setBandeira(Bandeira bandeira) {
		this.bandeira = bandeira;
	}

	// Relationships

	public List<Fatura> getFaturas() {
		return faturas;
	}

	public void setFaturas(List<Fatura> faturas) {
		this.faturas = faturas;
	}

	public List<Compra> getCompras() {
		return compras;
	}

	public void setCompras(List<Compra> compras) {
		this.compras = compras;
	}

}
