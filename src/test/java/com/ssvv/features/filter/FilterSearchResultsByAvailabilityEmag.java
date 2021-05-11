package com.ssvv.features.filter;

import com.ssvv.steps.serenity.EmagEndUserSteps;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom("src/test/resources/features/filter/emagFilterSearchTestData.csv")
public class FilterSearchResultsByAvailabilityEmag {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    public EmagEndUserSteps emagEndUser;

    public String item;

    public String brand;

    public Boolean success;

    public void setItem(String item) {
        this.item = item;
    }

    public String getItem() {
        return item;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public void setSuccess(String success) {
        this.success = Boolean.valueOf(success);
    }

    public boolean getSuccess() {
        return success;
    }

    @Test
    public void filtering_search_by_availability() {
        emagEndUser.is_the_home_page();
        emagEndUser.looks_for(getItem());
        if (getSuccess()) {
            emagEndUser.filters_search_results_by_brand(getItem());
        }
    }
}
