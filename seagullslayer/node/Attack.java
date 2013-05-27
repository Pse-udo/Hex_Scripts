package seagullslayer.node;

import org.hexbot.api.methods.Calculations;
import org.hexbot.api.methods.Camera;
import org.hexbot.api.methods.Npcs;
import org.hexbot.api.methods.Players;
import org.hexbot.api.util.Filter;
import org.hexbot.api.util.Time;
import org.hexbot.api.wrapper.Npc;

import seagullslayer.resources.Node;

public class Attack extends Node {

	private final int[] SEAGULL = {6115, 6116};
	private final int DYING = 1015;

	@Override
	public boolean activate() {
		return Players.getLocal().getInteracting() == null;
	}

	@Override
	public void execute() {
		final Npc seagull = Npcs.getNearest(new Filter<Npc>() {
			@Override
			public boolean accept(Npc seagull) {
				for(int seagullId : SEAGULL) {
					if(seagull.getId() == seagullId && seagull.getInteracting() == null) {
						return true;
					}
				}
				return false;
			}
		});
		if (seagull != null) {
			if (Calculations.onScreen(seagull.getLocation().getScreenLocation()) && seagull.getAnimation() != DYING) {
				if (seagull.interact("Attack")) {
					Time.sleep(600, 1100);
				} else {

				}
				Camera.turnTo(seagull);
			}
		}

	}
}
