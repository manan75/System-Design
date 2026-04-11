
import GPU.AMD_gpu;
import GPU.Nvidia_gpu;

public class GPUfactory {
    public String gpuType;
    
    public Nvidia_gpu getNvidia_gpu(){
       
        return new Nvidia_gpu();
    }
    public AMD_gpu getAmd_gpu(){
         
        return new AMD_gpu();
    }
}
