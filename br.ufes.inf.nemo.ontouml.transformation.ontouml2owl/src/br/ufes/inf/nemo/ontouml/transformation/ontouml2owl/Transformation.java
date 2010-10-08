package br.ufes.inf.nemo.ontouml.transformation.ontouml2owl;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import br.ufes.inf.nemo.ontouml.transformation.ontouml2owl.auxiliary.MandatoryAssociationStructure;
import br.ufes.inf.nemo.ontouml.transformation.ontouml2owl.auxiliary.MemberOfRelation;
import br.ufes.inf.nemo.ontouml.transformation.ontouml2owl.auxiliary.OntoUMLModel;
import br.ufes.inf.nemo.ontouml.transformation.ontouml2owl.auxiliary.RelatorStructure;
import br.ufes.inf.nemo.ontouml.transformation.ontouml2owl.tree.ChildPartition;
import br.ufes.inf.nemo.ontouml.transformation.ontouml2owl.tree.Node;
import br.ufes.inf.nemo.ontouml.transformation.ontouml2owl.tree.TreeProcessor;
import br.ufes.inf.nemo.ontouml.transformation.ontouml2owl.verbose.DomainVerbose;
import br.ufes.inf.nemo.ontouml.transformation.ontouml2owl.verbose.FileManager;
import br.ufes.inf.nemo.ontouml.transformation.ontouml2owl.verbose.MainVerbose;
import br.ufes.inf.nemo.ontouml.transformation.ontouml2owl.verbose.MetaVerbose;

import RefOntoUML.Class;
import RefOntoUML.Classifier;
import RefOntoUML.Collective;
import RefOntoUML.FormalAssociation;
import RefOntoUML.Generalization;
import RefOntoUML.GeneralizationSet;
import RefOntoUML.Meronymic;
import RefOntoUML.Package;
import RefOntoUML.Kind;
import RefOntoUML.Property;
import RefOntoUML.Role;
import RefOntoUML.SortalClass;
import RefOntoUML.SubKind;
import RefOntoUML.Category;
import RefOntoUML.Relator;
import RefOntoUML.Association;
import RefOntoUML.SubstanceSortal;
import RefOntoUML.Type;
import RefOntoUML.componentOf;
import RefOntoUML.memberOf;
import RefOntoUML.subCollectionOf;
import RefOntoUML.subQuantityOf;

public class Transformation
{
	FileManager myfile;
	TreeProcessor mytree;
	OntoUMLModel mymodel;
	List<RelatorStructure> relatorStructures;
	
	public Transformation (String modelName, String outName)
	{
		myfile = new FileManager(outName);
		MainVerbose.setModelId(modelName);
	}
	
	public void Transform (EObject o)
	{		
		if (!(o instanceof Package))
			return;
		Package p = (Package) o;
		
		mytree = new TreeProcessor(p);
		mymodel = new OntoUMLModel(p);
		processRelators();
		
		myfile.write(MainVerbose.initialVerbose());
		myfile.write(MetaVerbose.allMetaVerbose());

		// All Kinds
		dealAllKinds();
		
		// All Collectives
		dealAllCollectives();
		
		// For each Kind
		for (Kind k : mymodel.kinds)		
			dealKind(k, mymodel.kinds);
		
		// For each SubKind
		for (SubKind sk : mymodel.subKinds)
			dealSubKind(sk);
		
		// For each Category
		for (Category cat : mymodel.categories)
			dealCategory(cat);
		
		// For each Relator
		for (RelatorStructure rs : relatorStructures)
			dealRelator(rs);
		
		// For each Collective
		for (Collective col : mymodel.collectives)
			dealCollective(col);
		
		// For each Role
		for (Role role : mymodel.roles)
			dealRole(role);
		
		// For each Meronymic
		for (Meronymic m : mymodel.meronymics)
			dealMeronymic(m);
		
		// For each Formal Association
		for (FormalAssociation fa : mymodel.formalAssociations)
			dealFormalAssociation(fa);
		
		myfile.write(MainVerbose.finalVerbose());
		myfile.done();
	}
	
	private void processRelators ()
	{
		relatorStructures = new LinkedList<RelatorStructure>();
		
		for (Relator r : mymodel.relators)
		{
			Node n = mytree.getNode(r);
			RelatorStructure rs = new RelatorStructure(n);
			relatorStructures.add(rs);
		}
	}
	
	private void dealAllKinds ()
	{
		List<String> names = new LinkedList<String>();
		
		for (Kind k : mymodel.kinds)
			names.add(k.getName());
		
		myfile.write(DomainVerbose.allKinds(names));
	}
	
	private void dealAllCollectives ()
	{
		List<String> names = new LinkedList<String>();
		
		for (Collective c : mymodel.collectives)
			names.add(c.getName());
		
		myfile.write(DomainVerbose.allCollectives(names));
	}
	
	private List<String> getDisjointClasses (Class c)
	{
		List<String> disjointClasses = new LinkedList<String>();
		
		// For every Generalization of the Class
		for (Generalization g : c.getGeneralization())
		{
			EList<GeneralizationSet> gsets = g.getGeneralizationSet();
			
			// If the Generalization has a Generalization Set
			if (gsets.size() > 0)
			{
				GeneralizationSet gs = gsets.get(0);
				
				// If the Generalization Set is Disjoint
				if (gs.isIsDisjoint())
				{
					// For every Generalization of such Generalization Set (generalization of the brothers)
					for (Generalization bg : gs.getGeneralization())
					{
						if (bg != g)
							disjointClasses.add(bg.getSpecific().getName());
					}
				}
			}
		}
		
		return disjointClasses;
	}
	
	private List<List<String>> getChildrenByCompletePartition (Node n, boolean dealingWithKind)
	{
		List<List<String>> childrenByPartition = new LinkedList<List<String>>();
		
		// For every Generalization Set
		for (ChildPartition cp : n.getChildPartitions())
		{
			// Only the Complete Generalization Sets
			if (cp.getGS().isIsCovering())
			{
				List<String> names = new LinkedList<String>();
				
				boolean allSubKinds = true;
				
				// Children in the Generalization Set
				for (Node child : cp.getChildren())
				{
					Class childClass = child.getRelatedClass();
		
					// The partition for a Kind must be a SubKind Partition
					if (dealingWithKind && !(childClass instanceof SubKind))
						allSubKinds = false;
					
					names.add(childClass.getName());
				}
				
				if (!dealingWithKind || allSubKinds)
					childrenByPartition.add(names);
			}
		}
		
		return childrenByPartition;
	}
	
	private void dealCategory (Category cat)
	{
		Node cn = mytree.getNode(cat);
		List<List<String>> childrenByPartition;
				
		// Children Grouped by (Complete) Generalization Sets
		childrenByPartition = getChildrenByCompletePartition(cn, false);
				
		myfile.write(DomainVerbose.category(cat.getName(), childrenByPartition));
	}
	
	private List<MandatoryAssociationStructure> dealMandatoryAssociations (Node kn)
	{
		List<MandatoryAssociationStructure> mandatoryAssociations = new LinkedList<MandatoryAssociationStructure>();
				
		// For every MANDATORY BINARY FORMAL association relating this Kind/SubKind
		for (Association a : kn.getAssociations())
		{
			//System.out.println(a.getName()
				//	+ " " + a.getMemberEnd().get(0).getType().getName()
				//	+ " " + a.getMemberEnd().get(1).getType().getName());
			
			if ((a instanceof FormalAssociation) && (a.getMemberEnd().size() == 2))
			{
				Property p1, p2, myend, oppositeEnd; 				
				p1 = a.getMemberEnd().get(0);
				p2 = a.getMemberEnd().get(1);
				
				if (p1.getType() == kn.getRelatedClass())
				{
					// Kind/SubKind is the source
					myend = p1;
					oppositeEnd = p2;
				}
				else
				{
					// Kind/SubKind is the destination
					myend = p2;
					oppositeEnd = p1;
				}
				
				// Mandatory Associations only
				if (p1.getLower() > 0 || p2.getLower() > 0)
				{
					MandatoryAssociationStructure mas = new MandatoryAssociationStructure();
					mas.associationName = a.getName(); // FIXME: specialized associations receive a different name
					mas.isSource = (myend == p1);
					mas.minCardinality = oppositeEnd.getLower();
					mas.maxCardinality = oppositeEnd.getUpper();
					mas.oppositeName = oppositeEnd.getType().getName();
					mandatoryAssociations.add(mas);
				}
			}
		}
		
		return mandatoryAssociations;
	}
	
	private void dealKind (Kind k, List<Kind> kinds)
	{
		Node kn = mytree.getNode(k);
		List<List<String>> childrenByPartition;
		List<String> disjointClasses;
		
		// Children Grouped by (Complete) Generalization Sets
		childrenByPartition = getChildrenByCompletePartition(kn, true);
		
		// Disjoint from all the other Kinds
		disjointClasses = new LinkedList<String>();
		for (Kind other : kinds)
		{
			if (other != k)
				disjointClasses.add(other.getName());
		}
		
		// Mandatory Associations
		List<MandatoryAssociationStructure> mandatoryAssociations = dealMandatoryAssociations(kn);
				
		myfile.write(DomainVerbose.kind(k.getName(), childrenByPartition, disjointClasses, mandatoryAssociations));
	}
	
	private void dealCollective (Collective col)
	{
		Node n = mytree.getNode(col);
		
		List<MemberOfRelation> memberOfRelations = new LinkedList<MemberOfRelation>();
		
		for (Association a : n.getOwnedAssociations())
		{
			if (a instanceof memberOf)
			{
				memberOf mo = (memberOf) a;
				
				MemberOfRelation aux = new MemberOfRelation();
				aux.resourceName = "memberOf" + mo.part().getName() + mo.whole().getName();
				aux.partName = mo.part().getName();
				
				memberOfRelations.add(aux);
			}
		}
		
		myfile.write(DomainVerbose.collective(col.getName(), memberOfRelations));
	}
	
	private void dealSubKind (SubKind sk)
	{
		Node skn = mytree.getNode(sk);
		
		// Disjoint Brothers
		List<String> disjointClasses = getDisjointClasses(sk);
		
		// Find the sortal immediately above the SubKind
		String immediateSortal = "";
		for (Classifier parent : sk.parents())
		{
			// NOTE: Pretty arbitrary choice...
			// Suppose sk specializes two different SubKinds (sk2 and sk3) that, in their turn, specialize the same Kind (k1)
			if (parent instanceof SortalClass)
				immediateSortal = parent.getName();
		}
			
		// Mandatory Associations
		List<MandatoryAssociationStructure> mandatoryAssociations = dealMandatoryAssociations(skn);
		
		myfile.write(DomainVerbose.subKind(sk.getName(), immediateSortal, disjointClasses, mandatoryAssociations));
	}
	
	private void dealRole (Role role)
	{
		RelatorStructure relatorStructure = null;
		boolean found = false;
		
		for (RelatorStructure rs : relatorStructures)
		{
			if (found)
				break;
			
			for (Classifier anotherRole : rs.mediatedRoles)
			{
				if (role == anotherRole)
				{
					relatorStructure = rs;
					found = true;
					break;
				}
			}
		}
		
		// Connected Roles
		List<String> connectedRoles = new LinkedList<String>();
		for (Classifier anotherRole : relatorStructure.mediatedRoles)
		{
			if (anotherRole != role)
				connectedRoles.add(anotherRole.getName());
		}
		
		// Substance Sortal
		String substanceSortalName = "";
		for (Classifier parent : role.parents())
		{
			if (parent instanceof SubstanceSortal)
			{
				substanceSortalName = parent.getName();
				break;
			}
		}
		
		myfile.write
		(
			DomainVerbose.role(role.getName(), relatorStructure.relator.getName(), substanceSortalName, connectedRoles)
		);
	}
	
	private void dealRelator (RelatorStructure rs)
	{		
		myfile.write(DomainVerbose.relator(rs.relator.getName(), rs.getMediatedEnds()));
	}
	
	private void dealMeronymic (Meronymic m)
	{
		String type = "";
		if (m instanceof componentOf)
			type = "componentOf";
		else if (m instanceof subCollectionOf)
			return;		
		else if (m instanceof subQuantityOf)
			return;			
		else if (m instanceof memberOf)
			type = "memberOf";
		else
			return;
				
		myfile.write(DomainVerbose.meronymic(type, m.part().getName(), m.whole().getName(), m.isIsShareable(), m.isIsInseparable()));
	}
	
	private void dealFormalAssociation (FormalAssociation fa)
	{
		// Only BINARY Formal Associations
		if (fa.getMemberEnd().size() != 2)
			return;
		
		String associationName = null;
		String superAssociationName = null;		
		Property sourceEnd = fa.getMemberEnd().get(0); 
		Property targetEnd = fa.getMemberEnd().get(1);
		String sourceName = sourceEnd.getType().getName();
		String targetName = targetEnd.getType().getName();
		
		for (Classifier parent : fa.parents())
		{
			// Arbitrary choice of parent...
			if (parent instanceof FormalAssociation)
			{
				superAssociationName = parent.getName();
				break;
			}
		}
		
		if (superAssociationName == null)
			associationName = fa.getName();
		else
			associationName = fa.getName() + sourceName + targetName;
		
		myfile.write
		(
			DomainVerbose.formalAssociation
			(
				associationName,
				sourceName, targetName, sourceEnd.isIsReadOnly(), targetEnd.isIsReadOnly(),
				superAssociationName
			)
		);
	}
}
