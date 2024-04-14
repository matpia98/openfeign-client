package com.example.openfeignclient;

public record Song(String name, String artist) {
    @Override
    public String toString() {
        return String.format("Song{name='%s', artist='%s'}", name, artist);
    }
}
