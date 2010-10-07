package br.ufes.inf.nemo.ontouml.transformation.ontouml2owl;

import java.io.File;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

public class OntoUML2OWL
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		OntoUML2OWL.Transformation(args[0], args[0].replace(".refontouml", ".owl"));
	}

	public static void Transformation (String fileAbsolutePath, String modelName)
	{
		// Configure ResourceSet
		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());
		resourceSet.getPackageRegistry().put(RefOntoUML.RefOntoUMLPackage.eNS_URI,RefOntoUML.RefOntoUMLPackage.eINSTANCE);
				
		// Open the model
		File sourceFile = new File(fileAbsolutePath);
		if (!sourceFile.isFile())
		{
			System.out.println("Error accessing: " + sourceFile.getAbsolutePath());
			return;
		}		
		URI uri = URI.createFileURI(sourceFile.getAbsolutePath());
						
		try
		{
			// Read the objects in the model
			Resource resource = resourceSet.getResource(uri, true);
			EObject p1 = resource.getContents().get(0);

			Transformation t = new Transformation(modelName, fileAbsolutePath.replace(".refontouml", ".owl"));
			t.Transform(p1);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
}