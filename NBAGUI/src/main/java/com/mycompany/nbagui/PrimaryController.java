package com.mycompany.nbagui;

import java.io.IOException;
import javafx.fxml.FXML;

public class PrimaryController {

    @FXML
    private void switchToSecondary() throws IOException {
        NBAGUI.setRoot("secondary");
    }
}
