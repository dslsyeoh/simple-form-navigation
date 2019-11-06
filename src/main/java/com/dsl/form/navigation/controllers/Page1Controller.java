/*
 * Author Steven Yeoh
 * Copyright (c) 2019. All rights reserved
 */

package com.dsl.form.navigation.controllers;

import com.dsl.form.navigation.utils.NavigateManager;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("page1Controller")
public class Page1Controller
{
    @FXML
    private Parent page2;

    @FXML
    private Parent page3;

    @Autowired
    private NavigateManager navigateManager;

    @FXML
    private void next()
    {
        navigateManager.addHistory(page2);
        navigateManager.navigateTo(page2);
    }

    @FXML
    private void back()
    {
        navigateManager.removeHistory();
        navigateManager.navigateTo(navigateManager.getHistory().get(navigateManager.getHistory().size() - 1));
    }

    @FXML
    public void jumpToPage3()
    {
        navigateManager.addHistory(page3);
        navigateManager.navigateTo(page3);
    }
    @FXML
    public void showHistory()
    {
        navigateManager.getHistory().forEach(parent -> System.out.print(parent + " -> "));
    }
}
