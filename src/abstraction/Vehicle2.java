package abstraction;

public interface Vehicle2 {
    default void start(){
        System.out.println("v2");
    }
}
