import CPU.AMD_cpu;
import CPU.intel_cpu;
import GPU.AMD_gpu;
import GPU.Nvidia_gpu;
import Hardware.Asus_hardware;
import Hardware.Lenovo_hardware;

public class laptopFactory {
    public HardwareFactory hardwareFactory = new HardwareFactory();
    public CPUfactory cpuFactory = new CPUfactory();
    public GPUfactory gpuFactory = new GPUfactory();

    public void buildLaptop(String hardwareChoice, String cpuChoice, String gpuChoice) {
    
        if (hardwareChoice.equalsIgnoreCase("1")) {
            System.out.println("Selected hardware: Asus");
            Asus_hardware hardware = hardwareFactory.getAsus_hardware();
            hardware.displayHardware();
        } else if (hardwareChoice.equalsIgnoreCase("2")) {
            System.out.println("Selected hardware: Lenovo");
            Lenovo_hardware hardware = hardwareFactory.getLenovo_hardware();
            hardware.displayHardware();
        } else {
            System.out.println("Invalid hardware choice.");
            return;
        }

        // Select CPU
        if (cpuChoice.equalsIgnoreCase("1")) {
            System.out.println("Selected CPU: AMD");
            AMD_cpu cpu = cpuFactory.getAMD_cpu();
            cpu.dislayCPU();
        } else if (cpuChoice.equalsIgnoreCase("2")) {
            System.out.println("Selected CPU: Intel");
            intel_cpu cpu = cpuFactory.getIntel_cpu();
            cpu.dislayCPU();
        } else {
            System.out.println("Invalid CPU choice.");
            return;
        }

        // Select GPU
        if (gpuChoice.equalsIgnoreCase("1")) {
            System.out.println("Selected GPU: AMD");
            AMD_gpu gpu = gpuFactory.getAmd_gpu();
            gpu.displayGPU();
        } else if (gpuChoice.equalsIgnoreCase("2")) {
            System.out.println("Selected GPU: Nvidia");
            Nvidia_gpu gpu = gpuFactory.getNvidia_gpu();
            gpu.displayGPU();
        } else {
            System.out.println("Invalid GPU choice.");
            return;
        }

        System.out.println("Laptop assembly complete!");
    }
}
