/**
 * W1715753 | 2017321
 * Hirantha Waas
 */
package SharedPrinterModel;

public abstract class Technician extends Thread{

    protected LaserPrinter laserPrinter;

    // default constructor
    public Technician(String name, ThreadGroup group,LaserPrinter laserPrinter){
        super(group,name);
        this.laserPrinter = laserPrinter;
    }

}
