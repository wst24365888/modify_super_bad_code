package Pack;

import java.awt.Point;

public class DragPack
{
	Point	from	= new Point(0, 0);
	Object	fromObj;
	Point	to		= new Point(0, 0);
	Object	toObj;

	public DragPack(Point from, Point to)
	{
		this.from = from;
		this.to = to;
	}

	public Object getFromObj()
	{
		return fromObj;
	}

	public void setFromObj(Object fromObj)
	{
		this.fromObj = fromObj;
	}

	public Object getToObj()
	{
		return toObj;
	}

	public void setToObj(Object toObj)
	{
		this.toObj = toObj;
	}

	public Point getFrom()
	{
		return from;
	}

	public void setFrom(Point from)
	{
		this.from = from;
	}

	public Point getTo()
	{
		return to;
	}

	public void setTo(Point to)
	{
		this.to = to;
	}
}
