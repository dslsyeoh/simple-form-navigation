/*
 * Author Steven Yeoh
 * Copyright (c) 2019. All rights reserved
 */

package com.dsl.form.navigation.utils;

import javafx.scene.Parent;
import java.util.List;

public interface NavigateManager
{
    void navigateTo(Parent parent);

    void addHistory(Parent parent);

    void removeHistory();

    List<Parent> getHistory();
}
