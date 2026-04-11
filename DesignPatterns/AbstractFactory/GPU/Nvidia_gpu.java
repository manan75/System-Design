package GPU;
public class Nvidia_gpu {
    public String gpuModel = "RTX 4090";
    public String vRam ="12GB";
    public boolean rayTracing = true;
    public String resolution = "4K";
    public String coolingSystem = "Hybrid Cooling";
    public String memoryType = "GDDR5";

    public void displayGPU(){
        System.out.println("GPU model: "+ gpuModel);
        System.out.println("VRAM: "+ vRam);
        System.out.println("Supports ray tracing?: "+ rayTracing);
        System.out.println("Resolution: "+ resolution);
        System.out.println("Cooling system: " + coolingSystem);
        System.out.println("Memory type: "+ memoryType);
    }
}
