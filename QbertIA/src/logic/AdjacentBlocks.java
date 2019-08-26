package logic;

import it.unical.mat.embasp.languages.Id;
import it.unical.mat.embasp.languages.Param;

@Id("isAdjacent")
public class AdjacentBlocks {

    @Param(0)
    private int firstBlockIndex;
    @Param(1)
    private int secondBlockIndex;
    @Param(2)
    private String adjacentPosition;

    public AdjacentBlocks(int first, int second, String position){
        firstBlockIndex = first;
        secondBlockIndex = second;
        adjacentPosition = position;
    }

    public AdjacentBlocks(){}

    public int getFirstBlockIndex() {
        return firstBlockIndex;
    }

    public void setFirstBlockIndex(int firstBlockIndex) {
        this.firstBlockIndex = firstBlockIndex;
    }

    public int getSecondBlockIndex() {
        return secondBlockIndex;
    }

    public void setSecondBlockIndex(int secondBlockIndex) {
        this.secondBlockIndex = secondBlockIndex;
    }

    public String getAdjacentPosition() {
        return adjacentPosition;
    }

    public void setAdjacentPosition(String adjacentPosition) {
        this.adjacentPosition = adjacentPosition;
    }

    @Override
    public String toString() {
        return "isAdjacent(" + firstBlockIndex + ", " + secondBlockIndex + ", " + adjacentPosition + ").";
    }
}
