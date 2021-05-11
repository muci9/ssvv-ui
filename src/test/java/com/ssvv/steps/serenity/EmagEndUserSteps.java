package com.ssvv.steps.serenity;

import com.ssvv.pages.EmagPage;
import net.thucydides.core.annotations.Step;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;

public class EmagEndUserSteps {

    private EmagPage emagPage;

    @Step
    public void enters(String keyword) {
        emagPage.enter_keywords(keyword);
    }

    @Step
    public void starts_search() {
        emagPage.lookup_terms();
    }

    @Step
    public void should_see_search_result_title(String item) {
        assertThat(emagPage.getSearchResultsTitles(), hasItem(containsString(item)));
    }

    @Step
    public void filters_search_results_by_brand(String brand) {
        emagPage.filter_by_brand(brand);
    }

    @Step
    public void is_the_home_page() {
        emagPage.open();
    }

    @Step
    public void looks_for(String term) {
        enters(term);
        starts_search();
    }
}
