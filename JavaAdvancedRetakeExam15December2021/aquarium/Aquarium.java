package aquarium;

import java.util.ArrayList;
import java.util.List;

public class Aquarium {

    private List<Fish> fishInPool;
    private String name;
    private int capacity;
    private int size;

    public Aquarium(String name, int capacity, int size) {
        this.name = name;
        this.capacity = capacity;
        this.size = size;
        this.fishInPool = new ArrayList<>();
    }

    public int getFishInPool() {
        return fishInPool.size();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getSize() {
        return size;
    }

    public void add(Fish fish) {

        boolean isFishWithThatName = false;

        for (Fish fish1 : fishInPool) {
            if (fish1.getName().equals(fish.getName())) {
                isFishWithThatName = true;
                break;
            }
        }

        if (fishInPool.size() < capacity && !isFishWithThatName) {

            fishInPool.add(fish);

        }
    }

    public boolean remove(String name) {
        for (Fish fish : fishInPool) {
            if (fish.getName().equals(name)) {
                fishInPool.remove(fish);
                return true;
            }
        }
        return false;
    }

    public Fish findFish(String name) {
        for (Fish fish : fishInPool) {
            if (fish.getName().equals(name)) {
                return fish;
            }
        }
        return null;
    }

    public String report() {

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Aquarium: %s ^ Size: %d", name, size));
        fishInPool.forEach(f -> sb.append(System.lineSeparator()).append(f.toString()));
        return sb.toString();

    }
}
