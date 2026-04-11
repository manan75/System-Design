
import Hardware.Asus_hardware;
import Hardware.Lenovo_hardware;

public class HardwareFactory {
    public String HardwareType;

    public Lenovo_hardware getLenovo_hardware(){
        return new Lenovo_hardware();
    }
    public Asus_hardware getAsus_hardware(){
        return new Asus_hardware();
    }
}
