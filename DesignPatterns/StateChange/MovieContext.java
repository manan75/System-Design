package DesignPatterns.StateChange;

public class MovieContext {
    public State state;
    public int phaseCounter =1;

    //we will be starting from development
    public MovieContext(){
        this.state = new Development();
    }

    public void setState(State state){
        this.state = state;
        phaseCounter++;
    }

    public void nextPhase(){
        state.changeState(this);
        //this will get next phase and in those phase we will set the next phase
        System.out.println("Phase counter: "+ phaseCounter);
    }

    
}
