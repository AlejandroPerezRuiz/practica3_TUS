package es.unican.alejandro.tus_practica3.Presenter;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import java.util.List;

import es.unican.alejandro.tus_practica3.Model.DataLoaders.ParserJSON;
import es.unican.alejandro.tus_practica3.Model.DataLoaders.RemoteFetch;
import es.unican.alejandro.tus_practica3.Model.Linea;
import es.unican.alejandro.tus_practica3.Views.IListLineasView;
import es.unican.alejandro.tus_practica3.Views.ListLineasAdapter;

/**
 * Created by alejandro on 11/10/17.
 */

public class ListLineasPresenter {
    private IListLineasView listLineasView;
    private List<Linea> listaLineasBus;
    private RemoteFetch remoteFetchLineas;
    private Context context;

    public ListLineasPresenter(Context context, IListLineasView listLineasView){
        this.listLineasView = listLineasView;
        this.remoteFetchLineas = new RemoteFetch();
        this.context = context;
    }// ListLineasPresenter

    public void start(){
        listLineasView.showProgress(true);
        obtenLineas();
        listLineasView.showList(getListaLineasBus());
        listLineasView.showProgress(false);
    }// start


    /**
     * Método a través del cual se almacenan las lineas de buses en el atributo listaLineasBus
     * de esta clase. Para realizar esto internamente realiza una llamada a la función
     * getJSON (RemoteFetch) para seguidamente parsear el JSON obtenido con la llamada
     * a readArrayLineasBus (ParserJSON)
     * @return
     */
    public boolean obtenLineas(){
        try {
            remoteFetchLineas.getJSON(RemoteFetch.URL_LINEAS_BUS);;
            listaLineasBus = ParserJSON.readArrayLineasBus(remoteFetchLineas.getBufferedData());
            Log.d("ENTRA", "Obten gasolineras:"+listaLineasBus.size());
            return true;
        }catch(Exception e){
            Log.e("ERROR","Error en la obtención de las lineas de Bus: "+e.getMessage());
            e.printStackTrace();
            return false;
        }//try
    }//obtenLineas


    public List<Linea> getListaLineasBus() {
        return listaLineasBus;
    }//getListaLineasBus


    /**
     * Método para obtener un cadena de texto con todas las lineas. En esta cadena
     * se muestra unicamente el nombre de la linea
     *  @return String con todas las gasolineras separadas por un doble salto de línea
     */
    public String getTextoLineas(){
        String textoLineas="";
        if(listaLineasBus!=null){
            for (int i=0; i<listaLineasBus.size(); i++){
                textoLineas=textoLineas+listaLineasBus.get(i).getNumero()+"\n\n";
            }//for
        }else{
            textoLineas="Sin lineas";
        }//if
        return textoLineas;
    }//getTextoLineas

}// ListLineasPresenter
