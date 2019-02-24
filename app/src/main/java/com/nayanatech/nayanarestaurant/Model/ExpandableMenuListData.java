package com.nayanatech.nayanarestaurant.Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ExpandableMenuListData {
    public static HashMap<String, List<String>> getData() {
        HashMap<String, List<String>> expandableListDetail = new HashMap<String, List<String>>();

        List<String> chicken = new ArrayList<String>();
        chicken.add("Chicken Biriyani");
        chicken.add("Chilly Chicken");
        chicken.add("Chicken Curry");
        chicken.add("Chicken Butter Masala");
        chicken.add("Chicken Tandoor");

        List<String> Paneer = new ArrayList<String>();
        Paneer.add("Paneer Biriyani");
        Paneer.add("Paneer Masala");
        Paneer.add("Paneer Curry");
        Paneer.add("Paneer Butter Masala");
        Paneer.add("Paneer Tandoor");

        List<String> egg = new ArrayList<String>();
        egg.add("Egg Biriyani");
        egg.add("Egg Curry");
        egg.add("Egg Bhurji");
        egg.add("Egg Masala");
        egg.add("Egg Amlet");

        List<String> mutton = new ArrayList<String>();
        mutton.add("Mutton Biriyani");
        mutton.add("Mutton Curry");
        mutton.add("Mutton Bhurji");
        mutton.add("Mutton Masala");
        mutton.add("Mutton Amlet");

        List<String> fish = new ArrayList<String>();
        fish.add("Fish Biriyani");
        fish.add("Fish Curry");
        fish.add("Fish Bhurji");
        fish.add("Fish Masala");
        fish.add("Fish Amlet");

        expandableListDetail.put("CHICKEN", chicken);
        expandableListDetail.put("PANEER",Paneer );
        expandableListDetail.put("EGG", egg);
        expandableListDetail.put("MUTTON", mutton);
        expandableListDetail.put("FISH", fish);
        return expandableListDetail;
    }

}
