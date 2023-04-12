package com.example.firstpractice.data.sources;

import com.example.firstpractice.R;

public class LuckyPerfumeDataSource {
    private static final String[] names = {"Tom Ford Lost Cherry", "Franck Boclet", "Baccarat Rouge 540", "Tiffany & CO", "LACOSTE L.12.12"};
    private static final Integer[] images = {R.drawable.tomfordlostcherry, R.drawable.franckboclet, R.drawable.baccaratrouge540, R.drawable.tiffany_co, R.drawable.lacoste_l_12_12};


    public static String getName(int index){
        return names[index];
    }

    public static Integer getImage(int index){
        return images[index];
    }
}
