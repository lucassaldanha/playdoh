package com.lsoftware.playdoh.generator;

import org.apache.commons.lang3.RandomStringUtils;

public class CharacterGenerator extends AbstractGenerator<Character> {

    //TODO parametrize to allow returning alphabetic and alphanumeric char only

    public Character generate() {
        return RandomStringUtils.random(1).toCharArray()[0];
    }
}
