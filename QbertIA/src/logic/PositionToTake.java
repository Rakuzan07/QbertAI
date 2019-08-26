package logic;

import it.unical.mat.embasp.languages.Id;
import it.unical.mat.embasp.languages.Param;

@Id("positionToTake")
public class PositionToTake {
    @Param(0)
    private String position;

    public PositionToTake(String position){
        this.position = position;
    }

    public PositionToTake(){}

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return ""+position+"";
    }
}
