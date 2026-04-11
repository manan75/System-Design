
import CPU.AMD_cpu;
import CPU.intel_cpu;

public class CPUfactory {
    public String CPU_type;
    
    public AMD_cpu getAMD_cpu(){
        
        return  new AMD_cpu();
    }
    public intel_cpu getIntel_cpu(){
        return new intel_cpu();
    }
}
