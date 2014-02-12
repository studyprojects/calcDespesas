package net.studyprojects.calcdespesas.model.factory;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import net.studyprojects.calcdespesas.model.Compra;
import net.studyprojects.calcdespesas.model.Parcela;
import net.studyprojects.calcdespesas.model.builder.ParcelaBuilder;

import org.joda.time.DateTime;

public class ParcelaFactory {

	public List<Parcela> constroiParcelasParaCompra(Compra compra) {

		List<Parcela> parcelas = new ArrayList<>();

		for (int i = 0; i < compra.getNumeroDeParcelas(); i++) {

			DateTime dataDaCompra = new DateTime(compra.getData().clone());

			ParcelaBuilder pbuilder = new ParcelaBuilder();

			Parcela parcela = pbuilder
					.comValor(getValorDeCadaParcela(compra))
					.comData(dataDaCompra.plusMonths(i).toGregorianCalendar())
					.comDataDeLancamento(
							dataDaCompra.plusMonths(i).toGregorianCalendar())
					.geraParcela();

			compra.addParcela(parcela);

			parcelas.add(parcela);

		}

		return parcelas;
	}

	private BigDecimal getValorDeCadaParcela(Compra compra) {

		BigDecimal numerador = compra.getValor();

		BigDecimal denominador = new BigDecimal(compra.getNumeroDeParcelas());

		// Determina a precisao (9 digitos) do calculo e o scale para o numero
		// de casas decimais.
		MathContext mc = new MathContext(9, RoundingMode.HALF_EVEN);
		BigDecimal valorDaParcela = numerador.divide(denominador, mc).setScale(
				2, RoundingMode.HALF_EVEN);

		return valorDaParcela;
	}

}
