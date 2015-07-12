package com.lsoftware.playdoh;

public class PlaydohConfiguration {

    private static PlaydohConfiguration SOLE_INSTANCE = new PlaydohConfiguration();

    private FixtureObjectBuilder fixtureObjectBuilder;

    private PlaydohConfiguration() {
        loadDefaultConfiguration();
    }

    public static PlaydohConfiguration getInstance() {
        return SOLE_INSTANCE;
    }

    private void loadDefaultConfiguration() {
        fixtureObjectBuilder = new YamlFixtureObjectBuilder();
    }

    public PlaydohConfiguration setFixtureObjectBuilder(FixtureObjectBuilder fixtureObjectBuilder) {
        this.fixtureObjectBuilder = fixtureObjectBuilder;
        return this;
    }

    protected FixtureObjectBuilder getFixtureObjectBuilder() {
        return fixtureObjectBuilder;
    }
}
