package mod;

import java.awt.Graphics;
import java.awt.Point;

import Pack.DragPack;

public interface ILinePainter
{
	void paintArrow(Graphics g, Point point);

	public void setConnect(DragPack dPack);

	void paintSelect(Graphics gra);
}
