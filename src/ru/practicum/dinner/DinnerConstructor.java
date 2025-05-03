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

    }

    void generateDishCombo(int quantity, ArrayList<String> dishes){

    }

    boolean contains(String type){
        return dishesByCategories.containsKey(type);
    }
}
