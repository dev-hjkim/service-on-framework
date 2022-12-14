package com.fw.data;

import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.Map;

public class YamlReader {
    public static Map<String, Object> getMap(String yamlName) {

        InputStream inputStream = null;

        try {

            ClassLoader cl = YamlReader.class.getClassLoader();

            yamlName = yamlName.replaceAll("\\.", "\\/");

            yamlName = yamlName + ".yaml";

            inputStream = cl.getResourceAsStream(yamlName);

            Yaml yaml = new Yaml();
            Map<String, Object> map = yaml.load(inputStream);

            String path = cl.getResource(yamlName).getPath();
            map.put("THIS_YAML_URL", path);

            return map;

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }

    }
}
