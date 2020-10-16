package com.company.Methods;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class ClassInformationHelper {


    public <T> Map<String, Object> getHashMap(String fileName, String Package, T object) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, ClassNotFoundException {
        Class cls = Class.forName("com.company." + Package + "." + fileName);
        Map<String, Object> hash = new HashMap<String, Object>();
        for (int i = 0; i < cls.getDeclaredFields().length; i++) {
            Object obje;
            String fieldName = cls.getDeclaredFields()[i].getName();
            if (cls.getDeclaredFields()[i].getType().getName().equals("boolean")) {
                fieldName = Character.toUpperCase(fieldName.charAt(0)) + fieldName.substring(1);
                obje = cls.getMethod("is" + fieldName).invoke(object);

                hash.put(fieldName, obje);

            } else {
                fieldName = Character.toUpperCase(fieldName.charAt(0)) + fieldName.substring(1);
                obje = cls.getMethod("get" + fieldName).invoke(object);
                hash.put(fieldName, obje);

            }

        }
        return hash;
    }
}

