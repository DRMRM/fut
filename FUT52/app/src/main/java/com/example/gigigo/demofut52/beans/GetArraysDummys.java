package com.example.gigigo.demofut52.beans;

import java.util.ArrayList;

/**
 * Created by Davis on 7/2/15.
 */
public class GetArraysDummys {

    public static ArrayList<Gallery_Bean>getGallerys(){
        ArrayList<Gallery_Bean>items=new ArrayList<>();

        Gallery_Bean gallery1=new Gallery_Bean("Item ","http://www.jordankranda.com/wp-content/uploads/2014/02/girls-wallpaper-mediastaan-22.jpg");
        Gallery_Bean gallery2=new Gallery_Bean("Item ","http://www.pinstripemag.com/wp-content/uploads/2012/01/sexy-ladies.jpg");
        Gallery_Bean gallery3=new Gallery_Bean("Item ","http://i01.i.aliimg.com/wsphoto/v0/569089275/Top-Quality-Ladies-Swimwear-Sexy-Bikini-Woman-s-Sexy-Swimsuits-Beachwear-Bathing-Suit-Ladies-Costume.jpg");
        Gallery_Bean gallery4=new Gallery_Bean("Item ","https://s-media-cache-ak0.pinimg.com/236x/c2/8c/8a/c28c8aa16e24a73bdb8ef4e6e2f8c6e7.jpg");
        Gallery_Bean gallery5=new Gallery_Bean("Item ","https://chivethebrigade.files.wordpress.com/2012/04/girls-mma-500-6.jpg");
        Gallery_Bean gallery6=new Gallery_Bean("Item ","http://25.media.tumblr.com/tumblr_lg8eozBCYI1qfsk8wo1_500.jpg");

        items.add(gallery1); items.add(gallery2); items.add(gallery3); items.add(gallery4); items.add(gallery5);
        items.add(gallery6);
        items.add(gallery1); items.add(gallery2); items.add(gallery3); items.add(gallery4); items.add(gallery5);
        items.add(gallery6);
        items.add(gallery1); items.add(gallery2); items.add(gallery3); items.add(gallery4); items.add(gallery5);
        items.add(gallery6);
        items.add(gallery1); items.add(gallery2); items.add(gallery3); items.add(gallery4); items.add(gallery5);
        items.add(gallery6);
        return items;
    }


    public static ArrayList<Teams> getPrev(){
        ArrayList<Teams>items=new ArrayList<>();

        items.add(new Teams("","",""));
        items.add(new Teams("","",""));
        items.add(new Teams("","",""));
        items.add(new Teams("","",""));
        items.add(new Teams("","",""));
        items.add(new Teams("","",""));
        items.add(new Teams("","",""));
        items.add(new Teams("","",""));
        items.add(new Teams("","",""));
        items.add(new Teams("","",""));
        items.add(new Teams("","",""));
        items.add(new Teams("","",""));
        items.add(new Teams("","",""));
        items.add(new Teams("","",""));
        items.add(new Teams("","",""));
        return items;
    }

    public static ArrayList<Teams> getProx(){
        ArrayList<Teams>items=new ArrayList<>();

        items.add(new Teams("","",""));
        items.add(new Teams("","",""));
        items.add(new Teams("","",""));
        items.add(new Teams("","",""));
        items.add(new Teams("","",""));
        items.add(new Teams("","",""));
        items.add(new Teams("","",""));
        items.add(new Teams("","",""));
        items.add(new Teams("","",""));
        return items;
    }

}
