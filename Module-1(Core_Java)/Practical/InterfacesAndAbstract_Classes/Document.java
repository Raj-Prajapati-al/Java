// Interface 1
interface Printable {
    void print();
}

// Interface 2
interface Showable {
    void show();
}

// Class implementing multiple interfaces
class Document implements Printable, Showable {
    @Override
    public void print() {
        System.out.println("Printing document.");
    }

    @Override
    public void show() {
        System.out.println("Showing document.");
    }

    public static void main(String[] args) {
        Document doc = new Document();
        doc.print();
        doc.show();
    }
}
