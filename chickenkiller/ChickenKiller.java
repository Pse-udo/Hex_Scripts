package chickenkiller;

import java.awt.Graphics;

import org.hexbot.api.input.Mouse;
import org.hexbot.api.input.Mouse.Speed;
import org.hexbot.api.listeners.Paintable;
import org.hexbot.api.methods.Walking;
import org.hexbot.api.util.Random;
import org.hexbot.api.util.Timer;
import org.hexbot.api.wrapper.Tile;
import org.hexbot.script.Manifest;
import org.hexbot.script.Script;

import chickenkiller.node.Attack;
import chickenkiller.resources.Node;
import chickenkiller.resources.util.Paint;

@Manifest(author = "Applet", name = "Chicken Killer", description = "Kills chickens", version = 0.1)
public class ChickenKiller extends Script implements Paintable {

	private static final Node[] jobs = {new Attack()};
	public static Timer runTime = new Timer(0);

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
		log("Thanks for using the script");

	}

	@Override
	public void onStart() {
		Mouse.setSpeed(Speed.FAST);
	}

	@Override
	public void paint(Graphics g) {
		Paint.drawPaint(g);	
	}

}