package logic;

import it.unical.mat.embasp.languages.Id;
import it.unical.mat.embasp.languages.Param;

@Id("isTarget")
public class Target {

    @Param(0)
    private int isometricBlockId;

    public Target(int id){
        isometricBlockId = id;
    }

    public Target(){

    }

    public int getIsometricBlockId() {
        return isometricBlockId;
    }

    public void setIsometricBlockId(int isometricBlockId) {
        this.isometricBlockId = isometricBlockId;
    }

    @Override
    public String toString() {
        return "Target(" + isometricBlockId + ").";
    }
}
