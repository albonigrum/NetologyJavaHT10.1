package ru.netology.domain;

public class Radio {
    public final int VOLUME_MAX = 100;
    private int countRadiostations = 10;
    private int radioStationNumber = 0;
    private int volume = 0;

    Radio() {}

    Radio(int countRadiostations) {
        this.countRadiostations = countRadiostations;
    }

    public int getCountRadiostations() {
        return countRadiostations;
    }

    public int getRadioStationNumber() {
        return radioStationNumber;
    }

    public void setRadioStationNumber(int radioStationNumber) {
        if (radioStationNumber < 0 || radioStationNumber > countRadiostations - 1)
            return;
        this.radioStationNumber = radioStationNumber;
    }

    public int getVolume() {
        return volume;
    }

    public void prevRadioStation() {
        radioStationNumber = (radioStationNumber + countRadiostations - 1) % countRadiostations;
    }

    public void nextRadioStation() {
        radioStationNumber = (radioStationNumber + 1) % countRadiostations;
    }

    public void increaseVolume() {
        if (volume == VOLUME_MAX)
            return;
        ++volume;
    }

    public void decreaseVolume() {
        if (volume == 0)
            return;
        --volume;
    }
}
