
public class ObjectManager {

	Rocketship rocket;
	
	ObjectManager(Rocketship rocket) {
		rocket = new Rocketship(0, 0, 0, 0);
	}

	void update() {
		rocket.update();
	}
}
