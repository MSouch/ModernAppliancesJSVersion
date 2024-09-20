package ModernAppliances;

import ModernAppliances.Entities.Abstract.Appliance;
import java.util.Comparator;
import java.util.Random;

public class RandomComparer implements Comparator<Appliance> {
    private final Random random = new Random();

    @Override
    public int compare(Appliance x, Appliance y) {
        if (x.equals(y)) {
            return 0;
        }

        return random.nextInt(2) - 1; 
    }
}
