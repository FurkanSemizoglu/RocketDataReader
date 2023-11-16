public class KalmanFilter {
    private double processNoise; // Process noise covariance
    private double measurementNoise; // Measurement noise covariance
    private double state; // Current state estimate
    private double errorCovariance; // Current error covariance

    public KalmanFilter(double initialEstimate, double initialError, double processNoise, double measurementNoise) {
        this.state = initialEstimate;
        this.errorCovariance = initialError;
        this.processNoise = processNoise;
        this.measurementNoise = measurementNoise;
    }

    public double update(double measurement) {
        // Prediction
        double prediction = state;
        double predictionError = errorCovariance + processNoise;

        // Update
        double kalmanGain = predictionError / (predictionError + measurementNoise);
        state = prediction + kalmanGain * (measurement - prediction);
        errorCovariance = (1 - kalmanGain) * predictionError;

        return state;
    }

    public double getState() {
        return state;
    }
}
