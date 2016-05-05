package com.example.test_color;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

@InjectViewState
public class SubjectEditPresenter extends MvpPresenter<SubjectEditView> {

    public void loadTeachers(){
        getViewState().showTeachers(ModelTeachers.getTeachers());
    }

    public void saveSubject(String name, int teachersPosition, int colorPosition){
        getViewState().onSubjectSaved();
    }

    public void onSubjectColorSelected(int color) {
        getViewState().onSubjectColorSelected(color);
    }

}
