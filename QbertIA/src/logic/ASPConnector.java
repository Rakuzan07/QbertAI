package logic;

import it.unical.mat.embasp.base.Handler;
import it.unical.mat.embasp.base.InputProgram;
import it.unical.mat.embasp.languages.asp.ASPInputProgram;
import it.unical.mat.embasp.languages.asp.AnswerSet;
import it.unical.mat.embasp.languages.asp.AnswerSets;
import it.unical.mat.embasp.platforms.desktop.DesktopHandler;
import it.unical.mat.embasp.specializations.dlv2.desktop.DLV2DesktopService;

import java.util.List;

public class ASPConnector {

    private String logicProgramPath;
    private Handler handler;
    private InputProgram facts;
    private InputProgram logicProgram;

    public ASPConnector(String path){
        logicProgramPath = path;
        handler = new DesktopHandler(new DLV2DesktopService("src/libs/dlv2"));
        facts = new ASPInputProgram();
        logicProgram = new ASPInputProgram();
        logicProgram.addFilesPath(logicProgramPath);
    }

    public void putFact(Object o){
        try {
            facts.addObjectInput(o);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<AnswerSet> startSync(){
        handler.addProgram(facts);
        handler.addProgram(logicProgram);
        AnswerSets answerSets = (AnswerSets) handler.startSync();
        return answerSets.getAnswersets();
    }
}