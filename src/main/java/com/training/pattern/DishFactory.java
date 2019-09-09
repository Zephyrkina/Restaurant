package com.training.pattern;

import com.training.entity.Eatable;
import com.training.entity.extra.ExtraType;
import com.training.entity.product.ProductType;
import com.training.entity.extra.Ketchup;
import com.training.entity.extra.Mustard;
import com.training.entity.product.Chips;
import com.training.entity.product.Hotdog;


public class DishFactory{

    public Eatable createDish(ProductType product, ExtraType extra) {

        Eatable orderedDish;

        if(product.equals(ProductType.CHIPS)) {
            orderedDish = new Chips();
        } else if (product.equals(ProductType.HOT_DOG)) {
            orderedDish = new Hotdog();
        } else {
            throw new RuntimeException("Product not found");
        }

        if(extra.equals(ExtraType.KETCHUP)){
            orderedDish = new Ketchup(orderedDish);
        } else if (extra.equals(ExtraType.MUSTARD)) {
            orderedDish = new Mustard(orderedDish);
        } else if (extra.equals(ExtraType.UNDEFINED)) {
            // nothing to do
        }

        return orderedDish;
    }
}
