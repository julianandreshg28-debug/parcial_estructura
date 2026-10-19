package plataforma;

import java.util.ArrayList;
import java.util.List;

/**
 * Plataforma que AGREGA experimentos.
 */
public class Plataforma {

    private String nombre;
    private ArrayList<Experimento> experimentos;

    public Plataforma(String nombre) {
        this.nombre = nombre;
        this.experimentos = new ArrayList<>();
    }

    /** Agrega un experimento ya existente (agregación). */
    public void agregarExperimento(Experimento experimento) {
        experimentos.add(experimento);

    }

    /**
     * Reporte: una línea por experimento con su id y el mejor loss de su modelo.
     */

    public List<String> reporteMejorLoss() {
        List<String> reporte = new ArrayList<>();

        for (Experimento experimento : experimentos) {
            if (experimento.getModelo() != null) {
                reporte.add(experimento.getId() + ": " +
                        experimento.getModelo().mejorLoss());
            }
        }

        return reporte;
    }


    public String getNombre() { return nombre; }
    public ArrayList<Experimento> getExperimentos() { return experimentos; }
}