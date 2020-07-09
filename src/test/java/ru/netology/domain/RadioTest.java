package ru.netology.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

class RadioTest {

    @Test
    void shouldCreateRadio() {
        Radio radioNoArg = new Radio();
        assertEquals(10, radioNoArg.getCountRadiostations());
        Radio radioOneArg = new Radio(100);
        assertEquals(100, radioOneArg.getCountRadiostations());
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/data_for_tests.csv")
    void shouldSetAndGetRadiostationNumber(int countRadiostations) {
        Radio radio = new Radio(countRadiostations);
        assertEquals(0, radio.getRadioStationNumber());

        radio.setRadioStationNumber(0);
        assertEquals(0, radio.getRadioStationNumber());

        radio.setRadioStationNumber(countRadiostations / 2);
        assertEquals(countRadiostations / 2, radio.getRadioStationNumber());

        radio.setRadioStationNumber(countRadiostations - 1);
        assertEquals(countRadiostations - 1, radio.getRadioStationNumber());

        radio.setRadioStationNumber(countRadiostations);
        assertEquals(countRadiostations - 1, radio.getRadioStationNumber());

        radio.setRadioStationNumber(-1);
        assertEquals(countRadiostations - 1, radio.getRadioStationNumber());
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/data_for_tests.csv")
    void shouldNextRadioStation(int countRadiostations) {
        Radio radio = new Radio(countRadiostations);

        radio.setRadioStationNumber(0);

        for (int i = 0; i < countRadiostations; ++i) {
            assertEquals(i, radio.getRadioStationNumber());
            radio.nextRadioStation();
        }
        assertEquals(0, radio.getRadioStationNumber());
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/data_for_tests.csv")
    void shouldPrevRadioStation(int countRadiostations) {
        Radio radio = new Radio(countRadiostations);

        radio.setRadioStationNumber(0);

        for (int i = 0, j = 0; j < countRadiostations; i = (countRadiostations - 1 + i) % countRadiostations, ++j) {
            assertEquals(i, radio.getRadioStationNumber());
            radio.prevRadioStation();
        }
        assertEquals(0, radio.getRadioStationNumber());
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/data_for_tests.csv")
    void increaseAndDecreaseVolume(int countRadiostations) {
        Radio radio = new Radio(countRadiostations);

        for (int expectedVolume = 0; expectedVolume <= radio.VOLUME_MAX; ++expectedVolume){
            assertEquals(expectedVolume, radio.getVolume());
            radio.increaseVolume();
        }
        assertEquals(radio.VOLUME_MAX, radio.getVolume());

        for (int expectedVolume = radio.VOLUME_MAX; expectedVolume >= 0; --expectedVolume){
            assertEquals(expectedVolume, radio.getVolume());
            radio.decreaseVolume();
        }
        assertEquals(0, radio.getVolume());

    }
}