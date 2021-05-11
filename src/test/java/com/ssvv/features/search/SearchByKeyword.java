package com.ssvv.features.search;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.ssvv.steps.serenity.EndUserSteps;

@RunWith(SerenityRunner.class)
public class SearchByKeyword {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    public EndUserSteps anna;

    @Issue("#WIKI-1")
    @Test
    public void searching_by_keyword_apple_should_display_the_corresponding_article() {
        anna.is_the_home_page();
        anna.looks_for("apple");
        anna.should_see_definition("A common, round fruit produced by the tree Malus domestica, cultivated in temperate climates.");

    }

    @Test
    public void searching_by_keyword_banana_should_display_the_corresponding_article() {
        anna.is_the_home_page();
        anna.looks_for("pear");
        anna.should_see_definition("An edible fruit produced by the pear tree, similar to an apple but elongated towards the stem.");
    }

    @Test
    public void searching_by_keyword_monkey() {
        anna.is_the_home_page();
        anna.looks_for("monkey");
        anna.should_see_definition("Any member of the clade Simiiformes not also of the clade Hominoidea containing humans and apes, from which they are usually, but not universally, distinguished by smaller size, a tail, and cheek pouches.");
    }

    @Test
    public void searching_by_keyword_bear() {
        anna.is_the_home_page();
        anna.looks_for("bear");
        anna.should_see_definition("A large omnivorous mammal, related to the dog and raccoon, having shaggy hair, a very small tail, and flat feet; a member of family Ursidae");
    }

    @Pending @Test
    public void searching_by_ambiguious_keyword_should_display_the_disambiguation_page() {
    }
}