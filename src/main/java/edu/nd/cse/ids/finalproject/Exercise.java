package edu.nd.cse.ids.finalproject;

/* city,country,dateAdded,dateUpdated,deposit,descriptions,features,fees,languages,lat,lng,name,numBathroom,numBedroom,numBed,numPeople,people,petPolicy,prices.dateSeen,prices.dateValidEnd,prices.dateValidStart,prices.minStay,prices.period,prices.price,province,rules,numItems1,item1,item1feature1,item1feature2,numItems2,item2,item2feature1,item2feature2,numItems3,item3,item3feature1,item3feature2,placeNameGeneral,viewDescription,neighborhoodDescription,neighborhoodName,nearbyPlace,nearbyPlaceDist,petsAllowed,petPolicy,greeting,roomType,bathroomType,houseDescription
name,muscleGroup1, muscleGroup2, muscleGroup3,instructions, isCardio, level, equipment
*/

import com.opencsv.bean.CsvBindByName;

public class Exercise
{
    @CsvBindByName
    private String name;
    
    @CsvBindByName
    private String musclegroup1;

    @CsvBindByName
    private String musclegroup2;
    
    @CsvBindByName
    private String musclegroup3;
    
    @CsvBindByName
    private String instructions;
    
    @CsvBindByName
    private String level;

    @CsvBindByName
    private String equipment;

    public String getName()
    {
        return name;
    }
    
    public String getMuscleGroup1()
    {
        return musclegroup1;
    }
    
    public String getMuscleGroup2()
    {
        return musclegroup2;
    }
    
    public String getMuscleGroup3()
    {
        return musclegroup3;
    }

    public String getInstructions()
    {
        return instructions;
    }

    public String getLevel()
    {
        return level;
    }

    public String getEquipment() {
        return equipment;
    }

}
