package es.unican.alejandro.tus_practica3.Model.DataLoaders;

import android.support.test.InstrumentationRegistry;

import org.junit.Test;

import java.io.InputStream;

import es.unican.alejandro.tus_practica3.R;

/**
 * Created by alejandro on 12/09/17.
 */

public class ParserUnitTest {
    /**
     * Test para comprobar el parseo del JSON correspondiente a las lineas de TUS Santander
     * @throws Exception
     */
    @Test
    public void testParserLineas() throws Exception {
        //Obtenemos el InputStream para el json almacenado en la carpeta raw del proyecto
        InputStream is = InstrumentationRegistry.getTargetContext().getResources().openRawResource(R.raw.lineas_test);
        //TODO completar este test para comprobar que el método readArrayLineasBus (clase ParserJSON) funciona de manera correcta
    }// testParserLineas
}// ParserUnitTest
