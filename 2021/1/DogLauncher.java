public class DogLauncher {
    public static void main(String[] args) {
        Dog d;
        d = new Dog(5);
        System.out.println("Launch demo: small dog bark");
        d.makeNoise();
        Dog[] dogs = new Dog[2];
        dogs[0] = new Dog(8);
        dogs[1] = new Dog(20);
        System.out.println("Array demo: dogs[1] medium dog bark" );
        dogs[1].makeNoise();
        Dog d2 = new Dog(90);
        System.out.println("maxDog non-static method demo: return large dog" );
        d.maxDog(d2).makeNoise();
        Dog d3 = new Dog(1);
        Dog d4 = new Dog(15);
        System.out.println("maxDog static method demo: return medium dog" );
        Dog.maxDog(d3, d4).makeNoise();
        System.out.println("static variable demo: access using class name" );
        System.out.println(Dog.binomen);
        System.out.println("Command Line Argument demo: its array of string" );
        System.out.println(args[0]);
    }
}