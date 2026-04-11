package DesignPatterns.StateChange;

public class Development implements State {
    

    private int devPhase;
    private int idea;
    private String screenplay;
    private int budget;
    private String parentCompany;

    public void getStuff(){
        System.out.println("");
    }

   public void changeState(MovieContext context){
    //here things that this class will do will come






    //then we change the context to next phase
   context.setState(new PreProduction());
   }
}
