package laskin;

import fi.jyu.mit.fxgui.Dialogs;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * @author henri
 * @version 25.1.2020
 * RPN-Laskimen controller
 */
public class LaskinDemoGUIController {
      
    @FXML
    private TextField pinonAlin;
    
    @FXML
    private TextField pinonKeskim;
    
    @FXML
    private TextField pinonPaal;
    
    @FXML
    private TextField tahanKirjoitetaan;
    
    @FXML
    private Button nappi;

    /**
     * Siirretään numeroita pinoon enteriä painamalla
     */
    public void numeronSiirto() {
        pinonAlin.setText(pinonKeskim.getText());
        pinonKeskim.setText(pinonPaal.getText());       
        pinonPaal.setText(tahanKirjoitetaan.getText());               
    }
    
    /**
     * Siirto ilman enterin toimintoa
     */
    public void numeronSiirto2() {
        pinonAlin.setText(pinonKeskim.getText());
        pinonKeskim.setText(pinonPaal.getText());                      
    }
    
    
    /**
     * Lasketaan kaksi alinta riippuen painetusta napista.
     * @param painettuNappi = painettu nappi
     * @example
     */
    public void laske(ActionEvent painettuNappi) {
        
        String mikaPainettu = ((Button)painettuNappi.getSource()).getText();
        double tulos = 0;
        
        if((pinonKeskim.getText().contentEquals("") && !mikaPainettu.contentEquals("Sqrt")) || pinonPaal.getText().contentEquals("")) {
            Dialogs.showMessageDialog("Insert another number with 'Enter' first!");
            return;
        }

        switch (mikaPainettu) {
        case "+":
            numeronSiirto2();
            tulos = Double.parseDouble(pinonAlin.getText()) + Double.parseDouble(pinonKeskim.getText());
            pinonPaal.setText(Double.toString(tulos));
            break;
        case "-":
            numeronSiirto2();
            tulos = Double.parseDouble(pinonAlin.getText()) - Double.parseDouble(pinonKeskim.getText());
            pinonPaal.setText(Double.toString(tulos));
            break;
        case "*":
            numeronSiirto2();
            tulos = Double.parseDouble(pinonAlin.getText()) * Double.parseDouble(pinonKeskim.getText());
            pinonPaal.setText(Double.toString(tulos));
            break;
        case "/":
            
            if(pinonPaal.getText().contentEquals("0")) {
                Dialogs.showMessageDialog("Can't divide by zero!");
                return;
            }
            numeronSiirto2();
            tulos = Double.parseDouble(pinonAlin.getText()) / Double.parseDouble(pinonKeskim.getText());
            pinonPaal.setText(Double.toString(tulos));
            break;
        case "Sqrt":
            if(pinonPaal.getText().contains("-")) {
                Dialogs.showMessageDialog("This calculator can't take square root from negative numbers!");
                return;
            }
            numeronSiirto2();
            tulos = Math.sqrt(Double.parseDouble(pinonKeskim.getText()));
            pinonPaal.setText(Double.toString(tulos));
            break;            
        case "Swap":
            tulos = Double.parseDouble(pinonKeskim.getText());
            pinonKeskim.setText(pinonPaal.getText());
            pinonPaal.setText(Double.toString(tulos));
            break;         
        case "CHS":
            double merkkiVaihtuu = 0-Double.parseDouble(pinonPaal.getText());
            pinonPaal.setText(Double.toString(merkkiVaihtuu));
            break;         
        default:
            break;
        }
       
    }
}