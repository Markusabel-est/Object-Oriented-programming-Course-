package factory;

public interface EnergyConsumer {
    
    double getVoltage();
    double getCurrent();

    default double getYearlyEnergyUsage(){
        return((getVoltage()* getCurrent() * 24 *365)/1000);
    }

}
