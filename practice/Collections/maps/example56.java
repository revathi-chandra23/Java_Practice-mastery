import java.util.HashMap;
import java.util.Map;

public class example56 {
    static class CollidingKey {
        private final String name;

        CollidingKey(String name) {
            this.name = name;
        }

        @Override
        public int hashCode() {
            // Force a collision by returning the same hash for every key
            return 42;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            CollidingKey other = (CollidingKey) obj;
            return name.equals(other.name);
        }

        @Override
        public String toString() {
            return "Key(" + name + ")";
        }
    }

    public static void main(String[] args) {
        Map<CollidingKey, String> map = new HashMap<>();

        map.put(new CollidingKey("A"), "Apple");
        map.put(new CollidingKey("B"), "Banana");
        map.put(new CollidingKey("C"), "Cherry");

        System.out.println("Map size: " + map.size());
        for (Map.Entry<CollidingKey, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        System.out.println("Lookup key B: " + map.get(new CollidingKey("B")));
    }
}
