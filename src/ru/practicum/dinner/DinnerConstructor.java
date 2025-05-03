package ru.practicum.dinner;

import java.util.Random;
import java.util.ArrayList;
import java.util.HashMap;

public class DinnerConstructor {
    HashMap<String, ArrayList<String>> dishesByCategories;

    DinnerConstructor(){
        dishesByCategories = new HashMap<>();
    }

    void addNewDish(String dishType, String dishName){
        if (dishesByCategories.containsKey(dishType)){
            dishesByCategories.get(dishType).add(dishName);
        } else {
            ArrayList<String> newDishList = new ArrayList<>();
            newDishList.add(dishName);
            dishesByCategories.put(dishType, newDishList);
        }
    }

    ArrayList<String> generateDishCombo(ArrayList<String> types){
        ArrayList<String> output = new ArrayList<>();
        Random random = new Random();
        for (String type : types){
            ArrayList<String> dishesInType = dishesByCategories.get(type);
            output.add(dishesInType.get(random.nextInt(dishesInType.size())));
        }
        return output;
    }

    boolean contains(String type){
        return dishesByCategories.containsKey(type);
    }
}
