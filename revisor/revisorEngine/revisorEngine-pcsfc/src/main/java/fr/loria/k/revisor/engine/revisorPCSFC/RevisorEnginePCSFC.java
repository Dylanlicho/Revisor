package fr.loria.k.revisor.engine.revisorPCSFC;

import fr.loria.k.revisor.engine.revisorPCSFC.pcsfc.*;
import fr.loria.k.revisor.engine.revisorPCSFC.pcsfc.constraint.*;
import fr.loria.orpailleur.revisor.engine.core.AbstractRevisorEngine;

public class RevisorEnginePCSFC extends AbstractRevisorEngine {

	public PCSFCFormula revise(PCSFCFormula psi, PCSFCFormula mu, double epsilon) {
		// TODO Revision.
		
		// Please remove the warning message in "/revisorEngine-pcsfc/src/main/java/fr/loria/k/revisor/engine/revisorPCSFC/console/instruction/PCSFC_Assignment"
		// once the algorithm is fully implemented.
		
		PCSFCFormula left = new PCSFCConstraint(new LeftMemberElementTerminal<Double>((double) 1, "integer_encoding_a"), new OperatorMoreEquals(), new RightMember<Double>(1.00));
		PCSFCFormula right = new PCSFCTautology();
		return new PCSFCOr(new PCSFCAnd(left, new PCSFCNot(right)), new PCSFCAnd(new PCSFCNot(left), right));
		//return new PCSFCTautology();
		
		// Temporary return statement
		// return <insert revised formula here>;
	}
	
	
	
}
