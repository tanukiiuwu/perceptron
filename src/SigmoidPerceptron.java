public class SigmoidPerceptron {
    private double[] weights;
    private double bias;
    private double learningRate;

    public SigmoidPerceptron(int inputSize, double learningRate) {
        weights = new double[inputSize];
        bias = Math.random() * 2 - 1;
        this.learningRate = learningRate;
        for (int i = 0; i < inputSize; i++) {
            weights[i] = Math.random() * 2 - 1;
        }
    }


    private double sigmoid(double x) {
        return 1 / (1 + Math.exp(-x));
    }


    private double sigmoidDerivative(double x) {
        return x * (1 - x);
    }


    public double predict(double[] input) {
        double sum = bias;
        for (int i = 0; i < weights.length; i++) {
            sum += weights[i] * input[i];
        }
        return sigmoid(sum);
    }


    public void train(double[][] inputs, double[] targets, int epochs) {
        for (int epoch = 0; epoch < epochs; epoch++) {
            for (int i = 0; i < inputs.length; i++) {
                double output = predict(inputs[i]);
                double error = targets[i] - output;


                for (int j = 0; j < weights.length; j++) {
                    weights[j] += learningRate * error * sigmoidDerivative(output) * inputs[i][j];
                }


                bias += learningRate * error * sigmoidDerivative(output);
            }
        }
    }


    public void printParameters() {
        System.out.print("Pesos: ");
        for (double w : weights) {
            System.out.printf("%.4f ", w);
        }
        System.out.printf(" | Bias: %.4f\n", bias);
    }
}
