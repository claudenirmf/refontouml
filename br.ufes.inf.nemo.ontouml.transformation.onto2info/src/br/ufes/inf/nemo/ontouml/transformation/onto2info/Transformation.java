package br.ufes.inf.nemo.ontouml.transformation.onto2info;

import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

import br.ufes.inf.nemo.ontouml.transformation.onto2info.decision.*;
import br.ufes.inf.nemo.ontouml.refontouml.util.*;
import br.ufes.inf.nemo.ontouml.transformation.onto2info.ui.Onto2InfoInterface;
import br.ufes.inf.nemo.ontouml.transformation.onto2info.uml.UMLModelAbstraction;
import br.ufes.inf.nemo.ontouml.transformation.onto2info.uml.Ref2UMLReplicator;

public class Transformation
{
	// OntoUML Model (Abstraction)
	RefOntoUMLModelAbstraction ontoAbstraction;
	// UML Model (Abstraction)
	UMLModelAbstraction umlAbstraction;
	// UML Factory (Abstraction)
	Ref2UMLReplicator fa;
	// Decision Handler
	DecisionHandler dh;
	// Interface
	Onto2InfoInterface ui;
	 
	// TODO: Shouldn't the Map<RefOntoUML.Element, org.eclipse.uml2.uml.Element> stay here?
	
	public Transformation(RefOntoUMLModelAbstraction ontoAbstraction, UMLModelAbstraction umlAbstraction, Onto2InfoInterface ui)  
    { 
		this.ontoAbstraction = ontoAbstraction;
		this.umlAbstraction = umlAbstraction;
		this.ui = ui;
    	fa = new Ref2UMLReplicator();
    }
	
	public void dealHistoryTracking ()
	{
        // History Tracking
        for (Entry<RefOntoUML.Class, HistoryDecision> entry : dh.historyMap.entrySet())
        {
        	RefOntoUML.Class c1 = entry.getKey();
        	HistoryDecision decision = entry.getValue();
        	
        	if (dh.inScope(c1))
        	{
        		// OntoUML.Class in scope        		
	        	if (decision.requiresAttribute())
	        	{
	        		// HistoryTracking = true
	        		if (decision.htAttribute == null)
	        		{
	        			// UML.Property (Attribute) does not exist
	        			decision.htAttribute = umlAbstraction.addHistoryTrackingAttribute(c1);
	        			
	        			ui.writeLog("Created UML.Property for " + c1.getName() + ": " + decision.htAttribute.getName());
	        		}
	        	}
	        	else
	        	{
	        		// HistoryTracking = false
	        		if (decision.htAttribute != null)
	        		{
	        			// UML.Property (Attribute) exists
	        			// Remove it from the UML.Class
	        			umlAbstraction.removeClassAttribute(c1, decision.htAttribute);
	        			// Remove it from the HistoryDecision
	        			decision.htAttribute = null;
	        			
	        			ui.writeLog("Removed UML.Property for " + c1.getName() + " (History Tracking)");
	        		}
	        	}
        	}
        	else
        	{
        		// TODO: OntoUML.Class out of scope
        	}
        }
	}
	
	public void dealTimeTracking ()
	{
		// TODO: modularize
        // Time Tracking
        for (Entry<RefOntoUML.Class, TimeDecision> entry : dh.timeMap.entrySet())
        {
        	RefOntoUML.Class c1 = entry.getKey();
        	TimeDecision decision = entry.getValue();
        	
        	if (dh.inScope(c1))
        	{
        		// OntoUML.Class in scope
        		
        		// StartTime
	        	if (decision.start)
	        	{
	        		// StartTime = true
	        		if (decision.startAttribute == null)
	        		{
	        			// UML.Property (Attribute) does not exist
	        			decision.startAttribute = umlAbstraction.addStartTime(c1);
	        			
	        			ui.writeLog("Created UML.Property for " + c1.getName() + ": " + decision.startAttribute.getName());
	        		}
	        	}
	        	else
	        	{
	        		// StartTime = false
	        		if (decision.startAttribute != null)
	        		{
	        			// UML.Property (Attribute) exists
	        			// Remove it from the UML.Class
	        			umlAbstraction.removeClassAttribute(c1, decision.startAttribute);
	        			// Remove it from the TimeDecision
	        			decision.startAttribute = null;
	        			
	        			ui.writeLog("Removed UML.Property for " + c1.getName() + " (Start Time Tracking)");
	        		}
	        	}
	        		
	        	// EndTime
	        	if (decision.end)
	        	{
	        		// EndTime = true
	        		if (decision.endAttribute == null)
	        		{
	        			// UML.Property (Attribute) does not exist
	        			decision.endAttribute = umlAbstraction.addEndTime(c1);
	        			
	        			ui.writeLog("Created UML.Property for " + c1.getName() + ": " + decision.endAttribute.getName());
	        		}
	        	}
	        	else
	        	{
	        		// EndTime = false
	        		if (decision.endAttribute != null)
	        		{
	        			// UML.Property (Attribute) exists
	        			// Remove it from the UML.Class
	        			umlAbstraction.removeClassAttribute(c1, decision.endAttribute);
	        			// Remove it from the TimeDecision
	        			decision.endAttribute = null;
	        			
	        			ui.writeLog("Removed UML.Property for " + c1.getName() + " (End Time Tracking)");
	        		}
	        	}
	        	
	        	// Duration
	        	if (decision.duration)
	        	{
	        		// Duration = true
	        		if (decision.durationAttribute == null)
	        		{
	        			// UML.Property (Attribute) does not exist
	        			decision.durationAttribute = umlAbstraction.addDuration(c1);
	        			
	        			ui.writeLog("Created UML.Property for " + c1.getName() + ": " + decision.durationAttribute.getName());
	        		}
	        	}
	        	else
	        	{
	        		// Duration = false
	        		if (decision.durationAttribute != null)
	        		{
	        			// UML.Property (Attribute) exists
	        			// Remove it from the UML.Class
	        			umlAbstraction.removeClassAttribute(c1, decision.durationAttribute);
	        			// Remove it from the TimeDecision
	        			decision.durationAttribute = null;
	        			
	        			ui.writeLog("Removed UML.Property for " + c1.getName() + " (Duration Time Tracking)");
	        		}
	        	}
        	}
        	else
        	{
        		// TODO: OntoUML.Class out of scope
        	}
        }		
	}
	
	public void createClasses ()
	{
		// All OntoUML.Classes (except Roles and Phases)
		for (RefOntoUML.Class c : ontoAbstraction.classes)
		{
			if (!(c instanceof RefOntoUML.AntiRigidSortalClass))
			{
				// Corresponding UML.Class
				org.eclipse.uml2.uml.Class c2 = (org.eclipse.uml2.uml.Class) Onto2InfoMap.getElement(c); // FIXME Onto2InfoMap.getClass
				
				// Scope
				if (dh.inScope(c))
				{
					// In Scope
					if (c2 == null)
					{
						// Create corresponding UML.Class
			        	c2 = fa.createClass(c);
			        	umlAbstraction.addPackageableElement(c2);
			        	
			        	if (c instanceof RefOntoUML.RoleMixin)
			        	{
			        		c2.setName("Potential".concat(c2.getName()));
			        	}
			        	
			        	ui.writeLog("Created UML.Class " + c2.getName());
					}
					// TODO: else { // check the attributes of the already existing corresponding UML.Class }
				}
				else
				{
					// Not in Scope
					if (c2 != null)
					{
						// Remove the corresponding UML.Class
						umlAbstraction.removePackageableElement(c2);
						// Remove the mapping between the OntoUML.Class and the UML.Class
						Onto2InfoMap.removeElement(c);
						// FIXME: Remove the mapping between Properties and Generalizations(done) and Associations(?) of the deleted UML.Class...
												
						ui.writeLog("Removed UML.Class " + c2.getName());
					}
				}
			}
		}	
	}
	
	// TODO: remove UML.Associations if something went out of scope
	public void createAssociations ()
	{
		// Roles + RoleMixins
		List<RefOntoUML.Class> qroles = new LinkedList<RefOntoUML.Class>(ontoAbstraction.roles);
		qroles.addAll(ontoAbstraction.roleMixins);
		
		// For each Role/RoleMixin
        for (RefOntoUML.Class qrole : qroles)
        {
        	RefOntoUML.Role role = null;
        	RefOntoUML.RoleMixin roleMixin = null;
        	RefOntoUML.Mediation mediation = null;
        	boolean scope = true;
        	
        	if (qrole instanceof RefOntoUML.Role)
        	{
        		// Scope for Role
        		role = (RefOntoUML.Role) qrole;
        		RefOntoUML.Class relator = role.relator();
        		mediation = role.mediation();
        		RefOntoUML.Class rigidParent = role.rigidParent();
        		
        		// There must be a Relator/Mediation
        		if (relator!=null && mediation!=null && rigidParent!=null)
        		{
            		// The Role, the Relator and the RigidParent must be in Scope
        			scope = dh.inScope(role) && dh.inScope(relator) && dh.inScope(rigidParent);
        		}
        		else
        		{
        			scope = false;
        		}
        	}
        	else if (qrole instanceof RefOntoUML.RoleMixin)
        	{
        		// Scope for RoleMixin
        		roleMixin = (RefOntoUML.RoleMixin) qrole;
        		RefOntoUML.Class relator = roleMixin.relator();
        		mediation = roleMixin.mediation();

        		// There must be a Relator/Mediation
        		if (relator!=null && mediation!=null)
        		{
        			// The RoleMixin and the Relator must be in Scope
        			// FIXME: (and perhaps at least one rigidSortal corresponding to the RoleMixin must be in scope)
        			scope = dh.inScope(roleMixin) && dh.inScope(relator);
        		}
        		else
        		{
        			scope = false;
        		}
        	}
        	
        	// The corresponding UML.Association
        	org.eclipse.uml2.uml.Association a2 = null; 
        	if (mediation != null)	
        		a2 = (org.eclipse.uml2.uml.Association) Onto2InfoMap.getElement(mediation); // FIXME Onto2InfoMap.getAssociation()
        	
        	if (scope)
        	{
        		// In Scope        		
        		if (a2 == null)
        		{
        			// No corresponding UML.Association yet
        			if (role != null)
        				a2 = fa.createAssociationRepresentingRole(role);
        			else if (roleMixin != null)
        				a2 = fa.createAssociationRepresentingRoleMixin(roleMixin);
        			
        			umlAbstraction.addPackageableElement(a2);
        			
					ui.writeLog("Created UML.Association { " +
							a2.getMemberEnds().get(0).getType().getName() + " (" + a2.getMemberEnds().get(0).getName() + "), " +
							a2.getMemberEnds().get(1).getType().getName() + " (" + a2.getMemberEnds().get(1).getName() + ") " +
							"}"); 
        		}
        	}
        	else
        	{
        		// Out of Scope
        		if (a2 != null)
        		{					
					// Remove the corresponding UML.Association from the UML.Model
					umlAbstraction.removePackageableElement(a2);
					// Remove the mapping between the OntoUML.Mediation and the UML.Association
					Onto2InfoMap.removeElement(mediation); // mediation won't be null here, since a2 is not 
											
					ui.writeLog("Removed UML.Association { " +
							a2.getMemberEnds().get(0).getType().getName() + " (" + a2.getMemberEnds().get(0).getName() + "), " +
							a2.getMemberEnds().get(1).getType().getName() + " (" + a2.getMemberEnds().get(1).getName() + ") " +
							"}");       			
        		}
        	}
        }
	}
	
	public void createGeneralizations ()
	{
		createReplicateGeneralizations();
		createReplicateGeneralizationSets();
        createArtificialGeneralizationsforRoleMixin();
	}
	
	public void createReplicateGeneralizations ()
	{
		// RigidSortals + AllMixins
		List<RefOntoUML.Class> specifics = new LinkedList<RefOntoUML.Class>(ontoAbstraction.rigidSortals);
		specifics.addAll(ontoAbstraction.allMixins);
		
        // Generalizations (Rigid Sortals) (as long as both the specific and the general are in scope)
        for (RefOntoUML.Classifier specific : specifics)
        {
        	// For each Generalization of an OntoUML.Class (excluding Roles and Phases)
			for (RefOntoUML.Generalization gen1 : specific.getGeneralization())
			{
				org.eclipse.uml2.uml.Generalization gen2 = Onto2InfoMap.getGeneralization(gen1);
				
				// generalization.specific and generalization.general in scope
				if (dh.inScope(specific) && dh.inScope(gen1.getGeneral()))
				{
					// In Scope
					if (gen2 == null)
					{
						// Create the corresponding UML.Generalization
						gen2 = fa.createGeneralization(gen1);
						
						ui.writeLog("Created UML.Generalization: " + gen2.getSpecific().getName() + "->" + gen2.getGeneral().getName());
					}
				}
				else
				{
					// Out of Scope
					if (gen2 != null)
					{
						// Removes the reference in the map from the OntoUML.Generalization to the UML.Generalization
						Onto2InfoMap.removeElement(gen1);
						
						if (dh.inScope(specific))
						{
							// OntoUML.Specific is in scope
							// Get the UML.Classifier corresponding to the specific
							org.eclipse.uml2.uml.Classifier specific2 = Onto2InfoMap.getClassifier(specific);
							// Remove the UML.Generalization as an owned generalization of the specific UML.Classifier
							umlAbstraction.removeGeneralization(specific2, gen2); 
						}
												
						// If the OntoUML.Specific is out of scope then:
						// The corresponding UML.Classifier will be absent/removed from the UML.Model in the previously called method: createdClasses()
						// So, I won't need to remove the UML.Generalizations from the UML.Model or from the specific UML.Classifier
						
						ui.writeLog("Removed UML.Generalization: " + gen2);
						//ui.writeLog("Removed UML.Generalization: " + gen2.getSpecific().getName() + "->" + gen2.getGeneral().getName()); // FIXME: when General is gone
					}
				}
			}
        }
	}
	
	public void createArtificialGeneralizationsforRoleMixin ()
	{
        // Artificial Generalizations between RoleMixin Types and RigidSortal Types (as long as both are in scope)
		
		// For each RoleMixin (e.g., Customer)
        for (RefOntoUML.RoleMixin roleMixin : ontoAbstraction.roleMixins)
        {
			List<org.eclipse.uml2.uml.Generalization> genlist = new LinkedList<org.eclipse.uml2.uml.Generalization>();
			int generalizationsInScope = 0;
			org.eclipse.uml2.uml.GeneralizationSet gset2 = null;
    		
    		// For each Role (e.g., PrivateCustomer, CorporateCustomer)
    		for (RefOntoUML.Role role : roleMixin.roles())
    		{
    			org.eclipse.uml2.uml.Generalization gen2 = Onto2InfoMap.getGeneralization(role);
    			RefOntoUML.RigidSortalClass rigidParent = role.rigidParent();
    			org.eclipse.uml2.uml.Classifier specific2 = Onto2InfoMap.getClassifier(rigidParent);
    							
    			// Generalization.general (RoleMixin), OntoUML.Role and Generalization.specific (RigidSortal) in scope
    			// Maybe I should constrain: OntoUML.Role in scope -> OntoUML.RigidParent in scope
    			if (dh.inScope(roleMixin) && dh.inScope(role) && dh.inScope(rigidParent))
    			{
    				// In Scope
    				generalizationsInScope++;
    				
    				if (gen2 == null)
    				{
    					// UML.Generalization (RigidSortal->RoleMixin) does not exist
        				// Create artificial Generalization (RigidSortal -> RoleMixin)
    					org.eclipse.uml2.uml.Classifier general2 = Onto2InfoMap.getClassifier(roleMixin);    					
    					
        				gen2 = umlAbstraction.createGeneralization (specific2, general2);
        				genlist.add(gen2);
        				
        				// Relates the OntoUML.Role and the UML.Generalization
        				Onto2InfoMap.relateElements(role, gen2);
        				
        				ui.writeLog("Created UML.Generalization (artificial): " + gen2.getSpecific().getName() + "->" + gen2.getGeneral().getName());        				
    				}
    			}
    			else
    			{
    				// Out of Scope
    				if (gen2 != null)
    				{
    					// UML.Generalization exists    					
    					// Removes the reference in the map from the OntoUML.Role to the UML.Generalization
    					Onto2InfoMap.removeElement(role);
						
						if (dh.inScope(role)) // let us suppose this implies dh.inScope(rigidParent) (but, right now, this may cause a bug)
						{
							// OntoUML.Specific (UML.Generalization.specific) is in scope
							// Remove the UML.Generalization as an owned generalization of the specific UML.Classifier
							umlAbstraction.removeGeneralization(specific2, gen2); 
						}
												
						// If the OntoUML.Specific is out of scope then:
						// The corresponding UML.Classifier will be absent/removed from the UML.Model in the previously called method: createdClasses()
						// So, I won't need to remove the UML.Generalizations from the UML.Model or from the specific UML.Classifier
						
						ui.writeLog("Removed UML.Generalization (artificial): " + gen2);
						//ui.writeLog("Removed UML.Generalization (artificial): " + gen2.getSpecific().getName() + "->" + gen2.getGeneral().getName()); // FIXME: when General is gone
    				}
    			}
    			
    			// One more thing... There may be an artificial UML.GeneralizationSet
    			if (gen2 != null)
    			{
    				 if (gen2.getGeneralizationSets().size() > 0)
    				 {
    					 gset2 = gen2.getGeneralizationSets().get(0);
    				 }
    			}
    		}
    		
    		// The GeneralizationSet is only necessary when there is at least two children (rigidSortals) in scope 
    		if (generalizationsInScope > 1)
    		{
    			// UML.GeneralizationSet "in scope"
    			if (gset2 == null)
    			{
    				// UML.GeneralizationSet does not exist
    				// Linking the GeneralizationSet and the Generalizations
	    			gset2 = umlAbstraction.createGeneralizationSetForRoleMixin (roleMixin, genlist);
	    			umlAbstraction.addPackageableElement(gset2);
	    			
	    			ui.writeLog("Created UML.GeneralizationSet (artificial): " + gset2.getName());
    			}
    		}
    		else
    		{
    			// UML.GeneralizationSet "out of scope"
    			if (gset2 != null)
    			{
    				// UML.GeneralizationSet exists
    				// Remove it from the UML.Model
    				umlAbstraction.removePackageableElement(gset2);
    				
    				ui.writeLog("Removed UML.GeneralizationSet (artificial): " + gset2.getName());
    			}
    		}
        }
	}
	
	public void createReplicateGeneralizationSets ()
	{
        // Generalization Sets (as long as both the parent and (at least some) children are in scope)      
        for (RefOntoUML.GeneralizationSet gs1 : ontoAbstraction.generalizationSets)
        {
        	if (dh.inScope(gs1.parent()))
        	{
        		// Couting OntoUML.GeneralizationSet.children() in scope
        		int childInScope = 0;
        		for (RefOntoUML.Classifier child : gs1.children())
        		{
        			if (dh.inScope(child))
        				childInScope++;
        		}
        		
        		org.eclipse.uml2.uml.GeneralizationSet gs2 = (org.eclipse.uml2.uml.GeneralizationSet) Onto2InfoMap.getElement(gs1); // FIXME getGeneralizationSet()
        		
        		if (childInScope > 1)
        		{
        			// In Scope
        			if (gs2 == null)
        			{
        				// Creates the corresponding UML.GeneralizationSet
        				gs2 = fa.createGeneralizationSet ((RefOntoUML.GeneralizationSet) gs1);        
        				umlAbstraction.addPackageableElement(gs2);
        				
        				ui.writeLog("Created UML.GeneralizationSet " + gs2.getName());
        			}
        		}
        		else
        		{
        			// Out of Scope
        			if (gs2 != null)
        			{
						// Removes the links between the UML.GeneralizationSet and the related UML.Generalizations
        				gs2.getGeneralizations().clear();
        				// Removes the corresponding UML.GeneralizationSet from the UML.Model
        				umlAbstraction.removePackageableElement(gs2);
        				// Removes the mapping between the OntoUML.GeneralizationSet and the UML.GeneralizationSet
        				Onto2InfoMap.removeElement(gs1);
        				
						ui.writeLog("Removed UML.GeneralizationSet " + gs2.getName());
        			}
        		}
        	}
        }
	}
			
	public org.eclipse.uml2.uml.Model transform (DecisionHandler dh)
	{
		if (umlAbstraction.umlmodel == null)
			umlAbstraction.umlmodel = fa.partiallyCreateModel(ontoAbstraction.model);
		this.dh = dh;
       
		createClasses();
		createAssociations();
		createGeneralizations();
        dealHistoryTracking();
        dealTimeTracking();

        umlAbstraction.addPrimitiveTypes();
        umlAbstraction.save();
        OntoUML2InfoUML.saveMap();
        
        return umlAbstraction.umlmodel;
	}
}
