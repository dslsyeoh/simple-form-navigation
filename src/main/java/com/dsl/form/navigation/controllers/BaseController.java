/*
 * Author Steven Yeoh
 * Copyright (c) 2019. All rights reserved
 */

package com.dsl.form.navigation.controllers;

import com.dsl.form.navigation.utils.NavigateManager;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.tbee.javafx.scene.layout.MigPane;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

@Component("baseController")
public class BaseController implements Initializable
{
    @FXML
    private BorderPane rootPane;

    @FXML
    private MigPane content;

    @FXML
    private Parent page1;

    @FXML
    private Parent page2;

    @FXML
    private Parent page3;

    private List<Parent> history = new ArrayList<>();

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        history.add(content);
    }

    @Bean
    public NavigateManager navigateManger()
    {
        return new NavigateManager()
        {
            @Override
            public void navigateTo(Parent parent)
            {
                rootPane.setCenter(parent);
            }

            public void addHistory(Parent parent)
            {
                history.add(parent);
            }

            @Override
            public void removeHistory()
            {
                history.remove(history.get(history.size() - 1));
            }

            @Override
            public List<Parent> getHistory()
            {
                return history;
            }
        };
    }

    @FXML
    private void jumpToPage1()
    {
        navigateManger().addHistory(page1);
        navigateManger().navigateTo(page1);
    }

    @FXML
    private void jumpToPage2()
    {
        navigateManger().addHistory(page2);
        navigateManger().navigateTo(page2);
    }

    @FXML
    private void jumpToPage3()
    {
        navigateManger().addHistory(page3);
        navigateManger().navigateTo(page3);
    }
}
