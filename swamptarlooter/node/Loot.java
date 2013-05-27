package swamptarlooter.node;

import org.hexbot.api.methods.Calculations;
import org.hexbot.api.methods.Camera;
import org.hexbot.api.methods.GroundItems;
import org.hexbot.api.methods.Players;
import org.hexbot.api.util.Time;
import org.hexbot.api.wrapper.GroundItem;
import org.hexbot.api.wrapper.Tile;

import swamptarlooter.resources.Node;

public class Loot extends Node {

	private final int TAR = 1939;

	@Override
	public boolean activate() {
		return true;
	}

	@Override
	public void execute() {
		GroundItem tar = GroundItems.getNearest(TAR);
		Tile loc = tar.getLocation();
		while (Players.getLocal().isMoving()) {
			Time.sleep(50, 120);
		}
		if (tar != null) {
			if (Calculations.tileToScreen(loc) != null) {
				if (tar.interact("Take")) {
					Time.sleep(500, 1200);
				} else {
					if (Calculations.distanceBetween(Players.getLocal().getLocation(), loc) >= 8) {
						Camera.turnTo(tar);
					}
				}
			}
		}

	}

}
