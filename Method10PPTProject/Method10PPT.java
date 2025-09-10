package Method10PPTProject;

import org.apache.poi.xslf.usermodel.*;
import java.awt.Color;
import java.io.FileOutputStream;
import java.io.IOException;

public class Method10PPT {

    public static void main(String[] args) throws IOException {
        
        XMLSlideShow ppt = new XMLSlideShow();

        // Title Slide
        XSLFSlide slide1 = ppt.createSlide();
        XSLFTextShape title1 = slide1.createTextBox();
        title1.setAnchor(new java.awt.Rectangle(50, 50, 600, 50));
        title1.setText("Solutions — Method 10 (Normal Forms)");
        title1.setFillColor(Color.LIGHT_GRAY);

        XSLFTextShape subtitle1 = slide1.createTextBox();
        subtitle1.setAnchor(new java.awt.Rectangle(50, 120, 600, 80));
        subtitle1.setText("Unit 2: Counting & Propositional Logic\nUsing Unit-2 PNC PPT as reference");

        // Helper function to add slides
        addSlide(ppt, "Method 10.1 — DNF (overview)",
                new String[]{
                        "Procedure:",
                        "1) Replace → and ↔ with ¬, ∨, ∧.",
                        "2) Push negations in (De Morgan).",
                        "3) Distribute ∧ over ∨ to obtain OR of ANDs (DNF)."
                });

        addSlide(ppt, "C1: p ∧ (p → q) — DNF",
                new String[]{
                        "1) Replace →: p ∧ (¬p ∨ q)",
                        "2) Distribute: (p ∧ ¬p) ∨ (p ∧ q)",
                        "3) (p ∧ ¬p) = contradiction → drop",
                        "Result: p ∧ q"
                });

        addSlide(ppt, "T3: (p ∧ (p → q)) → q — DNF",
                new String[]{
                        "1) Inside: p ∧ (p → q) ≡ p ∧ q",
                        "2) So: (p ∧ q) → q",
                        "3) Always true (tautology)",
                        "DNF = T"
                });

        addSlide(ppt, "H5: (¬p → r) ∧ (p → q) — DNF",
                new String[]{
                        "1) Replace: (p ∨ r) ∧ (¬p ∨ q)",
                        "2) Distribute:",
                        "(p∧¬p) ∨ (p∧q) ∨ (r∧¬p) ∨ (r∧q)",
                        "3) Drop contradiction p∧¬p",
                        "Result: (p∧q) ∨ (¬p∧r) ∨ (r∧q)"
                });

        // You can add all other Method 10 solutions here in the same way...

        // Save the PPT file
        try (FileOutputStream out = new FileOutputStream("Method10_Solutions.pptx")) {
            ppt.write(out);
        }

        System.out.println("PPT created successfully: Method10_Solutions.pptx");
    }

    private static void addSlide(XMLSlideShow ppt, String title, String[] points) {
        XSLFSlide slide = ppt.createSlide();
        XSLFTextShape titleShape = slide.createTextBox();
        titleShape.setAnchor(new java.awt.Rectangle(50, 50, 600, 50));
        titleShape.setText(title);

        XSLFTextShape body = slide.createTextBox();
        body.setAnchor(new java.awt.Rectangle(50, 120, 600, 300));

        for (String point : points) {
            XSLFTextParagraph para = body.addNewTextParagraph();
            para.setBullet(true);
            para.addNewTextRun().setText(point);
        }
    }
}
