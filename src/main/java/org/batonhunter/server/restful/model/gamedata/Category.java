package org.batonhunter.server.restful.model.gamedata;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;
import org.batonhunter.server.restful.model.PrimaryObject;

import java.util.Collection;

/**
 * Created by ianchiu on 2015/8/25.
 */
@DatabaseTable(tableName = "categories")
public class Category implements PrimaryObject{
    @DatabaseField(id = true, unique = true)
    private String title;
    @DatabaseField
    private String imgPath;
    @ForeignCollectionField
    private Collection<SubCategory> subCategories;

    public Category(){}

    public Category(String title, String imgPath, Collection<SubCategory> subCategories){
        this.title = title;
        this.imgPath = imgPath;
        this.subCategories = subCategories;
    }

    public String getTitle(){
        return title;
    }

    public Collection<SubCategory> getSubCategories() {
        return subCategories;
    }

    @Override
    public void removeForeignObject() {
        this.subCategories = null;
    }
}
