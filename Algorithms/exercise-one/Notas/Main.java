public class Main {
    public static void main(String[] args) {
        NotasManager manager = new NotasManager();
        
        // Creación de 58 notas con valores predefinidos
        int[] notasFijas = {10, 15, 20, 18, 12, 9, 14, 19, 7, 16,
                            13, 11, 8, 17, 6, 5, 4, 3, 2, 1,
                            0, 20, 19, 18, 17, 16, 15, 14, 13, 12,
                            11, 10, 9, 8, 7, 6, 5, 4, 3, 2,
                            1, 0, 18, 17, 16, 15, 14, 13, 12, 11,
                            10, 9, 8, 7, 6, 5, 4, 3};
        
        String[] nombresEstudiantes = {"Ana", "Luis", "Carlos", "María", "José", "Elena", "Pedro", "Sofía", "Raúl", "Isabel",
                                       "Javier", "Laura", "Fernando", "Carmen", "Manuel", "Patricia", "Diego", "Gabriela", "Alberto", "Rosa",
                                       "Ricardo", "Beatriz", "Miguel", "Teresa", "Andrés", "Silvia", "Hugo", "Valeria", "Santiago", "Daniela",
                                       "Pablo", "Natalia", "Joaquín", "Andrea", "Tomás", "Lucía", "Ernesto", "Clara", "Guillermo", "Diana",
                                       "Felipe", "Marta", "Samuel", "Verónica", "Emilio", "Rocío", "Oscar", "Paula", "Vicente", "Alicia",
                                       "Gonzalo", "Cristina", "Esteban", "Julia", "Leandro", "Monica", "Iván", "Lorena"};
        
        for (int i = 0; i < 58; i++) {
            manager.NOTAS[i] = new Nota(notasFijas[i], nombresEstudiantes[i]);
        }
        
        // Imprimir resumen de notas
        manager.imprimirResumen();
    }
}
