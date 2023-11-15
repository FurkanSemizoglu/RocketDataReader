public class   Rocket{
    private int sıcaklık;
    private int basınç;
    private int eğim;


    public Rocket(int sıcaklık ,int basınç , int eğim){
        this.sıcaklık = sıcaklık;
        this.basınç = basınç;
        this.eğim = eğim;

    }

    public void setSıcaklık(int sıcaklık) {
        this.sıcaklık = sıcaklık;
    }

    public void setBasınç(int basınç) {
        this.basınç = basınç;
    }

    public void setEğim(int eğim) {
        this.eğim = eğim;
    }

    public int getSıcaklık() {
        return sıcaklık;
    }

    public int getBasınç() {
        return basınç;
    }

    public int getEğim() {
        return eğim;
    }
}
