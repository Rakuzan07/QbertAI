import java.util.HashMap;

public class World {

    private int isometricBlockNumber = 25;
    private int blockLevels = 7;
    private IsometricBlock[] blocks;

    public World() {
        blocks = new IsometricBlock[isometricBlockNumber];
        createBlocks();
        fillIsometricBlocks();
    }

    private void createBlocks(){
        for (int i = 0; i < isometricBlockNumber; i++) {
            blocks[i] = new IsometricBlock();
        }
    }

    private int findBlockLevel(int blockNumber){

        int maxLevelIndex = 0;
        int previousLevelMaxIndex = 0;

        for (int i = 1; i <= blockLevels; i++) {
            maxLevelIndex = i + previousLevelMaxIndex;
            previousLevelMaxIndex = maxLevelIndex;

            if(blockNumber <= maxLevelIndex)
                return i;
        }

        return -1;
    }

    private void fillIsometricBlocks(){
        for (int i = 0; i < isometricBlockNumber; i++) {
            int blockLevel = findBlockLevel(i);
            int upLeftBlock = i - blockLevel;
            int upRightLevel = upLeftBlock + 1;
            int downLeftLevel = i + blockLevel;
            int downRightLevel = downLeftLevel + 1;

            if(findBlockLevel(upLeftBlock) == blockLevel - 1){
                blocks[i].addAdiacentUpLeft(blocks[upLeftBlock]);
            }

            if(findBlockLevel(upRightLevel) == blockLevel - 1){
                blocks[i].addAdiacentUpRight(blocks[upRightLevel]);
            }

            if(findBlockLevel(downLeftLevel) == blockLevel + 1){
                blocks[i].addAdiacentDownLeft(blocks[downLeftLevel]);
            }

            if(findBlockLevel(downRightLevel) == blockLevel + 1){
                blocks[i].addAdiacentDownRight(blocks[downRightLevel]);
            }

        }
    }
}