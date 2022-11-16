/**
 * W1715753 | 2017321
 * Hirantha Waas
 */

package SharedPrinterModel;

public class Document {
    private final String studentName;
    private final String documentName;
    private final int numOfPages;

    public Document(String studentName,String documentName,int numberOfPages){
        this.studentName = studentName;
        this.documentName = documentName;
        this.numOfPages = numberOfPages;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getDocumentName() {
        return documentName;
    }

    public int getNumOfPages() {
        return numOfPages;
    }

    @Override
    public String toString() {
        return "Document{" +
                "studentName='" + studentName + '\'' +
                ", documentName='" + documentName + '\'' +
                ", numOfPages=" + numOfPages +
                '}';
    }
}
