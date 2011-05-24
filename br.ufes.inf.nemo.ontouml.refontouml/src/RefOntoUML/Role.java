/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package RefOntoUML;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Role</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see RefOntoUML.RefOntoUMLPackage#getRole()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='RoleConstraint2'"
 *        annotation="http://www.eclipse.org/ocl/examples/OCL RoleConstraint2='Mediation.allInstances()->exists( x | allParents()->including(self)->includes(x.mediated()) )'"
 *        annotation="Comments RoleConstraint2='A Role must be connected (directly or indirectly) to a Mediation'"
 * @generated
 */
public interface Role extends AntiRigidSortalClass
{
} // Role
