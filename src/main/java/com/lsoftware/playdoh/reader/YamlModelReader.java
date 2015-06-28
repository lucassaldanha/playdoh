package com.lsoftware.playdoh.reader;

import com.lsoftware.playdoh.exception.FixtureNotFoundException;
import com.lsoftware.playdoh.util.CaseUtils;
import com.lsoftware.playdoh.util.FileUtils;
import org.yaml.snakeyaml.Yaml;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class YamlModelReader implements ModelReader {

    private FileUtils fileUtils;

    private Yaml yaml;

    public YamlModelReader() {
        this.fileUtils = new FileUtils();
        this.yaml = new Yaml();
    }

    @Override
    public <T> Map<String, T> read(Class<T> type) {
        Map<String, T> objects = new HashMap<String, T>();
        try {
            InputStream inputStream = fileUtils.readFileFromClasspath(getYamlFilename(type));
            Map map = (Map) yaml.load(inputStream);

            if(map != null) {
                for (Object o : map.keySet()) {
                    String key = (String) o;
                    objects.put(key, yaml.loadAs(yaml.dump(map.get(key)), type));
                }
            }

            return objects;
        } catch (FileNotFoundException e) {
            throw new FixtureNotFoundException(getYamlFilename(type));
        }
    }

    @Override
    public <T> T read(String identifier, Class<T> type) {
        try {
            InputStream inputStream = fileUtils.readFileFromClasspath(getYamlFilename(type));
            Map map = (Map) yaml.load(inputStream);
            Object obj = map.get(identifier);
            return yaml.loadAs(yaml.dump(obj), type);
        } catch (FileNotFoundException e) {
            throw new FixtureNotFoundException(getYamlFilename(type));
        }
    }

    private <T> String getYamlFilename(Class<T> type) {
        return CaseUtils.toSnakeCase(type.getSimpleName()) + ".yml";
    }

    void setFileUtils(FileUtils fileUtils) {
        this.fileUtils = fileUtils;
    }


    void setYaml(Yaml yaml) {
        this.yaml = yaml;
    }
}
