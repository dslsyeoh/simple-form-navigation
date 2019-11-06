/*
 * Author Steven Yeoh
 * Copyright (c) 2019. All rights reserved
 */

package com.dsl.form.navigation;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Main extends Application
{
    private ConfigurableApplicationContext context;

    @Override
    public void init() throws Exception
    {
        context = SpringApplication.run(Main.class);
        context.getAutowireCapableBeanFactory().autowireBean(this);
    }

    @Override
    public void start(Stage stage) throws Exception
    {
        Parent parent = ContextProvider.load(Main.class.getResource("/base.fxml"));
        Scene scene = new Scene(parent, 800, 600);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void stop() throws Exception
    {
        context.stop();
    }
}
