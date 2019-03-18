public class DogLauncher {
	public static void main(String[] args) {
		Dog d1 = new Dog(25);
		Dog d2 = new Dog(50);
		Dog.maxDog(d1, d2).makeNoise();
	}
}