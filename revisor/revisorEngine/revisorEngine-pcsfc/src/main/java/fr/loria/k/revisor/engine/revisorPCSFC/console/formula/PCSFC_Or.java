package fr.loria.k.revisor.engine.revisorPCSFC.console.formula;

import fr.loria.k.revisor.engine.revisorPCSFC.console.AbstractRevisorConsolePCSFC;
import fr.loria.k.revisor.engine.revisorPCSFC.pcsfc.PCSFCFormula;
import fr.loria.k.revisor.engine.revisorPCSFC.pcsfc.PCSFCOr;
import fr.loria.orpailleur.revisor.engine.core.console.formula.BinaryOperator;
import fr.loria.orpailleur.revisor.engine.core.console.formula.Formula;

public class PCSFC_Or<C extends AbstractRevisorConsolePCSFC<C, ?, ?, ?>> extends BinaryOperator<C, PCSFCFormula> {

	public PCSFC_Or(Formula<C, PCSFCFormula> left, Formula<C, PCSFCFormula> right) {
		super(left, right);
	}

	@Override
	public PCSFCFormula getValue(C console) {
		return new PCSFCOr(this.left.getValue(console), this.right.getValue(console));
	}

	@Override
	public boolean canExtend() {
		return true;
	}

	@Override
	public String operator(boolean latex) {
		return "|";
	}

}
