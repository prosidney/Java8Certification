import java.util.function.BiFunction;

/**
 * Created by admin on 16/01/17.
 */
public class Lambda {
    public static void main(String args[]){
        BiFunction<String, Integer, Fruit> c3 = Fruit::new;

        final Fruit apple1 = c3.apply("Apple1", 280);

        System.out.println(apple1.getName());
        System.out.println(apple1.getWeight());
    }
}
