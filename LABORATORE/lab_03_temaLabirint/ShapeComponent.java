package lab_03_temaLabirint;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Shape;
import javax.swing.JComponent;

public class ShapeComponent extends JComponent
{
	private Shape shape;
	private boolean antiAliasing = true;

	public ShapeComponent(Shape shape)
	{
		this(shape, Color.BLACK);
        }
        
	public ShapeComponent(Shape shape, Color color)
	{
		setShape( shape );
		setForeground( color );

		setOpaque( false );
	}

	public Shape getShape()
	{
		return shape;
	}

	public void setShape(Shape shape)
	{
		this.shape = shape;
		revalidate();
		repaint();
	}

	public boolean isAntiAliasing()
	{
		return antiAliasing;
	}

	public void setAntiAliasing(boolean antiAliasing)
	{
		this.antiAliasing = antiAliasing;
		revalidate();
		repaint();
	}

	@Override
	public Dimension getPreferredSize()
	{
		Insets insets = getInsets();
		Rectangle bounds = shape.getBounds();

		int width = insets.left + insets.right + bounds.width;
		int height = insets.top + insets.bottom + bounds.height;

		return new Dimension(width, height);
        }
        
	@Override
	public Dimension getMinimumSize()
	{
		return getPreferredSize();
	}
        
	@Override
	public Dimension getMaximumSize()
	{
		return getPreferredSize();
	}

	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);


		Graphics2D g2d = (Graphics2D)g.create();

		if (isAntiAliasing())
	        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		Rectangle bounds = shape.getBounds();
		Insets insets = getInsets();

		g2d.translate(insets.left - bounds.x, insets.top - bounds.y);

		g2d.fill( shape );

		g2d.dispose();
	}
        
	@Override
	public boolean contains(int x, int y)
	{
		Rectangle bounds = shape.getBounds();
		Insets insets = getInsets();

		int translateX = x + bounds.x - insets.left;
		int translateY = y + bounds.y - insets.top;

		return shape.contains(translateX, translateY);
	}
}
