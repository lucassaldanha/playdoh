package com.lsoftware.playdoh.regex;

import com.mifmif.common.regex.Generex;

public class GenerexResolver implements RegexResolver {

    @Override
    public String generate(String regex) {
        return new Generex(regex).random();
    }
}
