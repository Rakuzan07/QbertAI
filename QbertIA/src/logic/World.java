package logic;

public class World {

	private static final int NUM_ELEVATOR=2;
	private static final int DEFAULT_ELEVATOR_FAD=6 , DEFAULT_ELEVATOR_SAD=9;
    private int isometricBlockNumber = 28;
    private int blockLevels = 7;
    private IsometricBlock[] blocks;
    private Elevator[] elevators=new Elevator[NUM_ELEVATOR];
    
    public World() {
        blocks = new IsometricBlock[isometricBlockNumber];
        createBlocks();
        fillIsometricBlocks();
        assignBlocksId();
        elevators[0]=new Elevator(blocks[DEFAULT_ELEVATOR_FAD]);
        elevators[1]=new Elevator(blocks[DEFAULT_ELEVATOR_SAD]);
    }

    private void createBlocks(){
        for (int i = 0; i < isometricBlockNumber; i++) {
            blocks[i] = new IsometricBlock();
        }
    }

    private void assignBlocksId(){
        for (int i = 0; i < isometricBlockNumber; i++) {
            blocks[i].setId(i);
        }
    }

    private int findBlockLevel(int blockNumber){

        if(blockNumber < 0)
            return -1;

        if(blockNumber == 0)
            return 1;

        int maxLevelIndex = 0;
        int previousLevelMaxIndex = 0;

        for (int i = 2; i <= blockLevels; i++) {
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
    
    public String toString() {
    	String s="";
    	for (int i=0;i<isometricBlockNumber;i++) {
    		s +="Blocco "+i+" adiacenti :\n";
    		IsometricBlock[] adiacenti=blocks[i].getAdiacent();
    		for(int j=0;j<adiacenti.length;j++) {
    		    if(adiacenti[j] != null)
    		    s+="Blocco "+blockIndex(adiacenti[j])+" \n";
    		}

    		s += "\n";
    	}
    	return s;
    }

/*    public int posIsometricBlock(IsometricBlock s) {
    	for(int i=0;i<isometricBlockNumber;i++) {
    		if(s==blocks[i]) return i;
    	}
    	return -1;
    }*/
    
    public IsometricBlock getBlock(int index) {
    	return blocks[index];
    }
    
    public int getNumLevel() {
    	return blockLevels;
    }
    
    public int blockIndex(IsometricBlock ib) {
    	for(int i=0;i<isometricBlockNumber;i++) {
    		if (ib==blocks[i]) return i;
    	}
    	return -1;
    }
    
    public void setVisited(int index) {
    	blocks[index].setVisited(true);
    }
    
    public boolean isVisited(int index) {
    	return blocks[index].isVisited(); 
    }

    public int getIsometricBlockNumber() {
        return isometricBlockNumber;
    }
    
    public void setAdiacent(int elevator , int adiacent) {
    	elevators[elevator]=new Elevator(blocks[adiacent]);
    }
}