public class Main {
    public static void main(String[] args) {
        double[][] inputData = {
                {0, 0},
                {0, 1},
                {1, 0},
                {1, 1}
        };

        double[] andOutput = {0, 0, 0, 1};
        double[] orOutput = {0, 1, 1, 1};

        int epochs = 10000;
        double learningRate = 0.1;

        // ENTRENAMIENTO PARA AND
        System.out.println("=== ENTRENAMIENTO PARA LA COMPUERTA AND ===");
        SigmoidPerceptron andPerceptron = new SigmoidPerceptron(2, learningRate);
        andPerceptron.train(inputData, andOutput, epochs);
        andPerceptron.printParameters();

        System.out.println("RESULTADOS PARA AND:");
        for (double[] input : inputData) {
            double prediction = andPerceptron.predict(input);
            System.out.printf("ENTRADA: (%.0f, %.0f) => SALIDA: %.4f\n", input[0], input[1], prediction);
        }

        System.out.println("\n=== ENTRENAMIENTON PARA COMPURTA OR ===");
        SigmoidPerceptron orPerceptron = new SigmoidPerceptron(2, learningRate);
        orPerceptron.train(inputData, orOutput, epochs);
        orPerceptron.printParameters();

        System.out.println("RESULTADOS PARA  OR:");
        for (double[] input : inputData) {
            double prediction = orPerceptron.predict(input);
            System.out.printf("ENTRADA: (%.0f, %.0f) => SALIDA: %.4f\n", input[0], input[1], prediction);
        }
    }
}
