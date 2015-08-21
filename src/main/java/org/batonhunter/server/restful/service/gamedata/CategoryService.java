package org.batonhunter.server.restful.service.gamedata;

import org.batonhunter.server.restful.model.gamedata.Category;
import org.batonhunter.server.restful.util.TestData;

import java.util.ArrayList;

/**
 * Created by ianchiu on 2015/8/21.
 */
public class CategoryService {

    public ArrayList<Category> getAllCategory(){
        return new TestData().getCategories();
    }
}
