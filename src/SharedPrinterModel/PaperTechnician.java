package SharedPrinterModel;

import SharedPrinterModel.Interfaces.Printer;
import SharedPrinterModel.utils.Logger;
import SharedPrinterModel.utils.Utility;

public class PaperTechnician extends Technician {
    public PaperTechnician(String name, ThreadGroup threadGroup, Printer printer) {
        super(name, threadGroup, printer);
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            try {
                Utility.log(
                        Logger.PAPER_TECHNICIAN,
                        "Requested to refill paper",
                        null);

                ((LaserPrinter) printer).refillPaper();

                Utility.log(
                        Logger.PAPER_TECHNICIAN,
                        "Printer status. " + printer.toString(),
                        null);
                sleep(Utility.generateRandomDuration());
            } catch (InterruptedException e) {
                Utility.log(Logger.PAPER_TECHNICIAN, e.toString(), false);
            }
        }
    }
}
