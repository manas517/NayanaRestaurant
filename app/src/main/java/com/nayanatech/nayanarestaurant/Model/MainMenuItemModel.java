package com.nayanatech.nayanarestaurant.Model;

import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

public class MainMenuItemModel extends ExpandableGroup<SubItemDemo> {

    public MainMenuItemModel(String title, List<SubItemDemo> items) {
        super(title, items);
    }
}
