package abstraction;

public class vehicle4 implements vehicle3, Vehicle2 {
    @Override
    public void start() {
        vehicle3.super.start();
    }

    public static void main(String[] args) {
        vehicle4 gaadi = new vehicle4();
        System.out.println(gaadi);
        gaadi.start();
    }

//    @Override
//    public void start() {
//        vehicle3.super.start();
//    }
}
