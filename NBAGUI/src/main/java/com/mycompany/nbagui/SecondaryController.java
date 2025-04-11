package com.mycompany.nbagui;

import java.io.IOException;
import javafx.fxml.FXML;

public class SecondaryController {

    @FXML
    private void switchToPrimary() throws IOException {
        NBAGUI.setRoot("primary");
    }
}