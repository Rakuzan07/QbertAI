package logic;

import it.unical.mat.embasp.languages.Id;
import it.unical.mat.embasp.languages.Param;

@Id("pathSize")
public class BlocksPath {

    @Param(0)
    private int firstBlockIndex;
    @Param(1)
    private int secondBlockIndex;
    @Param(2)
    private int pathWeight;

    public BlocksPath(int first, int second, int weight){
        firstBlockIndex = first;
        secondBlockIndex = second;
        pathWeight = weight;
    }

    public BlocksPath(){}

    public int getFirstBlockIndex() {
        return firstBlockIndex;
    }

    public int getSecondBlockIndex() {
        return secondBlockIndex;
    }

    public int getPathWeight() {
        return pathWeight;
    }

    public void setFirstBlockIndex(int firstBlockIndex) {
        this.firstBlockIndex = firstBlockIndex;
    }

    public void setSecondBlockIndex(int secondBlockIndex) {
        this.secondBlockIndex = secondBlockIndex;
    }

    public void setPathWeight(int pathWeight) {
        this.pathWeight = pathWeight;
    }

    @Override
    public String toString() {
        return "BlocksPath{" + firstBlockIndex +
                ", " + secondBlockIndex +
                ", " + pathWeight +
                '}';
    }
}
