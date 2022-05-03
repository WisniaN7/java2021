package pl.edu.uj.javaframe;

import java.util.ArrayList;

public class Robot implements Movable {
    private ArrayList<Possition> history = new ArrayList<>();

    public Robot(Possition possition, World world) throws OutsideTheWorldException {
        if (possition.getX() > world.getSizeX() || possition.getY() > world.getSizeY()) throw new OutsideTheWorldException("Robot appeared outside the edge and fell out of the world");
        history.add(possition);
    }

    @Override
    public void MoveTo(Possition possition, World world) throws OutsideTheWorldException {
        if (possition.getX() > world.getSizeX() || possition.getY() > world.getSizeY()) throw new OutsideTheWorldException("Robot stepped outside the edge and fell out of the world");
        history.add(possition);
    }

    @Override
    public void MoveBack() throws OutsideTheWorldException {
        if (history.size() == 1) throw new OutsideTheWorldException("Robot tried stepping back in time out of the existence");
        history.remove(history.size() - 1);
    }
    public Possition getPossition() { return history.get(history.size() - 1); }
}
