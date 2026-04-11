package GPU;

public class AMD_gpu {
    public String gpuModel = "Raedon RX 580";
    public String vRam ="8GB";
    public boolean rayTracing = false;
    public String resolution = "1080p";
    public String coolingSystem = "Liquid Cooling";
    public String memoryType = "GDDR6";

    public void displayGPU(){
        System.out.println("GPU model: "+ gpuModel);
        System.out.println("VRAM: "+ vRam);
        System.out.println("Supports ray tracing?: "+ rayTracing);
        System.out.println("Resolution: "+ resolution);
        System.out.println("Cooling system: " + coolingSystem);
        System.out.println("Memory type: "+ memoryType);
}
}
