/*
 * Author Steven Yeoh
 * Copyright (c) 2019. All rights reserved
 */

package com.dsl.form.navigation.controllers;

import com.dsl.form.navigation.utils.NavigateManager;
import javafx.fxml.FXML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("page3Controller")
public class Page3Controller
{
    @Autowired
    private NavigateManager navigateManager;

    @FXML
    private void next()
    {
        System.out.println("This is last page");
    }

    @FXML
    private void back()
    {
        navigateManager.removeHistory();
        navigateManager.navigateTo(navigateManager.getHistory().get(navigateManager.getHistory().size() - 1));
    }

    @FXML
    public void showHistory()
    {
        navigateManager.getHistory().forEach(parent -> System.out.print(parent + " -> "));
    }
}
