package fr.loria.k.revisor.engine.revisorPCSFC.console.formula;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Set;

import fr.loria.k.revisor.engine.revisorPCSFC.console.AbstractRevisorConcolePCSFC;
import fr.loria.k.revisor.engine.revisorPCSFC.console.exceptions.IncorrectVariableTypeException;
import fr.loria.k.revisor.engine.revisorPCSFC.console.exceptions.VariableNotDeclaredException;
import fr.loria.k.revisor.engine.revisorPCSFC.console.formula.constraint.ConstraintOperator;
import fr.loria.k.revisor.engine.revisorPCSFC.console.formula.constraint.LeftMember;
import fr.loria.k.revisor.engine.revisorPCSFC.console.formula.constraint.RightMember;
import fr.loria.k.revisor.engine.revisorPCSFC.console.tos.Entry;
import fr.loria.k.revisor.engine.revisorPCSFC.console.tos.Symbol;
import fr.loria.k.revisor.engine.revisorPCSFC.console.tos.TableOfSymbols;
import fr.loria.k.revisor.engine.revisorPCSFC.console.tos.VariableType;
import fr.loria.k.revisor.engine.revisorPCSFC.pcsfc.PCSFCConstraint;
import fr.loria.k.revisor.engine.revisorPCSFC.pcsfc.PCSFCFormula;
import fr.loria.orpailleur.revisor.engine.core.console.exception.FormulaValidationException;
import fr.loria.orpailleur.revisor.engine.core.console.formula.AbstractFormula;
import fr.loria.orpailleur.revisor.engine.core.console.formula.Expression;

public class PCSFC_ConstraintLitteral<C extends AbstractRevisorConcolePCSFC<C, ?, ?, ?>> extends AbstractFormula<C, PCSFCFormula> {

	private LeftMember left;
	private ConstraintOperator operator;
	private RightMember<?> right;
	
	public PCSFC_ConstraintLitteral(LeftMember l, ConstraintOperator o, RightMember<Double> r) {
		this.left = l;
		this.operator = o;
		this.right = r;
	}

	@Override
	public boolean isUnary() {
		return true;
	}

	@Override
	public Collection<Expression<C, ?>> getChildren() {
		return new LinkedList<>();
	}

	@SuppressWarnings("unchecked")
	@Override
	public PCSFCFormula getValue(C console) {
		return new PCSFCConstraint(this.left, this.operator, (RightMember<Double>) this.right);
	}
	
	@Override
	public void validate(final C console, final Set<String> newVars) throws FormulaValidationException {
		for(Expression<C, ?> child : this.getChildren()) {
			child.validate(console, newVars);
		}
		this.left.validate();
		this.operator.validate();
		this.right.validate();
	}

	@Override
	public String toString(boolean latex) {
		// TODO Auto-generated method stub
		return null;
	}

}
