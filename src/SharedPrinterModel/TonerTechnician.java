package SharedPrinterModel;

import SharedPrinterModel.Interfaces.Printer;
import SharedPrinterModel.utils.Logger;
import SharedPrinterModel.utils.Utility;

/**
 * Represents the toner technician, who replaces the cartridge of the printer
 */
public class TonerTechnician extends Technician {
    public TonerTechnician(String name, ThreadGroup threadGroup, Printer printer) {
        super(name, threadGroup, printer);
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            try {
                Utility.log(
                        Logger.TONER_TECHNICIAN,
                        "Requested to replace toner",
                        null);

                ((LaserPrinter) printer).replaceTonerCartridge();

                Utility.log(
                        Logger.TONER_TECHNICIAN,
                        "Printer status. " + printer.toString(),
                        null);
                sleep(Utility.generateRandomDuration());
            } catch (InterruptedException e) {
                Utility.log(Logger.TONER_TECHNICIAN, e.toString(), false);
            }
        }
    }
}