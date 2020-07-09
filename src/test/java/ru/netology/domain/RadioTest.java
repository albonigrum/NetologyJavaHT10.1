package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RadioTest {

    @Test
    void shouldSetAndGetRadioStationNumber() {
        Radio radio = new Radio();
        assertEquals(0, radio.getRadioStationNumber());

        radio.setRadioStationNumber(0);
        assertEquals(0, radio.getRadioStationNumber());

        radio.setRadioStationNumber(5);
        assertEquals(5, radio.getRadioStationNumber());

        radio.setRadioStationNumber(9);
        assertEquals(9, radio.getRadioStationNumber());

        radio.setRadioStationNumber(11);
        assertEquals(9, radio.getRadioStationNumber());

        radio.setRadioStationNumber(-1);
        assertEquals(9, radio.getRadioStationNumber());
    }

    @Test
    void shouldNextRadioStation() {
        Radio radio = new Radio();

        int [] possibleOptions = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        radio.setRadioStationNumber(possibleOptions[0]);

        for (int possibleOption : possibleOptions) {
            assertEquals(possibleOption, radio.getRadioStationNumber());
            radio.nextRadioStation();
        }
        assertEquals(possibleOptions[0], radio.getRadioStationNumber());

    }

    @Test
    void shouldPrevRadioStation() {
        Radio radio = new Radio();

        int [] possibleOptions = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};

        radio.setRadioStationNumber(possibleOptions[0]);

        for (int possibleOption : possibleOptions) {
            assertEquals(possibleOption, radio.getRadioStationNumber());
            radio.prevRadioStation();
        }
        assertEquals(possibleOptions[0], radio.getRadioStationNumber());
    }

    @Test
    void increaseAndDecreaseVolume() {
        Radio radio = new Radio();

        for (int expectedVolume = 0; expectedVolume <= 10; ++expectedVolume){
            assertEquals(expectedVolume, radio.getVolume());
            radio.increaseVolume();
        }
        assertEquals(10, radio.getVolume());

        for (int expectedVolume = 10; expectedVolume >= 0; --expectedVolume){
            assertEquals(expectedVolume, radio.getVolume());
            radio.decreaseVolume();
        }
        assertEquals(0, radio.getVolume());

    }
}