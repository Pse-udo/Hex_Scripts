package tutorialpackage;

import org.hexbot.api.methods.Bank;
import org.hexbot.api.methods.Inventory;
import org.hexbot.api.util.Time;
import org.hexbot.api.util.Timer;

public class ExampleBanking extends Node {

	private final int JUNK = 666;

	@Override
	public boolean activate() {
		return Inventory.isFull() && Bank.isOpen(); //The node will only activate the players inventory is full and the bank is open
	}

	@Override
	public void execute() {
		if (Inventory.contains(JUNK)) {
			if (Bank.deposit(JUNK, 0)) {
				Timer t = new Timer(3000); //Fail safe timer for dynamic sleep
				while (t.isRunning() && Inventory.contains(JUNK)) { //While the timer is running, and the junk still exists inside the inventory, sleep. (Stops spamming of the 'junk).
					Time.sleep(50, 150);
				}
				Bank.close(); //If the junk has deposited successfully (and the while loop has been exited) close the bank.
			}
		}
	}

}
