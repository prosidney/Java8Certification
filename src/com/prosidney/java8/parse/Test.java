package com.prosidney.java8.parse;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sidney on 2017-03-17.
 */
public class Test {

    public static void main(String args[]) throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Model model = parse(new Model());
        System.out.println(model);
    }

    private static Model parse(Model model) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        model.setList(null);

        Field[] declaredFields = model.getClass().getDeclaredFields();

        for (Field field: declaredFields) {


            if((field.getType() == java.util.List.class)) {
                Type genericListType = ((ParameterizedType) field.getGenericType()).getActualTypeArguments()[0];
                ChildModel child = (ChildModel) ((Class) genericListType).newInstance();
                child.setName("Oi");

                if (model.getList() == null){
                    field.getName();
                    Method set = model.getClass().getDeclaredMethod("setList", List.class);
                    set.invoke(model, new ArrayList<>());
                }
                
                Method add = List.class.getDeclaredMethod("add", Object.class);
                add.invoke(model.getList(), child);
            }
        }

        return model;
    }
}
