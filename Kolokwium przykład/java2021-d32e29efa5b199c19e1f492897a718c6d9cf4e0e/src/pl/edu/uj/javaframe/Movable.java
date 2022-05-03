package pl.edu.uj.javaframe;

public interface Movable {
    void MoveTo(Possition possition, World world) throws OutsideTheWorldException;
    void MoveBack() throws OutsideTheWorldException;
}
