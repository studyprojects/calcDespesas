package net.studyprojects.calcdespesas.model;

import java.util.List;

public class Fatura {

	// @ManyToOne - N faturas : 1 cartao
	private Cartao cartao;

	// @OneToMany - 1 fatura : N Despesas
	private List<Despesa> despesas;

}
