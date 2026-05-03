package com.expense.creational;

interface Report { void generate(); }
interface Chart { void render(); }

class CSVReport implements Report { public void generate() { System.out.println("CSV report generated"); } }
class CSVChart implements Chart { public void render() { System.out.println("CSV chart rendered"); } }
class PDFReport implements Report { public void generate() { System.out.println("PDF report generated"); } }
class PDFChart implements Chart { public void render() { System.out.println("PDF chart rendered"); } }

interface ReportFactory {
    Report createReport();
    Chart createChart();
}

class CSVReportFactory implements ReportFactory {
    public Report createReport() { return new CSVReport(); }
    public Chart createChart() { return new CSVChart(); }
}

class PDFReportFactory implements ReportFactory {
    public Report createReport() { return new PDFReport(); }
    public Chart createChart() { return new PDFChart(); }
}
