package modelos;

import datos.Dataset;

/**
 * Modelo de regresión. Hiperparámetro: grado del polinomio.
 */
public class ModeloRegresion extends Modelo {

    private int grado;

    public ModeloRegresion(String nombre, int maxEpocas, int grado) {
        super(nombre, maxEpocas);
        this.grado = grado;
    }


    @Override
    public double entrenar(Dataset dataset) {
        int loss = grado * 20;

        while (getEpocaActual() < getLossPorEpoca().length) {
            registrarEpoca(loss);
            loss = Math.max(0, loss - 4);
        }

        return mejorLoss();
    }


    public int getGrado() { return grado; }
}