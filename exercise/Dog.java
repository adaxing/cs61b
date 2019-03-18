public class Dog {
	/** instance variable */
	public int weightInPounds;

	/** constuctor */
	public Dog(int w) {
		weightInPounds = w;
	}

	/** instance method */
	public void makeNoise() {
		if (weightInPounds < 10) {
			System.out.println("yipyip!!");
		} else if (weightInPounds < 30) {
			System.out.println("bark. bark. ");
		} else {
			System.out.println("woof!");
		}
	}

	/** static method */
	public static Dog maxDog(Dog d1, Dog d2) {
		if (d1.weightInPounds > d2.weightInPounds) {
			return d1;
		} 
		return d2;
	}
}