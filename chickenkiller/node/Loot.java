package chickenkiller.node;

import org.hexbot.api.methods.Calculations;
import org.hexbot.api.methods.Camera;
import org.hexbot.api.methods.GroundItems;
import org.hexbot.api.methods.Players;
import org.hexbot.api.util.Time;
import org.hexbot.api.util.Timer;
import org.hexbot.api.wrapper.GroundItem;

import chickenkiller.resources.Node;

public class Loot extends Node {

	private final int FEATHER = 315;

	@Override
	public boolean activate() {
		return true;
	}

	@Override
	public void execute() {
		GroundItem g = GroundItems.getNearest(FEATHER);
		Timer t = new Timer(3000);
		while (t.isRunning() && Calculations.tileToScreen(g.getLocation()) != null && Players.getLocal().isMoving()) {
			Time.sleep(50, 150);
		}
		if (Calculations.tileToScreen(g.getLocation()) != null) {
			if (g.interact("Take")) {
				Time.sleep(400, 700);
			} else {

			}
			Camera.turnTo(g);
		}
	}

}

