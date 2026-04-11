package CPU;
public class AMD_cpu {
   public String clock ="2.30GHz";
   public String cores="8";
   public String cache ="8MB";

    public void dislayCPU(){
        System.out.println("Clock/Speed of CPU: "+ clock);
        System.out.println("Number of cores: "+ cores);
        System.out.println("Cache memory: "+ cache);
    }

}
