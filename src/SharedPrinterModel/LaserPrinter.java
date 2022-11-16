/**
 * W1715753 | 2017321
 * Hirantha Waas
 */
package SharedPrinterModel;

import SharedPrinterModel.Intefaces.ServicePrinter;

public class LaserPrinter implements ServicePrinter{
    private int currentPaperCount;
    private int currentTonerLevel;
    private int numberOfPrintedDocuments;
    private final String printerName;
    private ThreadGroup students;

    // Constructor
    public LaserPrinter(String printerName,ThreadGroup students){
        this.printerName = printerName;
        this.currentPaperCount = ServicePrinter.Full_Paper_Stack;
        this.currentTonerLevel= ServicePrinter.Maximum_Toner_Level;
        this.numberOfPrintedDocuments = 0;
        this.students = students;
    }


    @Override
    public void printDocument(Document document) {
        displayMessage(0,0);
        while (this.currentPaperCount < document.getNumOfPages() || this.currentTonerLevel < document.getNumOfPages()){

            try{
                this.displayMessage(1,0);
                wait();

            }catch (InterruptedException ex){
                System.out.println(ex.toString());
            }
        }
        if (this.currentPaperCount > document.getNumOfPages() && this.currentTonerLevel > document.getNumOfPages()){
            currentPaperCount -= document.getNumOfPages();
            currentTonerLevel -= document.getNumOfPages();
            numberOfPrintedDocuments += 1;
            displayMessage(2,0);
        }
        this.displayMessage(0,0);
        notifyAll();
    }

    @Override
    public void replaceTonerCartridge() {
        while (this.currentTonerLevel > LaserPrinter.Maximum_Toner_Level){
            try {
                if (this.checkTheAvailabilityOfStudent()) {
                    displayMessage(5, 0);
                    wait(5000);
                } else {
                    displayMessage(7, 0);
                    break;
                }
            }catch (InterruptedException ex){
                System.out.println(ex.toString());
            }
        }
        if(this.currentTonerLevel< LaserPrinter.Minimum_Toner_Level){
            this.currentTonerLevel=LaserPrinter.Maximum_Toner_Level;
            displayMessage(6,0);
        }
        notifyAll();
    }

    @Override
    public void refillPaper() {

        while (this.currentPaperCount + LaserPrinter.Papers_Per_Stack> LaserPrinter.Full_Paper_Stack){
            try {
                if(this.checkTheAvailabilityOfStudent()){
                    displayMessage(3,0);
                    wait(5000);
                }else{
                    displayMessage(7,0);
                    break;
                }
            }catch (InterruptedException ex){
                System.out.println(ex.toString());
            }
        }
        if (this.currentPaperCount+LaserPrinter.Papers_Per_Stack<LaserPrinter.Full_Paper_Stack){
            int updatedCount = this.currentPaperCount += LaserPrinter.Papers_Per_Stack;
            this.displayMessage(4,updatedCount);
        }
        notifyAll();

    }

    //display messages relevant to the case
    public void displayMessage (int message, int count){
        switch (message){
            case 0:
                System.out.println(this.toString());
                break;
            case 1:
                System.out.println("Please proceed with the printing");
                break;
            case 2:
                System.out.println("Successfully printed the documents");
                break;
            case 3:
                System.out.println("Please refill the papers to the printer");
                break;
            case 4:
                System.out.println("Successfully refilled the papers to the printer");
                break;
            case 5:
                System.out.println("Please refill the toner cartridge");
                break;
            case 6:
                System.out.println("Successfully refilled the toner cartridge");
                break;
            case 7:
                System.out.println("Successfully completed the printing process");
                break;

        }
    }

    // checking the availability of the student
    private boolean checkTheAvailabilityOfStudent(){
        if(students.activeCount()>0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public String toString(){
        return "LaserPrinter{" + "currentPapers = " + currentPaperCount + ", currentToner = " + currentTonerLevel + ", printedDocuments = " + numberOfPrintedDocuments + ", printerName = " + printerName + '}';
    }

}
