package com.politecnicomalaga.laQuinelaDeMariano.Controller;

import com.politecnicomalaga.laQuinelaDeMariano.Model.Partido;
import com.politecnicomalaga.laQuinelaDeMariano.Model.Peticion;
import com.politecnicomalaga.laQuinelaDeMariano.Model.Respuesta;
import com.politecnicomalaga.laQuinelaDeMariano.View.MainActivity;

import java.util.LinkedList;
import java.util.List;

public class MainController {

    //SINGLETON Controller
    private static final String DATA_URL = "https://www.loteriasyapuestas.es/es/la-quiniela/escrutinios/la-quiniela-premios-y-ganadores-del-22-de-octubre-de-2023";
    private static MainController mySingleController;

        private List<Partido> dataRequested;
    private static MainActivity activeActivity;
    //Comportamiento
    //Constructor
    private MainController() {
         dataRequested = new LinkedList<Partido>();
    }

    //Get instance
    public static MainController getSingleton() {
        if (MainController.mySingleController == null) {
            mySingleController = new MainController();
        }
        return mySingleController;
    }

    //To send data to view
    public List<Partido> getDataFromQuiniela() {
        return this.dataRequested;
    }

    //Called from the view
    public void requestDataFromQuiniela() {
        Peticion p = new Peticion();
        p.requestData(DATA_URL);
    }

    //Called when onResponse is OK
    public void setDataFromQuiniela(String json) {

        Respuesta answer = new Respuesta(json);
        dataRequested = answer.getData();
        //Load data on the list
        MainController.activeActivity.accessData();
    }

    public void setErrorFromQuiniela(String error) {

        //Load data on the list
        MainController.activeActivity.errorData(error);
    }


    public static void setActivity(MainActivity myAct) {
        activeActivity = myAct;
    }

}
