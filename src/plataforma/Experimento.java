package plataforma;

import datos.Dataset;
import modelos.*;

/**
 * Experimento que COMPONE un modelo.
 * El modelo se crea dentro del constructor (composición real).
 */
public class Experimento {

    private String id;
    private Modelo modelo;

    /**
     * Crea el modelo según el tipo indicado.
     * Tipo: "CNN", "RNN", "REGRESION".
     * Si el tipo es inválido, el modelo queda null.
     */

    public Experimento(String id, String tipoModelo, int maxEpocas) {
        this.id = id;

        switch (tipoModelo) {
            case "CNN":
                this.modelo = new ModeloCNN(id, maxEpocas, 8);
                break;

            case "RNN":
                this.modelo = new ModeloRNN(id, maxEpocas, 4);
                break;

            case "REGRESION":
                this.modelo = new ModeloRegresion(id, maxEpocas, 2);
                break;

            default:
                this.modelo = null;
                break;
        }
    }


    /** Ejecuta el entrenamiento del modelo sobre el dataset. */

    public double ejecutar(Dataset dataset) {
        if (modelo == null) {
            return 0;
        }

        return modelo.entrenar(dataset);
    }


    public String getId() { return id; }
    public Modelo getModelo() { return modelo; }
}