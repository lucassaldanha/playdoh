package com.lsoftware.playdoh.reader;

import java.util.Map;

public interface ModelReader {

    <T> Map<String, T> read(Class<T> type);

    <T> T read(String identifier, Class<T> type);

}
