
package com.haerul.foodsapp.view.detail;

import com.haerul.foodsapp.model.Meals;

import java.util.List;

public interface DetailView {
    void showLoading();
    void hideLoading();
    void setMeals(Meals.Meal meal);
    void onErrorLoading(String message);
}
