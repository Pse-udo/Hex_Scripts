package tutorialpackage;

import org.hexbot.api.util.Random;
import org.hexbot.script.Manifest;
import org.hexbot.script.Script;

@Manifest(author = "", name = "", description = "", version = 0.1)
public class Skeleton extends Script {

	private static final Node[] jobs = {new ExampleBanking()};

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
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart() {
		// TODO Auto-generated method stub

	}

}
