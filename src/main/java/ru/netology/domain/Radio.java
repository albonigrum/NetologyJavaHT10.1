package ru.netology.domain;

import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Data
public class Radio {
    public final int VOLUME_MAX = 100;
    private int countRadiostations = 10;
    private int radiostationNumber = 0;
    private int volume = 0;

    Radio(int countRadiostations) {
        this.countRadiostations = countRadiostations;
    }

    public void setRadiostationNumber(int radiostationNumber) {
        if (radiostationNumber < 0 || radiostationNumber > countRadiostations - 1)
            return;
        this.radiostationNumber = radiostationNumber;
    }

    public void prevRadioStation() {
        radiostationNumber = (radiostationNumber + countRadiostations - 1) % countRadiostations;
    }

    public void nextRadioStation() {
        radiostationNumber = (radiostationNumber + 1) % countRadiostations;
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
