/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package RefOntoUML.provider;


import RefOntoUML.Generalization;
import RefOntoUML.GeneralizationSet;
import RefOntoUML.RefOntoUMLPackage;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link RefOntoUML.GeneralizationSet} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class GeneralizationSetItemProvider
	extends PackageableElementItemProvider
	implements
		IEditingDomainItemProvider,
		IStructuredItemContentProvider,
		ITreeItemContentProvider,
		IItemLabelProvider,
		IItemPropertySource
{
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GeneralizationSetItemProvider(AdapterFactory adapterFactory)
	{
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object)
	{
		if (itemPropertyDescriptors == null)
		{
			super.getPropertyDescriptors(object);

			// rcarraretto
			addIsCoveringPropertyDescriptor(object);
			addIsDisjointPropertyDescriptor(object);
			//addPowertypePropertyDescriptor(object);
			addGeneralizationPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Is Covering feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addIsCoveringPropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GeneralizationSet_isCovering_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_GeneralizationSet_isCovering_feature", "_UI_GeneralizationSet_type"),
				 RefOntoUMLPackage.eINSTANCE.getGeneralizationSet_IsCovering(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Is Disjoint feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addIsDisjointPropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GeneralizationSet_isDisjoint_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_GeneralizationSet_isDisjoint_feature", "_UI_GeneralizationSet_type"),
				 RefOntoUMLPackage.eINSTANCE.getGeneralizationSet_IsDisjoint(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Powertype feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPowertypePropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GeneralizationSet_powertype_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_GeneralizationSet_powertype_feature", "_UI_GeneralizationSet_type"),
				 RefOntoUMLPackage.eINSTANCE.getGeneralizationSet_Powertype(),
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Generalization feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addGeneralizationPropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GeneralizationSet_generalization_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_GeneralizationSet_generalization_feature", "_UI_GeneralizationSet_type"),
				 RefOntoUMLPackage.eINSTANCE.getGeneralizationSet_Generalization(),
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This returns GeneralizationSet.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object)
	{
		return overlayImage(object, getResourceLocator().getImage("full/obj16/GeneralizationSet"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String getText(Object object)
	{
		GeneralizationSet gs = (GeneralizationSet) object;
		String gens = "";
		int i = 0;
		boolean sameGeneral = true;
		
		// If there is any Generalization in the GSet
		if (gs.getGeneralization().size() > 0)
		{
			// Check if the generalizations have the same parent
			for (i = 0; i < gs.getGeneralization().size()-1; i++)
			{			
				if (gs.getGeneralization().get(i).getGeneral() != gs.getGeneralization().get(i+1).getGeneral())
				{
					sameGeneral = false;
					break;
				}
			}
			
			// Put the parent name
			if (sameGeneral)
				gens += gs.getGeneralization().get(0).getGeneral().getName() + " {";
			
			// Put the names of the children
			i = 0;
			for (Generalization g : gs.getGeneralization())
			{
				if (sameGeneral)
				{
					gens += g.getSpecific().getName();
				}
				else
				{
					gens += g.getSpecific().getName() + " -> " + g.getGeneral().getName();
				}
				
				if (i != gs.getGeneralization().size()-1)
					gens += ", ";
				
				i++;
			}
			
			if (sameGeneral)
				gens += "}";
		}
			
		String label = "";
		
		if (gs.getName() == null || gs.getName().length() == 0)
		{
			label = getString("_UI_GeneralizationSet_type");
			if (gs.getGeneralization().size() > 0)
				label += " " + gens;
		}
		else
		{
			
			label = getString("_UI_GeneralizationSet_type") + " " + gs.getName();
			if (gs.getGeneralization().size() > 0)
				label += " / " + gens;
			
		}
		return label;
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification)
	{
		updateChildren(notification);

		switch (notification.getFeatureID(GeneralizationSet.class))
		{
			case RefOntoUMLPackage.GENERALIZATION_SET__IS_COVERING:
			case RefOntoUMLPackage.GENERALIZATION_SET__IS_DISJOINT:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object)
	{
		super.collectNewChildDescriptors(newChildDescriptors, object);
	}

}
