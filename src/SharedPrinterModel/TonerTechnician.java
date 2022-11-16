/**
 * W1715753 | 2017321
 * Hirantha Waas
 */
package SharedPrinterModel;

import java.util.Random;

public class TonerTechnician extends Technician{

    public TonerTechnician(String name, ThreadGroup group, LaserPrinter laserPrinter) {
        super(name, group, laserPrinter);
    }

    @Override
    public void run(){
        for (int i=0;i<3;i++){
            try {
                //replaceTonerCartridge
                this.laserPrinter.replaceTonerCartridge();
                //thread gets a random sleep
                sleep(getRandomDuration());
            }catch (InterruptedException ex){
                System.out.println(ex.getMessage());
            }
        }
    }
    public int getRandomDuration(){
        Random num=new Random();
        int random=num.nextInt(2000-1000+1)+1000;
        return random;
    }
}
