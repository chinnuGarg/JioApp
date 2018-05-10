package com.app.jiogameapp.utils;

import com.app.jiogameapp.R;
import com.app.jiogameapp.model.DataVal;

import java.util.ArrayList;

public class Common {

    public static int arr_images[]={R.drawable.image_1, R.drawable.image_2,R.drawable.image_3,R.drawable.image_3,R.drawable.image_3};
    public static String arr_name[]={"Township", "Subway","Temple Run","Ludo","Archery"};
    public static String arr_company[]={"Company name", "Company name","Company name","Company name","Company name"};

    public static int arr_images1[]={R.drawable.image_1, R.drawable.image_2,R.drawable.image_3,R.drawable.image_3,R.drawable.image_3};
    public static String arr_name1[]={"Township1", "Subway1","Temple Run1","Ludo1","Archery1"};
    public static String arr_company1[]={"Company name1", "Company name1","Company name1","Company name1","Company name1"};

    public static int arr_images2[]={R.drawable.image_1, R.drawable.image_2,R.drawable.image_3,R.drawable.image_3,R.drawable.image_3};
    public static String arr_name2[]={"Township2", "Subway2","Temple Run2","Ludo2","Archery2"};
    public static String arr_company2[]={"Company name2", "Company name1","Company name2","Company name2","Company name2"};

    public static ArrayList<DataVal> ListOneData(){
        return getData(arr_images,arr_name,arr_company);
    }

    public static ArrayList<DataVal> ListTwoData(){
       return getData(arr_images1,arr_name1,arr_company1);
    }

    public static ArrayList<DataVal> ListThreeData(){
        return getData(arr_images2,arr_name2,arr_company2);
    }

    public static ArrayList<DataVal> getData(int[] arr_images, String[] arr_name, String[] arr_company){
        ArrayList<DataVal> modelData=new ArrayList<>();
        for (int i = 0; i < arr_images.length ; i++) {

            DataVal dataVal= new DataVal();
            dataVal.setName(arr_name[i]);
            dataVal.setCompany_name(arr_company[i]);
            dataVal.setImage(arr_images[i]);

            modelData.add(dataVal);

        }

        return modelData;
    }


}
