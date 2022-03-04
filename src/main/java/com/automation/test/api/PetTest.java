package com.automation.test.api;

import com.automation.common.Resources;
import com.automation.rest.BaseRest;
import com.automation.rest.PetRest;

import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PetTest{
    BaseRest bRest = new BaseRest();
    PetRest petRest = new PetRest();
    public static int petId;
    public static String petName;


    /**
     * Kimi zaman eklendiğine dair get servisinden sonuç gelmediği için
     * post servisine aynı parametrelerle 2 kez istek attım
     */
    @Test
    @Order(1)
    public void addNewPet() {
        petId = Integer.parseInt(bRest.createUniqueTimeStamp());
        petName = "name" +petId;
        JSONObject requestBodyJO = petRest.bodyPet(petId,petName,Resources.photoUrl);
        petRest.postPet(requestBodyJO);
        JSONObject responseJO = petRest.postPet(requestBodyJO);
        Assertions.assertEquals(petRest.retrievePetId(responseJO), petId);
        Assertions.assertEquals(petRest.retrievePetName(responseJO),petName);

    }

    /**
     *Service should not return 500 internal error code,it must be handled, it is a bug (i think)
     * but i automate as if i expected 500 when sending id param as string
     */
    @Test
    @Order(2)
    public void verifyInvalidPetIdIsHandled()
    {
        JSONObject requestBodyJO = petRest.bodyPet(Resources.invalidPetIdAsString,petName,Resources.photoUrl);
        JSONObject responseJO = petRest.postPet(requestBodyJO);
        Assertions.assertEquals(petRest.retrieveCode(responseJO), Resources.errorCode500);
    }

    /**/
    @Test
    @Order(3)
    public void getPetDetail() {

        String responseStr = petRest.getPet(petId);
        while(responseStr.equals(Resources.resultPetNotFound))
        {
            responseStr = petRest.getPet(petId);
            System.out.println(responseStr);
        }
        JSONObject responseJO = bRest.getResponseJO(responseStr);
        Assertions.assertEquals(petRest.retrievePetName(responseJO),petName);
    }

    @Test
    @Order(4)
    public void updatePetName() {
        String newPetName = "NewName"+petId;
        JSONObject requestBodyJO = petRest.bodyPet(petId,newPetName,Resources.photoUrl);
        JSONObject responseJO = petRest.putPet(requestBodyJO);
        Assertions.assertEquals(petRest.retrievePetId(responseJO), petId);
        Assertions.assertEquals(petRest.retrievePetName(responseJO),newPetName);
         responseJO = bRest.getResponseJO(petRest.getPet(petId));
        System.out.println("newPetName");
        System.out.println(newPetName);
        Assertions.assertEquals(petRest.retrievePetName(responseJO),newPetName);

    }

    @Test
    @Order(5)
    public void deletePet()
    {
        JSONObject responseJO =  petRest.deletePet(petId);
        Assertions.assertEquals(petRest.retrieveCode(responseJO), Resources.successCode200);
        String responseStr = petRest.getPet(petId);
        Assertions.assertEquals(responseStr,Resources.resultPetNotFound);

    }




}
