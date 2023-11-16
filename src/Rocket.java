public class   Rocket{
    private long sıcaklık;
    private long basınç;
    private long eğim;

    private KalmanFilter sıcaklıkFilter;
    private KalmanFilter basıncFilter;
    private KalmanFilter eğimFilter;

    public Rocket(long sıcaklık ,long basınç , long eğim){

        this.sıcaklık = sıcaklık;
        this.basınç = basınç;
        this.eğim = eğim;




        this.sıcaklıkFilter = new KalmanFilter(sıcaklık, 1.0, 0.01, 1.0);
        this.basıncFilter = new KalmanFilter(basınç, 1.0, 0.01, 1.0);
        this.eğimFilter = new KalmanFilter(eğim, 1.0, 0.01, 1.0);
    }


    public void updateMeasurements(long newSicaklik, long newBasinc, long newEgim) {
        // Update measurements using the Kalman filter
        double filteredSicaklik = sıcaklıkFilter.update(newSicaklik);
        double filteredBasinc = basıncFilter.update(newBasinc);
        double filteredEgim = eğimFilter.update(newEgim);

        // Update Rocket state with filtered measurements
        this.sıcaklık = (long) filteredSicaklik;
        this.basınç = (long) filteredBasinc;
        this.eğim = (long) filteredEgim;
    }
    public void setSıcaklık(long sıcaklık) {
        this.sıcaklık = sıcaklık;
    }

    public void setBasınç(long basınç) {
        this.basınç = basınç;
    }

    public void setEğim(long eğim) {
        this.eğim = eğim;
    }

    public long getSıcaklık() {
        return sıcaklık;
    }

    public long getBasınç() {
        return basınç;
    }

    public long getEğim() {
        return eğim;
    }
}
