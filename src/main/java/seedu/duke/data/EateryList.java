package seedu.duke.data;

import seedu.duke.exception.InvalidIndexException;
import seedu.duke.router.Router;

import java.util.LinkedList;

public class EateryList {
    private Block[] eateries;

    public EateryList(NusMap nusMap, String from) {
        this.eateries = new Block[6];
        setRouteLengths(nusMap, from);
        setEateries(nusMap);
    }

    public Block[] getEateries() {
        return eateries;
    }

    public Block getSpecificEatery(int index) throws InvalidIndexException {
        if (index > 6 || index < 0) {
            throw new InvalidIndexException();
        } else {
            return eateries[index];
        }
    }

    public void setRouteLengths(NusMap nusMap, String from) {
        new Router().findShortestRoute(nusMap, new LinkedList<>(), from, "TECHNO EDGE CANTEEN");
        new Router().findShortestRoute(nusMap, new LinkedList<>(), from, "CHEERS MINIMART");
        new Router().findShortestRoute(nusMap, new LinkedList<>(), from, "ARISE & SHINE");
        new Router().findShortestRoute(nusMap, new LinkedList<>(), from, "PLATYPUS FOOD BAR");
        new Router().findShortestRoute(nusMap, new LinkedList<>(), from, "SPINELLI COFFEE");
        new Router().findShortestRoute(nusMap, new LinkedList<>(), from, "MAXX COFFEE");
    }

    public void setEateries(NusMap nusMap) {
        eateries[0] = nusMap.getBlock("TECHNO EDGE CANTEEN");
        eateries[1] = nusMap.getBlock("CHEERS MINIMART");
        eateries[2] = nusMap.getBlock("ARISE & SHINE");
        eateries[3] = nusMap.getBlock("PLATYPUS FOOD BAR");
        eateries[4] = nusMap.getBlock("SPINELLI COFFEE");
        eateries[5] = nusMap.getBlock("MAXX COFFEE");
    }

    public void sortEateriesByDistance() {
        for (int i = 0; i < eateries.length - 1; i++) {
            for (int j = 0; j < eateries.length - 1 - i; j++) {
                if (eateries[j].getDistanceFromStart() > eateries[j + 1].getDistanceFromStart()) {
                    Block temp = eateries[j];
                    eateries[j] = eateries[j + 1];
                    eateries[j + 1] = temp;
                }
            }
        }
    }
}
