package data_access;

import use_case.save_text.SaveDataAccessInterface;

import java.awt.*;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

public class SaveDataAccessObject implements SaveDataAccessInterface {

    public void saveToPDF(String text) {
        PrinterJob job = PrinterJob.getPrinterJob();
        job.setJobName("Save to PDF/Print");

        job.setPrintable(new Printable() {
            public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) {
                if (pageIndex != 0) {
                    return NO_SUCH_PAGE;
                }

                Graphics2D g2d = (Graphics2D) graphics;
                g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());

                Font font = new Font("times new roman", Font.PLAIN, 12);
                g2d.setFont(font);

                drawText(g2d, text, (int) pageFormat.getImageableWidth(), 0, 0);

                return PAGE_EXISTS;
            }
        });

        if (job.printDialog()) {
            try {
                job.print();
            } catch (PrinterException ex) {
                ex.printStackTrace();
            }
        }
    }

    private static void drawText(Graphics2D g2d, String text, int width, int x, int y) {
        FontMetrics metrics = g2d.getFontMetrics();
        int lineHeight = metrics.getHeight();
        int curX = x;
        int curY = y + lineHeight;

        for (String line : text.split("\n")) {
            if (metrics.stringWidth(line) <= width) {
                g2d.drawString(line, curX, curY);
                curY += lineHeight;
            }
            }
        }

}
