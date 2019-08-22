package logic;

import it.unical.mat.embasp.languages.Id;
import it.unical.mat.embasp.languages.Param;

@Id("isAdjacent")
public class AdjacentBlocks {

    @Param(0)
    private int firstBlockIndex;
    @Param(1)
    private int secondBlockIndex;

    public AdjacentBlocks(int first, int second){
        firstBlockIndex = first;
        secondBlockIndex = second;
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
}
