package chickenkiller.node;

import org.hexbot.api.methods.Calculations;
import org.hexbot.api.methods.Camera;
import org.hexbot.api.methods.Menu;
import org.hexbot.api.methods.Npcs;
import org.hexbot.api.methods.Players;
import org.hexbot.api.util.Filter;
import org.hexbot.api.util.Time;
import org.hexbot.api.wrapper.Npc;

import chickenkiller.resources.Node;

public class Attack extends Node {

	public static final int[] CHICKEN = {41, 1017};
	private final int DYING = 5389;

	@Override
	public boolean activate() {
		return Players.getLocal().getInteracting() == null;
	}

	@Override
	public void execute() {
		if (Menu.isMenuOpen()) {
			Menu.click("Cancel");
			Time.sleep(200, 400);
		}
		final Npc chicken = Npcs.getNearest(new Filter<Npc>() {
			@Override
			public boolean accept(Npc chicken) {
				for(int chickenId : CHICKEN) {
					if(chicken.getId() == chickenId && chicken.getInteracting() == null) {
						return true;
					}
				}
				return false;
			}
		});
		if (chicken.getInteracting() != null) {
			System.out.println(chicken.getAnimation());
		}
		if (chicken != null) {
			if (Calculations.onScreen(chicken.getLocation().getScreenLocation()) && chicken.getAnimation() != DYING) {
				if (chicken.interact("Attack")) {
					Time.sleep(600, 1100);
				} else {

				}
				Camera.turnTo(chicken);
			}
		}
	}

}
