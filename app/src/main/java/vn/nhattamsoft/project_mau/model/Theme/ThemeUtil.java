package vn.nhattamsoft.project_mau.model.Theme;

import vn.nhattamsoft.project_mau.R;

public class ThemeUtil {
    public static final int THEME_RED = 0;
    public static final int THEME_PINK = 1;
    public static final int THEME_PURPLE = 2;
    public static final int THEME_DEEPPURPLE = 3;
    public static final int THEME_INDIGO = 4;

    public static int getThemeId(int theme){
        int themeId=0;
        switch (theme){
            case THEME_RED  :
                themeId = R.style.Theme_project_mau;
                break;
            case THEME_PINK  :
                themeId = R.style.Theme_project_mau_Theme1;
                break;
            case THEME_PURPLE  :
                themeId = R.style.Theme_project_mau_Theme2;
                break;
            case THEME_DEEPPURPLE  :
                themeId = R.style.Theme_project_mau_Theme3;
                break;
            case THEME_INDIGO  :
                themeId = R.style.Theme_project_mau_Theme4;
                break;
            default:
                break;
        }
        return themeId;
    }

//    public static ArrayList<Theme> getThemeList(){
//        ArrayList<Theme> themeArrayList = new ArrayList<>();
//        themeArrayList.add(new Theme(0,R.color.primaryColorRed, R.color.primaryDarkColorRed, R.color.secondaryColorRed));
//        themeArrayList.add(new Theme(1,R.color.primaryColorPink, R.color.primaryDarkColorPink, R.color.secondaryColorPink));
//        themeArrayList.add(new Theme(2,R.color.primaryColorPurple, R.color.primaryDarkColorPurple, R.color.secondaryColorPurple));
//        themeArrayList.add(new Theme(3,R.color.primaryColorDeepPurple, R.color.primaryDarkColorDeepPurple, R.color.secondaryColorDeepPurple));
//        themeArrayList.add(new Theme(4,R.color.primaryColorIndigo, R.color.primaryDarkColorIndigo, R.color.secondaryColorIndigo));
//        return themeArrayList;
//    }
}
