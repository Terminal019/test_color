package com.example.test_color;


import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

@StateStrategyType(AddToEndSingleStrategy.class)
public interface SubjectEditView extends MvpView {

    void showTeachers(String[] teachers);
    void onSubjectColorSelected(int color);
    void onSubjectSaved();

}
