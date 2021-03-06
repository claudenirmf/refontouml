/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package RefOntoUML.provider;

import RefOntoUML.util.RefOntoUMLAdapterFactory;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.edit.provider.ChangeNotifier;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IChangeNotifier;
import org.eclipse.emf.edit.provider.IDisposable;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ITableItemLabelProvider;

/**
 * This is the factory that is used to provide the interfaces needed to support Viewers.
 * The adapters generated by this factory convert EMF adapter notifications into calls to {@link #fireNotifyChanged fireNotifyChanged}.
 * The adapters also support Eclipse property sheets.
 * Note that most of the adapters are shared among multiple instances.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class RefOntoUMLItemProviderAdapterFactory extends RefOntoUMLAdapterFactory implements ComposeableAdapterFactory, IChangeNotifier, IDisposable
{
	/**
	 * This keeps track of the root adapter factory that delegates to this adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComposedAdapterFactory parentAdapterFactory;

	/**
	 * This is used to implement {@link org.eclipse.emf.edit.provider.IChangeNotifier}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IChangeNotifier changeNotifier = new ChangeNotifier();

	/**
	 * This keeps track of all the supported types checked by {@link #isFactoryForType isFactoryForType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Collection<Object> supportedTypes = new ArrayList<Object>();

	/**
	 * This constructs an instance.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public RefOntoUMLItemProviderAdapterFactory()
	{
		supportedTypes.add(IEditingDomainItemProvider.class);
		supportedTypes.add(IStructuredItemContentProvider.class);
		supportedTypes.add(ITreeItemContentProvider.class);
		supportedTypes.add(IItemLabelProvider.class);
		supportedTypes.add(IItemPropertySource.class);
		supportedTypes.add(ITableItemLabelProvider.class);
	}

	/**
	 * This keeps track of the one adapter used for all {@link RefOntoUML.Comment} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CommentItemProvider commentItemProvider;

	/**
	 * This creates an adapter for a {@link RefOntoUML.Comment}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createCommentAdapter()
	{
		if (commentItemProvider == null)
		{
			commentItemProvider = new CommentItemProvider(this);
		}

		return commentItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link RefOntoUML.Package} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PackageItemProvider packageItemProvider;

	/**
	 * This creates an adapter for a {@link RefOntoUML.Package}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createPackageAdapter()
	{
		if (packageItemProvider == null)
		{
			packageItemProvider = new PackageItemProvider(this);
		}

		return packageItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link RefOntoUML.Dependency} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DependencyItemProvider dependencyItemProvider;

	/**
	 * This creates an adapter for a {@link RefOntoUML.Dependency}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createDependencyAdapter()
	{
		if (dependencyItemProvider == null)
		{
			dependencyItemProvider = new DependencyItemProvider(this);
		}

		return dependencyItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link RefOntoUML.ElementImport} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ElementImportItemProvider elementImportItemProvider;

	/**
	 * This creates an adapter for a {@link RefOntoUML.ElementImport}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createElementImportAdapter()
	{
		if (elementImportItemProvider == null)
		{
			elementImportItemProvider = new ElementImportItemProvider(this);
		}

		return elementImportItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link RefOntoUML.PackageImport} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PackageImportItemProvider packageImportItemProvider;

	/**
	 * This creates an adapter for a {@link RefOntoUML.PackageImport}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createPackageImportAdapter()
	{
		if (packageImportItemProvider == null)
		{
			packageImportItemProvider = new PackageImportItemProvider(this);
		}

		return packageImportItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link RefOntoUML.Constraintx} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConstraintxItemProvider constraintxItemProvider;

	/**
	 * This creates an adapter for a {@link RefOntoUML.Constraintx}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createConstraintxAdapter()
	{
		if (constraintxItemProvider == null)
		{
			constraintxItemProvider = new ConstraintxItemProvider(this);
		}

		return constraintxItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link RefOntoUML.Association} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AssociationItemProvider associationItemProvider;

	/**
	 * This creates an adapter for a {@link RefOntoUML.Association}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createAssociationAdapter()
	{
		if (associationItemProvider == null)
		{
			associationItemProvider = new AssociationItemProvider(this);
		}

		return associationItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link RefOntoUML.Generalization} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GeneralizationItemProvider generalizationItemProvider;

	/**
	 * This creates an adapter for a {@link RefOntoUML.Generalization}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createGeneralizationAdapter()
	{
		if (generalizationItemProvider == null)
		{
			generalizationItemProvider = new GeneralizationItemProvider(this);
		}

		return generalizationItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link RefOntoUML.GeneralizationSet} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GeneralizationSetItemProvider generalizationSetItemProvider;

	/**
	 * This creates an adapter for a {@link RefOntoUML.GeneralizationSet}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createGeneralizationSetAdapter()
	{
		if (generalizationSetItemProvider == null)
		{
			generalizationSetItemProvider = new GeneralizationSetItemProvider(this);
		}

		return generalizationSetItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link RefOntoUML.OpaqueExpression} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OpaqueExpressionItemProvider opaqueExpressionItemProvider;

	/**
	 * This creates an adapter for a {@link RefOntoUML.OpaqueExpression}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createOpaqueExpressionAdapter()
	{
		if (opaqueExpressionItemProvider == null)
		{
			opaqueExpressionItemProvider = new OpaqueExpressionItemProvider(this);
		}

		return opaqueExpressionItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link RefOntoUML.Property} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PropertyItemProvider propertyItemProvider;

	/**
	 * This creates an adapter for a {@link RefOntoUML.Property}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createPropertyAdapter()
	{
		if (propertyItemProvider == null)
		{
			propertyItemProvider = new PropertyItemProvider(this);
		}

		return propertyItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link RefOntoUML.Class} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ClassItemProvider classItemProvider;

	/**
	 * This creates an adapter for a {@link RefOntoUML.Class}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createClassAdapter()
	{
		if (classItemProvider == null)
		{
			classItemProvider = new ClassItemProvider(this);
		}

		return classItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link RefOntoUML.Model} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModelItemProvider modelItemProvider;

	/**
	 * This creates an adapter for a {@link RefOntoUML.Model}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createModelAdapter()
	{
		if (modelItemProvider == null)
		{
			modelItemProvider = new ModelItemProvider(this);
		}

		return modelItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link RefOntoUML.DataType} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DataTypeItemProvider dataTypeItemProvider;

	/**
	 * This creates an adapter for a {@link RefOntoUML.DataType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createDataTypeAdapter()
	{
		if (dataTypeItemProvider == null)
		{
			dataTypeItemProvider = new DataTypeItemProvider(this);
		}

		return dataTypeItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link RefOntoUML.StringExpression} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StringExpressionItemProvider stringExpressionItemProvider;

	/**
	 * This creates an adapter for a {@link RefOntoUML.StringExpression}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createStringExpressionAdapter()
	{
		if (stringExpressionItemProvider == null)
		{
			stringExpressionItemProvider = new StringExpressionItemProvider(this);
		}

		return stringExpressionItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link RefOntoUML.Expression} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExpressionItemProvider expressionItemProvider;

	/**
	 * This creates an adapter for a {@link RefOntoUML.Expression}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createExpressionAdapter()
	{
		if (expressionItemProvider == null)
		{
			expressionItemProvider = new ExpressionItemProvider(this);
		}

		return expressionItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link RefOntoUML.PackageMerge} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PackageMergeItemProvider packageMergeItemProvider;

	/**
	 * This creates an adapter for a {@link RefOntoUML.PackageMerge}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createPackageMergeAdapter()
	{
		if (packageMergeItemProvider == null)
		{
			packageMergeItemProvider = new PackageMergeItemProvider(this);
		}

		return packageMergeItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link RefOntoUML.Enumeration} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EnumerationItemProvider enumerationItemProvider;

	/**
	 * This creates an adapter for a {@link RefOntoUML.Enumeration}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createEnumerationAdapter()
	{
		if (enumerationItemProvider == null)
		{
			enumerationItemProvider = new EnumerationItemProvider(this);
		}

		return enumerationItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link RefOntoUML.EnumerationLiteral} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EnumerationLiteralItemProvider enumerationLiteralItemProvider;

	/**
	 * This creates an adapter for a {@link RefOntoUML.EnumerationLiteral}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createEnumerationLiteralAdapter()
	{
		if (enumerationLiteralItemProvider == null)
		{
			enumerationLiteralItemProvider = new EnumerationLiteralItemProvider(this);
		}

		return enumerationLiteralItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link RefOntoUML.InstanceSpecification} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InstanceSpecificationItemProvider instanceSpecificationItemProvider;

	/**
	 * This creates an adapter for a {@link RefOntoUML.InstanceSpecification}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createInstanceSpecificationAdapter()
	{
		if (instanceSpecificationItemProvider == null)
		{
			instanceSpecificationItemProvider = new InstanceSpecificationItemProvider(this);
		}

		return instanceSpecificationItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link RefOntoUML.Slot} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SlotItemProvider slotItemProvider;

	/**
	 * This creates an adapter for a {@link RefOntoUML.Slot}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createSlotAdapter()
	{
		if (slotItemProvider == null)
		{
			slotItemProvider = new SlotItemProvider(this);
		}

		return slotItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link RefOntoUML.PrimitiveType} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PrimitiveTypeItemProvider primitiveTypeItemProvider;

	/**
	 * This creates an adapter for a {@link RefOntoUML.PrimitiveType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createPrimitiveTypeAdapter()
	{
		if (primitiveTypeItemProvider == null)
		{
			primitiveTypeItemProvider = new PrimitiveTypeItemProvider(this);
		}

		return primitiveTypeItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link RefOntoUML.LiteralInteger} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LiteralIntegerItemProvider literalIntegerItemProvider;

	/**
	 * This creates an adapter for a {@link RefOntoUML.LiteralInteger}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createLiteralIntegerAdapter()
	{
		if (literalIntegerItemProvider == null)
		{
			literalIntegerItemProvider = new LiteralIntegerItemProvider(this);
		}

		return literalIntegerItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link RefOntoUML.LiteralString} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LiteralStringItemProvider literalStringItemProvider;

	/**
	 * This creates an adapter for a {@link RefOntoUML.LiteralString}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createLiteralStringAdapter()
	{
		if (literalStringItemProvider == null)
		{
			literalStringItemProvider = new LiteralStringItemProvider(this);
		}

		return literalStringItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link RefOntoUML.LiteralBoolean} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LiteralBooleanItemProvider literalBooleanItemProvider;

	/**
	 * This creates an adapter for a {@link RefOntoUML.LiteralBoolean}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createLiteralBooleanAdapter()
	{
		if (literalBooleanItemProvider == null)
		{
			literalBooleanItemProvider = new LiteralBooleanItemProvider(this);
		}

		return literalBooleanItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link RefOntoUML.LiteralNull} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LiteralNullItemProvider literalNullItemProvider;

	/**
	 * This creates an adapter for a {@link RefOntoUML.LiteralNull}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createLiteralNullAdapter()
	{
		if (literalNullItemProvider == null)
		{
			literalNullItemProvider = new LiteralNullItemProvider(this);
		}

		return literalNullItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link RefOntoUML.InstanceValue} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InstanceValueItemProvider instanceValueItemProvider;

	/**
	 * This creates an adapter for a {@link RefOntoUML.InstanceValue}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createInstanceValueAdapter()
	{
		if (instanceValueItemProvider == null)
		{
			instanceValueItemProvider = new InstanceValueItemProvider(this);
		}

		return instanceValueItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link RefOntoUML.LiteralUnlimitedNatural} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LiteralUnlimitedNaturalItemProvider literalUnlimitedNaturalItemProvider;

	/**
	 * This creates an adapter for a {@link RefOntoUML.LiteralUnlimitedNatural}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createLiteralUnlimitedNaturalAdapter()
	{
		if (literalUnlimitedNaturalItemProvider == null)
		{
			literalUnlimitedNaturalItemProvider = new LiteralUnlimitedNaturalItemProvider(this);
		}

		return literalUnlimitedNaturalItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link RefOntoUML.SubKind} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SubKindItemProvider subKindItemProvider;

	/**
	 * This creates an adapter for a {@link RefOntoUML.SubKind}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createSubKindAdapter()
	{
		if (subKindItemProvider == null)
		{
			subKindItemProvider = new SubKindItemProvider(this);
		}

		return subKindItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link RefOntoUML.Kind} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected KindItemProvider kindItemProvider;

	/**
	 * This creates an adapter for a {@link RefOntoUML.Kind}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createKindAdapter()
	{
		if (kindItemProvider == null)
		{
			kindItemProvider = new KindItemProvider(this);
		}

		return kindItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link RefOntoUML.Quantity} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected QuantityItemProvider quantityItemProvider;

	/**
	 * This creates an adapter for a {@link RefOntoUML.Quantity}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createQuantityAdapter()
	{
		if (quantityItemProvider == null)
		{
			quantityItemProvider = new QuantityItemProvider(this);
		}

		return quantityItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link RefOntoUML.Collective} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CollectiveItemProvider collectiveItemProvider;

	/**
	 * This creates an adapter for a {@link RefOntoUML.Collective}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createCollectiveAdapter()
	{
		if (collectiveItemProvider == null)
		{
			collectiveItemProvider = new CollectiveItemProvider(this);
		}

		return collectiveItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link RefOntoUML.Phase} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PhaseItemProvider phaseItemProvider;

	/**
	 * This creates an adapter for a {@link RefOntoUML.Phase}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createPhaseAdapter()
	{
		if (phaseItemProvider == null)
		{
			phaseItemProvider = new PhaseItemProvider(this);
		}

		return phaseItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link RefOntoUML.Role} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RoleItemProvider roleItemProvider;

	/**
	 * This creates an adapter for a {@link RefOntoUML.Role}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createRoleAdapter()
	{
		if (roleItemProvider == null)
		{
			roleItemProvider = new RoleItemProvider(this);
		}

		return roleItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link RefOntoUML.Category} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CategoryItemProvider categoryItemProvider;

	/**
	 * This creates an adapter for a {@link RefOntoUML.Category}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createCategoryAdapter()
	{
		if (categoryItemProvider == null)
		{
			categoryItemProvider = new CategoryItemProvider(this);
		}

		return categoryItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link RefOntoUML.RoleMixin} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RoleMixinItemProvider roleMixinItemProvider;

	/**
	 * This creates an adapter for a {@link RefOntoUML.RoleMixin}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createRoleMixinAdapter()
	{
		if (roleMixinItemProvider == null)
		{
			roleMixinItemProvider = new RoleMixinItemProvider(this);
		}

		return roleMixinItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link RefOntoUML.Mixin} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MixinItemProvider mixinItemProvider;

	/**
	 * This creates an adapter for a {@link RefOntoUML.Mixin}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createMixinAdapter()
	{
		if (mixinItemProvider == null)
		{
			mixinItemProvider = new MixinItemProvider(this);
		}

		return mixinItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link RefOntoUML.Mode} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModeItemProvider modeItemProvider;

	/**
	 * This creates an adapter for a {@link RefOntoUML.Mode}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createModeAdapter()
	{
		if (modeItemProvider == null)
		{
			modeItemProvider = new ModeItemProvider(this);
		}

		return modeItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link RefOntoUML.Quality} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected QualityItemProvider qualityItemProvider;

	/**
	 * This creates an adapter for a {@link RefOntoUML.Quality}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createQualityAdapter()
	{
		if (qualityItemProvider == null)
		{
			qualityItemProvider = new QualityItemProvider(this);
		}

		return qualityItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link RefOntoUML.Relator} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RelatorItemProvider relatorItemProvider;

	/**
	 * This creates an adapter for a {@link RefOntoUML.Relator}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createRelatorAdapter()
	{
		if (relatorItemProvider == null)
		{
			relatorItemProvider = new RelatorItemProvider(this);
		}

		return relatorItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link RefOntoUML.subQuantityOf} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected subQuantityOfItemProvider subQuantityOfItemProvider;

	/**
	 * This creates an adapter for a {@link RefOntoUML.subQuantityOf}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createsubQuantityOfAdapter()
	{
		if (subQuantityOfItemProvider == null)
		{
			subQuantityOfItemProvider = new subQuantityOfItemProvider(this);
		}

		return subQuantityOfItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link RefOntoUML.subCollectionOf} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected subCollectionOfItemProvider subCollectionOfItemProvider;

	/**
	 * This creates an adapter for a {@link RefOntoUML.subCollectionOf}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createsubCollectionOfAdapter()
	{
		if (subCollectionOfItemProvider == null)
		{
			subCollectionOfItemProvider = new subCollectionOfItemProvider(this);
		}

		return subCollectionOfItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link RefOntoUML.memberOf} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected memberOfItemProvider memberOfItemProvider;

	/**
	 * This creates an adapter for a {@link RefOntoUML.memberOf}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter creatememberOfAdapter()
	{
		if (memberOfItemProvider == null)
		{
			memberOfItemProvider = new memberOfItemProvider(this);
		}

		return memberOfItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link RefOntoUML.componentOf} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected componentOfItemProvider componentOfItemProvider;

	/**
	 * This creates an adapter for a {@link RefOntoUML.componentOf}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createcomponentOfAdapter()
	{
		if (componentOfItemProvider == null)
		{
			componentOfItemProvider = new componentOfItemProvider(this);
		}

		return componentOfItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link RefOntoUML.Characterization} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CharacterizationItemProvider characterizationItemProvider;

	/**
	 * This creates an adapter for a {@link RefOntoUML.Characterization}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createCharacterizationAdapter()
	{
		if (characterizationItemProvider == null)
		{
			characterizationItemProvider = new CharacterizationItemProvider(this);
		}

		return characterizationItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link RefOntoUML.Mediation} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MediationItemProvider mediationItemProvider;

	/**
	 * This creates an adapter for a {@link RefOntoUML.Mediation}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createMediationAdapter()
	{
		if (mediationItemProvider == null)
		{
			mediationItemProvider = new MediationItemProvider(this);
		}

		return mediationItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link RefOntoUML.Derivation} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DerivationItemProvider derivationItemProvider;

	/**
	 * This creates an adapter for a {@link RefOntoUML.Derivation}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createDerivationAdapter()
	{
		if (derivationItemProvider == null)
		{
			derivationItemProvider = new DerivationItemProvider(this);
		}

		return derivationItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link RefOntoUML.FormalAssociation} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FormalAssociationItemProvider formalAssociationItemProvider;

	/**
	 * This creates an adapter for a {@link RefOntoUML.FormalAssociation}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createFormalAssociationAdapter()
	{
		if (formalAssociationItemProvider == null)
		{
			formalAssociationItemProvider = new FormalAssociationItemProvider(this);
		}

		return formalAssociationItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link RefOntoUML.MaterialAssociation} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MaterialAssociationItemProvider materialAssociationItemProvider;

	/**
	 * This creates an adapter for a {@link RefOntoUML.MaterialAssociation}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createMaterialAssociationAdapter()
	{
		if (materialAssociationItemProvider == null)
		{
			materialAssociationItemProvider = new MaterialAssociationItemProvider(this);
		}

		return materialAssociationItemProvider;
	}

	/**
	 * This returns the root adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComposeableAdapterFactory getRootAdapterFactory()
	{
		return parentAdapterFactory == null ? this : parentAdapterFactory.getRootAdapterFactory();
	}

	/**
	 * This sets the composed adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentAdapterFactory(ComposedAdapterFactory parentAdapterFactory)
	{
		this.parentAdapterFactory = parentAdapterFactory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object type)
	{
		return supportedTypes.contains(type) || super.isFactoryForType(type);
	}

	/**
	 * This implementation substitutes the factory itself as the key for the adapter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter adapt(Notifier notifier, Object type)
	{
		return super.adapt(notifier, this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object adapt(Object object, Object type)
	{
		if (isFactoryForType(type))
		{
			Object adapter = super.adapt(object, type);
			if (!(type instanceof Class<?>) || (((Class<?>)type).isInstance(adapter)))
			{
				return adapter;
			}
		}

		return null;
	}

	/**
	 * This adds a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void addListener(INotifyChangedListener notifyChangedListener)
	{
		changeNotifier.addListener(notifyChangedListener);
	}

	/**
	 * This removes a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void removeListener(INotifyChangedListener notifyChangedListener)
	{
		changeNotifier.removeListener(notifyChangedListener);
	}

	/**
	 * This delegates to {@link #changeNotifier} and to {@link #parentAdapterFactory}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void fireNotifyChanged(Notification notification)
	{
		changeNotifier.fireNotifyChanged(notification);

		if (parentAdapterFactory != null)
		{
			parentAdapterFactory.fireNotifyChanged(notification);
		}
	}

	/**
	 * This disposes all of the item providers created by this factory. 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void dispose()
	{
		if (commentItemProvider != null) commentItemProvider.dispose();
		if (packageItemProvider != null) packageItemProvider.dispose();
		if (dependencyItemProvider != null) dependencyItemProvider.dispose();
		if (elementImportItemProvider != null) elementImportItemProvider.dispose();
		if (packageImportItemProvider != null) packageImportItemProvider.dispose();
		if (constraintxItemProvider != null) constraintxItemProvider.dispose();
		if (associationItemProvider != null) associationItemProvider.dispose();
		if (generalizationItemProvider != null) generalizationItemProvider.dispose();
		if (generalizationSetItemProvider != null) generalizationSetItemProvider.dispose();
		if (opaqueExpressionItemProvider != null) opaqueExpressionItemProvider.dispose();
		if (propertyItemProvider != null) propertyItemProvider.dispose();
		if (classItemProvider != null) classItemProvider.dispose();
		if (modelItemProvider != null) modelItemProvider.dispose();
		if (dataTypeItemProvider != null) dataTypeItemProvider.dispose();
		if (stringExpressionItemProvider != null) stringExpressionItemProvider.dispose();
		if (expressionItemProvider != null) expressionItemProvider.dispose();
		if (packageMergeItemProvider != null) packageMergeItemProvider.dispose();
		if (enumerationItemProvider != null) enumerationItemProvider.dispose();
		if (enumerationLiteralItemProvider != null) enumerationLiteralItemProvider.dispose();
		if (instanceSpecificationItemProvider != null) instanceSpecificationItemProvider.dispose();
		if (slotItemProvider != null) slotItemProvider.dispose();
		if (primitiveTypeItemProvider != null) primitiveTypeItemProvider.dispose();
		if (literalIntegerItemProvider != null) literalIntegerItemProvider.dispose();
		if (literalStringItemProvider != null) literalStringItemProvider.dispose();
		if (literalBooleanItemProvider != null) literalBooleanItemProvider.dispose();
		if (literalNullItemProvider != null) literalNullItemProvider.dispose();
		if (instanceValueItemProvider != null) instanceValueItemProvider.dispose();
		if (literalUnlimitedNaturalItemProvider != null) literalUnlimitedNaturalItemProvider.dispose();
		if (subKindItemProvider != null) subKindItemProvider.dispose();
		if (kindItemProvider != null) kindItemProvider.dispose();
		if (quantityItemProvider != null) quantityItemProvider.dispose();
		if (collectiveItemProvider != null) collectiveItemProvider.dispose();
		if (phaseItemProvider != null) phaseItemProvider.dispose();
		if (roleItemProvider != null) roleItemProvider.dispose();
		if (categoryItemProvider != null) categoryItemProvider.dispose();
		if (roleMixinItemProvider != null) roleMixinItemProvider.dispose();
		if (mixinItemProvider != null) mixinItemProvider.dispose();
		if (modeItemProvider != null) modeItemProvider.dispose();
		if (qualityItemProvider != null) qualityItemProvider.dispose();
		if (relatorItemProvider != null) relatorItemProvider.dispose();
		if (subQuantityOfItemProvider != null) subQuantityOfItemProvider.dispose();
		if (subCollectionOfItemProvider != null) subCollectionOfItemProvider.dispose();
		if (memberOfItemProvider != null) memberOfItemProvider.dispose();
		if (componentOfItemProvider != null) componentOfItemProvider.dispose();
		if (characterizationItemProvider != null) characterizationItemProvider.dispose();
		if (mediationItemProvider != null) mediationItemProvider.dispose();
		if (derivationItemProvider != null) derivationItemProvider.dispose();
		if (formalAssociationItemProvider != null) formalAssociationItemProvider.dispose();
		if (materialAssociationItemProvider != null) materialAssociationItemProvider.dispose();
	}

}
