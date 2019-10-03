package edu.daffodil.cdc.helper;

import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

public class ParentExpandable extends ExpandableGroup<ChildExpandable> {
    public ParentExpandable(String title, List<ChildExpandable> items) {
        super(title, items);
    }

}
