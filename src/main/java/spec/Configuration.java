package spec;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Configuration {
    private long maxsize;
    private List<String> forbidden = new ArrayList<>();
    private int maxcount;


    public Configuration(long maxsize, List<String> forbidden, int maxcount) {
        this.maxsize = maxsize;
        this.forbidden = forbidden;
        this.maxcount = maxcount;
    }

    public Configuration(long maxsize, String forbidden, int maxcount) {
        this.maxsize = maxsize;
        this.maxcount = maxcount;
        String[] split = forbidden.split(",");
        this.forbidden.addAll(Arrays.asList(split));
    }

    @Override
    public String toString() {
        return  "maxsize=" + maxsize +
                "\n forbidden=" + forbidden +
                "\n maxcount=" + maxcount;
    }
}
