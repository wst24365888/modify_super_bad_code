package bgWork;

import javax.swing.JPanel;

import Pack.SendText;
import Pack.TextRequest;
import bgWork.handler.MenuBarHandler;
import mod.instance.AssociationLine;
import mod.instance.BasicClass;
import mod.instance.CompositionLine;
import mod.instance.GeneralizationLine;
import mod.instance.GroupContainer;
import mod.instance.UseCase;

public class Core extends InitProcess
{
	public Core(CoreMgr cm)
	{
		super(cm);
	}

	public JPanel getCurrentFunc()
	{
		return getFuncPanelHandler().getCurrentFunc();
	}

	public int getCurrentFuncIndex()
	{
		return getFuncPanelHandler().getCurrentFuncIndex();
	}

	public void callMsgBox(TextRequest tr)
	{
		if (tr.getSrc() instanceof MenuBarHandler)
		{
			if (getCanvasPanelHandler().getSingleSelectJP() != null)
			{
				tr.setSrc(getCanvasPanelHandler().getSingleSelectJP());
				msgBoxHandler.callBox(tr);
			}
		}
	}

	public void msgBoxCallBack(Package tr)
	{
	}

	public void msgBoxCallBack(SendText tr)
	{
		this.getCanvasPanelHandler().setContext(tr);
	}

	public void setGroup()
	{
		getCanvasPanelHandler().setGroup();
	}

	public void setUngroup()
	{
		getCanvasPanelHandler().setUngroup();
	}

	public boolean isBasicClass(Object obj)
	{
		return obj instanceof BasicClass;
	}

	public boolean isUseCase(Object obj)
	{
		return obj instanceof UseCase;
	}

	public int isClass(Object obj)
	{
		if (isBasicClass(obj))
		{
			return 0;
		}
		else if (isUseCase(obj))
		{
			return 1;
		}
		return -1;
	}

	public boolean isAssociationLine(Object obj)
	{
		return obj instanceof AssociationLine;
	}

	public boolean isCompositionLine(Object obj)
	{
		return obj instanceof CompositionLine;
	}

	public boolean isGeneralizationLine(Object obj)
	{
		return obj instanceof GeneralizationLine;
	}

	public int isLine(Object obj)
	{
		if (isAssociationLine(obj))
		{
			return 0;
		}
		else if (isCompositionLine(obj))
		{
			return 1;
		}
		else if (isGeneralizationLine(obj))
		{
			return 2;
		}
		return -1;
	}

	public boolean isGroupContainer(Object obj)
	{
		return obj instanceof GroupContainer;
	}

	public int isFuncComponent(Object obj)
	{
		if (isBasicClass(obj))
		{
			return 0;
		}
		else if (isUseCase(obj))
		{
			return 1;
		}
		else if (isAssociationLine(obj))
		{
			return 2;
		}
		else if (isCompositionLine(obj))
		{
			return 3;
		}
		else if (isGeneralizationLine(obj))
		{
			return 4;
		}
		else if (isGroupContainer(obj))
		{
			return 5;
		}
		return -1;
	}
}
