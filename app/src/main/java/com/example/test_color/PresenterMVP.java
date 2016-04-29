package com.example.test_color;


public class PresenterMvp {
    private ViewMvp viewMVP;

    public PresenterMvp(ViewMvp view) {
        this.viewMVP = view;
    }

    public void loadTeachers(){
        viewMVP.showTeachers(ModelMvp.getTeachers());
    }

    public void saveSubject(String name, int teachersPosition, int colorPosition){
        viewMVP.onSubjectSaved();
    }

}
