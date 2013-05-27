package chickenkiller.resources.util;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import org.hexbot.api.input.Mouse;

import chickenkiller.ChickenKiller;

public class Paint {
	
	public static void drawMouse(Graphics g) {
		g.setColor(Mouse.isPressed() ? Color.RED : Color.GREEN);
		final Point m = Mouse.getLocation();
		g.drawLine(m.x -5, m.y + 5, m.x + 5, m.y - 5);
		g.drawLine(m.x -5, m.y - 5, m.x + 5, m.y + 5);		
	}
	
	public static void drawPaint(Graphics g) {
		drawMouse(g);
		g.setColor(Color.WHITE);
		g.drawString("Time Running: "+Time.format(ChickenKiller.runTime.getElapsed()), 20, 50);
	}

}
