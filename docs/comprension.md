# Comprensión del diseño — Enunciado B
**Nombre:** Julian Andres Hernandez Garcia
**Fecha:** 19/10/26

Responde con tus palabras, basándote en `docs/UML-final.md`. Respuestas
concisas (2–4 líneas por pregunta). Evidencia que entendiste el contrato
**antes** de programar.

---

### 1. Herencia y polimorfismo
¿Por qué `Modelo` es una clase abstracta y no concreta? Menciona qué método
obliga a cada subclase a implementar y qué gana el sistema con eso.

> _Tu respuesta:_ La clase `Modelo` es abstracta porque sirve como base para los diferentes tipos de modelos y no necesita instanciarse directamente. Obliga a las subclases a implementar el método `entrenar(Dataset)`, permitiendo que cada una tenga su propio entrenamiento. Esto facilita reutilizar código y aplicar polimorfismo.

---

### 2. Composición vs. agregación
Explica la diferencia entre `Experimento ◆— Modelo` (composición) y
`Plataforma ◇— Experimento` (agregación). ¿Qué pasaría con el modelo si se
elimina el experimento? ¿Y con los experimentos si se elimina la plataforma?

> _Tu respuesta:_ En la composición, `Experimento` crea y posee su `Modelo`, por lo que, si se elimina el experimento, también desaparece el modelo. En la agregación, `Plataforma` almacena experimentos que fueron creados independientemente. Por eso, si se elimina la plataforma, los experimentos pueden seguir existiendo.

---

### 3. Asociación
En `Investigador — Experimento`, ¿quién es dueño de quién? ¿Por qué se modela
como N:M y no como composición?

> _Tu respuesta:_ En la asociación entre `Investigador` y `Experimento`, ninguno es dueño del otro, ya que ambos pueden existir independientemente. Es una relación N:M porque un investigador puede participar en varios experimentos y un experimento puede tener varios investigadores. No es composición porque no dependen entre sí para existir.

---

### 4. Dependencia
¿Por qué `Modelo` **depende** de `MetricaEvaluacion` en lugar de **tenerlo**
como atributo? ¿Qué ventaja tiene pasar el servicio como parámetro?

> _Tu respuesta:_ `Modelo` depende de `MetricaEvaluacion` porque solo necesita utilizarla cuando debe calcular una métrica, sin guardarla como atributo. Pasar el servicio como parámetro permite utilizar diferentes implementaciones de evaluación y evita que el modelo dependa permanentemente de un objeto específico.

---

### 5. Listas
En este proyecto se usan dos estructuras distintas:
- `int[] lossPorEpoca` en `Modelo`
- `ArrayList<Experimento>` en `Plataforma`

Explica por qué en cada caso se eligió esa estructura y no la otra.

> _Tu respuesta:_ Se utiliza `int[] lossPorEpoca` porque cada modelo tiene una cantidad máxima de épocas y necesita almacenar valores enteros en un arreglo de capacidad fija. En cambio, `ArrayList<Experimento>` permite que la plataforma agregue experimentos dinámicamente sin definir una cantidad máxima. Cada estructura se eligió según las necesidades de almacenamiento del sistema.