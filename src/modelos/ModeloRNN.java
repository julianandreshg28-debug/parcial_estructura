package modelos;

import datos.Dataset;

/**
 * Modelo RNN. Hiperparámetro: número de capas.
 */
public class ModeloRNN extends Modelo {

    private int numCapas;

    public ModeloRNN(String nombre, int maxEpocas, int numCapas) {
        super(nombre, maxEpocas);
        this.numCapas = numCapas;
    }


    @Override
    public double entrenar(Dataset dataset) {
        int loss = numCapas * 15;

        while (getEpocaActual() < getLossPorEpoca().length) {
            registrarEpoca(loss);
            loss = Math.max(0, loss - 3);
        }

        return mejorLoss();
    }


    public int getNumCapas() { return numCapas; }
}
