package com.lsoftware.playdoh.exception;

public class FixtureNotFoundException extends PlaydohException {

    public FixtureNotFoundException(String fixtureName) {
        super("Can't find " + fixtureName + " fixture on classpath");
    }
}
