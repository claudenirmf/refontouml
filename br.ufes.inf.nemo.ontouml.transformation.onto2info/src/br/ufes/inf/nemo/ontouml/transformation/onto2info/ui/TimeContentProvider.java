package br.ufes.inf.nemo.ontouml.transformation.onto2info.ui;

import java.util.List;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

public class TimeContentProvider implements ITreeContentProvider
{

	@Override
	public Object[] getChildren(Object parentElement)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getParent(Object element)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasChildren(Object element)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object[] getElements(Object inputElement)
	{
		// TODO Auto-generated method stub
		return ((List)inputElement).toArray();
	}

	@Override
	public void dispose()
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput)
	{
		// TODO Auto-generated method stub

	}

}
