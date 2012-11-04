package br.ufes.inf.nemo.ontouml.transformation.onto2info.ui.tab;

import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

import br.ufes.inf.nemo.ontouml.refontouml.util.RefOntoUMLModelAbstraction;
import br.ufes.inf.nemo.ontouml.transformation.onto2info.decision.DecisionHandler;
import br.ufes.inf.nemo.ontouml.transformation.onto2info.ui.BooleanCellEditor;
import br.ufes.inf.nemo.ontouml.transformation.onto2info.ui.EmulatedNativeCheckBoxLabelProvider;
import br.ufes.inf.nemo.ontouml.transformation.onto2info.ui.content.SimpleContentProvider;
import br.ufes.inf.nemo.ontouml.transformation.onto2info.ui.content.HistoryTimeModel;

public class HistoryTrackingTab extends TrackingTab
{	
	public String getName()
	{
		return "History Tracking";
	}
	
	public Control getControl(Composite parent, RefOntoUMLModelAbstraction ma, final DecisionHandler dh)
	{
		return treeViewerHistory(parent, ma, dh).getTree();
	}
	
	public TreeViewer treeViewerHistory (final Composite parent, RefOntoUMLModelAbstraction ma, final DecisionHandler dh)
	{
		final TreeViewer viewer = treeViewerHistoryAndTime (parent, ma, dh);
		
		// BooleanCellEditor is a custom class created by a guy in JFace Snippets
		final BooleanCellEditor booleanCellEditor = new BooleanCellEditor(viewer.getTree());
		booleanCellEditor.setChangeOnActivation(true);
		
		// Column 2 (Past)
		TreeViewerColumn column = new TreeViewerColumn(viewer, SWT.CENTER);
		column.getColumn().setWidth(200);
		column.getColumn().setMoveable(true);
		column.getColumn().setText("Past");
		column.setLabelProvider(new EmulatedNativeCheckBoxLabelProvider(viewer)
		{
			protected boolean isChecked(Object element)
			{
				//System.out.println(((RefOntoUML.Class)element).getName());
				return dh.getHTPastDecision((RefOntoUML.Class)element);
			}
		});
		column.setEditingSupport(new EditingSupport(viewer)
		{
			protected boolean canEdit(Object element)
			{
				return true;
			}

			protected CellEditor getCellEditor(Object element)
			{
				return booleanCellEditor;
			}

			protected Object getValue(Object element)
			{
				//System.out.println("getValue(" + ((RefOntoUML.Class)element).getName() + ")");
				return new Boolean(dh.getHTPastDecision((RefOntoUML.Class)element));
			}

			protected void setValue(Object element, Object value)
			{
				dh.setHTPastDecision((RefOntoUML.Class)element, ((Boolean) value).booleanValue());
				viewer.update(element, null);
			}
		});
		
		// Column 3 (Present)
		column = new TreeViewerColumn(viewer, SWT.CENTER);
		column.getColumn().setWidth(200);
		column.getColumn().setMoveable(true);
		column.getColumn().setText("Present");
		column.setLabelProvider(new EmulatedNativeCheckBoxLabelProvider(viewer)
		{
			protected boolean isChecked(Object element)
			{
				//System.out.println(((RefOntoUML.Class)element).getName());
				return dh.getHTPresentDecision((RefOntoUML.Class)element);
			}
		});
		column.setEditingSupport(new EditingSupport(viewer)
		{
			protected boolean canEdit(Object element)
			{
				return true;
			}

			protected CellEditor getCellEditor(Object element)
			{
				return booleanCellEditor;
			}

			protected Object getValue(Object element)
			{
				//System.out.println("getValue(" + ((RefOntoUML.Class)element).getName() + ")");
				return new Boolean(dh.getHTPresentDecision((RefOntoUML.Class)element));
			}

			protected void setValue(Object element, Object value)
			{
				dh.setHTPresentDecision((RefOntoUML.Class)element, ((Boolean) value).booleanValue());
				viewer.update(element, null);
			}
		});
		
		// ContentProvider and Input
		viewer.setContentProvider(new SimpleContentProvider());
		viewer.setInput((new HistoryTimeModel(ma)).model);
		
		return viewer;
	}
}