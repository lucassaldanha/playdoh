package com.lsoftware.playdoh;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class PlaydohConfigurationTest {

    private PlaydohConfiguration playdohConfiguration;

    @Before
    public void setUp() throws Exception {
        playdohConfiguration = PlaydohConfiguration.getInstance();
    }

    @Test
    public void testSetFixtureObjectBuilderShouldConfigureCorrectly() {
        playdohConfiguration.setFixtureObjectBuilder(new YamlFixtureObjectBuilder());
        assertTrue(playdohConfiguration.getFixtureObjectBuilder() instanceof YamlFixtureObjectBuilder);
    }

}