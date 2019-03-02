package Animals;

import java.util.ArrayList;
import java.util.List;

public class RabotajemRabotu {

	public static void main(String[] args) {
		delajemDelo();
	}

	public static void delajemDelo() {
		List<Animal> animalsList = new ArrayList<Animal>();

		Cat cat = new Cat();
		Chicken chicken = new Chicken();
		Sorokonojka sorokonojka = new Sorokonojka();
		animalsList.add(cat);
		animalsList.add(chicken);
		animalsList.add(sorokonojka);

		for (Animal animal : animalsList) {
			if (animal instanceof Cat) {
				Cat cat1 = (Cat) animal;
				animal.numberOfLegs();
			}
		}
	}
}
