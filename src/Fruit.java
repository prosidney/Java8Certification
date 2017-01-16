/**
 * Created by admin on 16/01/17.
 */
public class Fruit {
    private String name;
    private Integer weight;

    public Fruit(String name, Integer weight){
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }
}
