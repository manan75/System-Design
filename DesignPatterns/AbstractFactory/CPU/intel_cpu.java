package CPU;
public class intel_cpu {
    public String clock ="2.60GHz";
    public String cores="6";
    public String cache ="6MB";
 
     public void dislayCPU(){
         System.out.println("Clock/Speed of CPU: "+ clock);
         System.out.println("Number of cores: "+ cores);
         System.out.println("Cache memory: "+ cache);
     }
}
