package creatures;

import edu.princeton.cs.algs4.StdRandom;
import huglife.Action;
import huglife.Creature;
import huglife.Direction;
import huglife.Occupant;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Clorus extends Creature {

    public Clorus(double e) {
        super("clorus");
        energy = e;
    }

    public Clorus() {
        this(1);
    }

    public void move() {
        energy -= 0.03;
        energy = Math.min(0.0, energy);
    }

    public void attack(Creature c) {
        energy += c.energy();
    }

    public void stay() {
        energy -= 0.01;
        energy = Math.min(0.0, energy);
    }

    public Color color() {
        return new Color(34, 0, 231);
    }
    public Creature replicate() {
        double halfEnergy = energy * 0.5;
        energy = halfEnergy;
        return new Clorus(halfEnergy);
    }

    public Action chooseAction(Map<Direction, Occupant> neighbors) {
        List<Direction> emptyNeighbors = new ArrayList<>();
        List<Direction> plipNeighbors = new ArrayList<>();

        for (Map.Entry<Direction, Occupant> neighbor: neighbors.entrySet()) {
            if (neighbors.get(neighbor.getKey()).name().equals("empty")) {
                emptyNeighbors.add(neighbor.getKey());
            } else if (neighbors.get(neighbor.getKey()).name().equals("plip")) {
                plipNeighbors.add(neighbor.getKey());
            }
        }

        if (emptyNeighbors.isEmpty()) {
            return new Action(Action.ActionType.STAY);
        }
        if (!plipNeighbors.isEmpty()) {
            return new Action(Action.ActionType.ATTACK,
                    plipNeighbors.get(StdRandom.uniform(plipNeighbors.size())));
        }
        if (energy >= 1) {
            return new Action(Action.ActionType.REPLICATE,
                    emptyNeighbors.get(StdRandom.uniform(emptyNeighbors.size())));
        }
        return new Action(Action.ActionType.MOVE,
                emptyNeighbors.get(StdRandom.uniform(emptyNeighbors.size())));

    }

}
