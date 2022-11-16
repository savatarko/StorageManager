package spec;

import lombok.Getter;

import java.util.*;

@Getter


public class Configuration {
    private long maxsize;
    private List<String> forbidden = new ArrayList<>();
    private Map<String, Integer> pathlimit;


    public Configuration(long maxsize, List<String> forbidden) {
        this.maxsize = maxsize;
        this.forbidden = forbidden;
        pathlimit = new HashMap<>();
    }

    public Configuration(long maxsize, String forbidden) {
        this.maxsize = maxsize;
        String[] split = forbidden.split(",");
        this.forbidden.addAll(Arrays.asList(split));
        pathlimit = new HashMap<>();
    }

    @Override
    public String toString() {
        String map = "";
        for(var i : pathlimit.keySet()){
            map = map.concat("\n" + i + "|" + pathlimit.get(i));
        }
        return  "maxsize=" + maxsize +
                "\nforbidden=" + forbidden +
                  map;
    }
}
