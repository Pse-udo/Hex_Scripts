package swamptarlooter;

import java.awt.Graphics;

import org.hexbot.api.input.Mouse;
import org.hexbot.api.input.Mouse.Speed;
import org.hexbot.api.listeners.Paintable;
import org.hexbot.api.methods.Game;
import org.hexbot.api.util.Random;
import org.hexbot.api.util.Timer;
import org.hexbot.script.Manifest;
import org.hexbot.script.Script;

import seagullslayer.resources.util.Paint;
import swamptarlooter.node.Loot;
import swamptarlooter.resources.Node;

@Manifest(author = "Applet", name = "Swamp Tar Looter", description = "Loots swamp tar for profit", version = 0.1)
public class SwampTarLooter extends Script implements Paintable {

	private static final Node[] jobs = {new Loot()};
	public static Timer runTime = new Timer(0);

	@Override
	public void paint(Graphics g) {
		if (Game.isLoggedIn()) {
			Paint.drawPaint(g);
		}
	}

	@Override
	public int loop() {
		for (Node job : jobs) {
			if(job.activate()) {
				job.execute();
				return Random.nextInt(50, 150);
			}
		}
		return 50;
	}

	@Override
	public void onEnd() {
		log("Thanks for using the script. Please report any bugs on the thread!");
	}

	@Override
	public void onStart() {
		Mouse.setSpeed(Speed.FAST);
	}

}
