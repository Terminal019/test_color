package com.example.test_color;


public class PresenterMVP {
    private ViewMVP viewMVP;

    public PresenterMVP(ViewMVP view) {
        this.viewMVP = view;
    }

    public void loadTeachers(){
        viewMVP.showTeachers(ModelMVP.getTeachers());
    }

    public void saveSubject(String name, int teachersPosition, int colorPosition){
        viewMVP.onSubjectSaved();
    }

}
