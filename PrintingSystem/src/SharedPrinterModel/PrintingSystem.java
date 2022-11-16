/**
 * W1715753 | 2017321
 * Hirantha Waas
 */
package SharedPrinterModel;

public class PrintingSystem {

    public static void main(String[] args) {

        // Declaring thread groups of students/technicians

        ThreadGroup studentsGroup = new ThreadGroup("Thread Group - Students");
        ThreadGroup techniciansGroup = new ThreadGroup("Thread Group- Technicians");

        // Initializing a Laser Printer object
        LaserPrinter laserPrinter = new LaserPrinter("HP DeskJet 9977",studentsGroup);

        // Student Thread
        Student student_1 = new Student("Kasun",studentsGroup,laserPrinter);
        Student student_2 = new Student("Rasheed",studentsGroup, laserPrinter);
        Student student_3 = new Student("Dilan",studentsGroup, laserPrinter);
        Student student_4 = new Student("Priyadarshana",studentsGroup, laserPrinter);

        // Technician Thread
        Technician paperTechnician = new PaperTechnician("Pradeep",techniciansGroup,laserPrinter);
        Technician tonerTechnician = new PaperTechnician("Shane",techniciansGroup,laserPrinter);


        // Start all threads
        student_1.start();
        student_2.start();
        student_3.start();
        student_4.start();
        paperTechnician.start();
        tonerTechnician.start();


        // Waiting for the completion of all threads
       try{
           student_1.join();
           student_2.join();
           student_3.join();
           student_4.join();

       }catch (InterruptedException ex){
           System.out.println(ex.getMessage());
       }

    }
}
