/**
 * W1715753 | 2017321
 * Hirantha Waas
 */

package SharedPrinterModel;

import java.util.Random;

public class Student extends Thread{

    private LaserPrinter laserPrinter;

    public Student(String name,ThreadGroup threadGroup, LaserPrinter laserPrinter) {
        super(threadGroup,name);
        this.laserPrinter = laserPrinter;
    }

    @Override
    public void run(){
        for(int i=0;i<5;i++){
            Document document= new Document(this.getName(),"Document"+i+i,getPageNumber());
            this.laserPrinter.printDocument(document);
            System.out.println(this);
            try{
                sleep(getRandomDuration());
            }catch (InterruptedException ex){
                System.out.println(ex.toString());
            }
        }
    }

    public int getRandomDuration(){
        Random num =new Random();
        int random=num.nextInt(2000-1000+1)+1000;
        return random;
    }
    public int getPageNumber(){
        Random num=new Random();
        int random=num.nextInt(25-10+1)+10;
        return random;
    }
    @Override
    public String toString(){
        return "Name of the student:"+this.getName()+ "\t"+"completed the printing successfully";

    }
}
