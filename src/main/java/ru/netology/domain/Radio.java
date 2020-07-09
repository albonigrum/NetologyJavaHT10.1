package ru.netology.domain;

public class Radio {
    private int radioStationNumber;
    private int volume;

    public int getRadioStationNumber() {
        return radioStationNumber;
    }

    public void setRadioStationNumber(int radioStationNumber) {
        if (radioStationNumber < 0 || radioStationNumber > 9)
            return;
        this.radioStationNumber = radioStationNumber;
    }

    public int getVolume() {
        return volume;
    }

    public void prevRadioStation() {
        radioStationNumber = (radioStationNumber + 9) % 10;
    }

    public void nextRadioStation() {
        radioStationNumber = (radioStationNumber + 1) % 10;
    }

    public void increaseVolume() {
        if (volume == 10)
            return;
        ++volume;
    }

    public void decreaseVolume() {
        if (volume == 0)
            return;
        --volume;
    }

}
