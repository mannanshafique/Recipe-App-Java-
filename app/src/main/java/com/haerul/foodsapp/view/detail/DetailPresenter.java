
package com.haerul.foodsapp.view.detail;

import android.support.annotation.NonNull;

import com.haerul.foodsapp.Utils;
import com.haerul.foodsapp.model.Meals;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailPresenter {
    private DetailView view;

    public DetailPresenter(DetailView view) {
        this.view = view;
    }

    void getMealById(String mealName) {

        //  Make request meals by category
        view.showLoading();
       Utils.getApi().getMealBySearch(mealName)
               .enqueue(new Callback<Meals>() {
                   @Override
                   public void onResponse(@NonNull Call<Meals> call,@NonNull Response<Meals> response) {
                       view.hideLoading();
                       if(response.isSuccessful() && response.body() != null){
                           view.setMeals(response.body().getMeals().get(0));
                       }else{
                           view.onErrorLoading(response.message());
                       }
                   }

                   @Override
                   public void onFailure(@NonNull Call<Meals> call, @NonNull Throwable t) {
                       view.onErrorLoading(t.getLocalizedMessage());
                       view.hideLoading();
                   }
               });

    }
}
