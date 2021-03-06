package fr.loria.k.revisor.engine.revisorPCSFC.pcsfc;

import fr.loria.orpailleur.revisor.engine.core.utils.string.LatexFormatable;

public abstract class PCSFCFormula implements LatexFormatable {
	
	public abstract String toString(boolean latex);
	
	/**
	 * Method that allows every single instances of the implementing classes to specify whether these instances
	 * can be used by the revision algorithm or not 
	 * @return boolean that tells if instance of implementing class can be used for revision or not
	 */
	public abstract boolean canRevise();
	
	/**
	 * Method that transforms a formula of PCSFC into a formula of PCLC (returns a PCSFCFormula since
	 * a formula of PCLC is a formula of PCSFC as well)
	 * @return Equivalent PCLC formula
	 */
	public abstract PCSFCFormula toPCLC();
	
	/**
	 * Method that transforms a formula of PCLC into a formula of PCSFC if possible.
	 * @return Equivalent PCSFC formula
	 * TODO method isn't fully implemented in every sub-classes. In addition, sub-classes may need to redefine
	 * method equals() depending of how the PCLC revision algorithm generates new formulas.
	 */
	public abstract PCSFCFormula toPCSFC();
	
	@Override
	public final String toLatex() {
		return this.toString(true);
	}
	
}
