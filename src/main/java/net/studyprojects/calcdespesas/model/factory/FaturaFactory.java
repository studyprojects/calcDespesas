package net.studyprojects.calcdespesas.model.factory;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import net.studyprojects.calcdespesas.model.CartaoDeCredito;
import net.studyprojects.calcdespesas.model.Fatura;
import net.studyprojects.calcdespesas.model.builder.FaturaBuilder;

import org.joda.time.DateTime;

public class FaturaFactory {

	public void constroiFaturaParaCartaoNaData(Calendar data,
			CartaoDeCredito cartao) {

		Calendar dataDeVencimento = cartao.getDataDeExpiracao();

		dataDeVencimento.set(Calendar.YEAR, data.get(Calendar.YEAR));

		FaturaBuilder fbuilder = new FaturaBuilder();

		Fatura fatura = fbuilder.comDataDeVencimento(dataDeVencimento)
				.comCartaoDeCredito(cartao).geraFatura();

		// Parcela parcela = pbuilder
		// .comValor(getValorDeCadaParcela(compra))
		// .comData(dataDaCompra.plusMonths(i).toGregorianCalendar())
		// .comDataDeLancamento(
		// dataDaCompra.plusMonths(i).toGregorianCalendar())
		// .geraParcela();

		// compra.addParcela(parcela);
		//
		// parcelas.add(parcela);

	}

	public List<Fatura> constroiFaturasParaCartao(CartaoDeCredito cartao) {

		List<Fatura> faturas = new ArrayList<>();

		DateTime dataExpiracao = new DateTime(cartao.getDataDeExpiracao()
				.getTime());

		DateTime dataDaFatura = new DateTime(Calendar.getInstance().clone());

		while (dataDaFatura.getYear() != dataExpiracao.getYear()) {
			// while (dataDaFatura.getMonthOfYear() != )
		}

		return null;

	}
}
