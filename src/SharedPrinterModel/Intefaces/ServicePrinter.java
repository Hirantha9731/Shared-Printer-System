/**
 * W1715753 | 2017321
 * Hirantha Waas
 */
package SharedPrinterModel.Intefaces;

public interface ServicePrinter extends Printer{

    public final int Full_Paper_Stack = 250;
    public final int Maximum_Toner_Level = 500;
    public final int Minimum_Toner_Level = 10;
    public final int Papers_Per_Stack = 50;

    public final int Pages_Per_Toner_Cartridge = 500;

    public void replaceTonerCartridge();
    public void refillPaper();
}
