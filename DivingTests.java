package scubaDive;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DivingTests {

    @Test
    public void testCreatDiving(){
    Diving diving = new Diving("Diving1", 10);
    Assert.assertEquals("Diving1", diving.getName());
    Assert.assertEquals(10, diving.getCapacity());
}

    @Test(expected = IllegalArgumentException.class)
    public void testCreatedDivingWithInvalidCapacity(){
        Diving diving = new Diving("Diving1", -5);
    }

    @Test(expected = NullPointerException.class)
    public void testCreatedDivingWithInvalidName(){
        Diving diving = new Diving(null, -5);
    }

    @Test(expected = NullPointerException.class)
    public void testCreatedDivingWithInvalidNameEmpty(){
        Diving diving = new Diving("", -5);
    }

    @Test
    public void addDeepWaterDiver(){
        Diving diving = new Diving("Diving1", 2);
        DeepWaterDiver deepWaterDiver = new DeepWaterDiver("Pesho", 10);

        Assert.assertEquals(0, diving.getCount());
        diving.addDeepWaterDiver(deepWaterDiver);
        Assert.assertEquals(1, diving.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void addDeepWaterDiverMoreThanCapacity(){
        Diving diving = new Diving("Diving1", 2);
        DeepWaterDiver deepWaterDiver = new DeepWaterDiver("Pesho", 10);
        DeepWaterDiver deepWaterDiver1 = new DeepWaterDiver("Pesho1", 10);
        DeepWaterDiver deepWaterDiver2 = new DeepWaterDiver("Pesho2", 10);


        diving.addDeepWaterDiver(deepWaterDiver);
        Assert.assertEquals(1, diving.getCount());
        diving.addDeepWaterDiver(deepWaterDiver1);
        Assert.assertEquals(2, diving.getCount());
        diving.addDeepWaterDiver(deepWaterDiver2);

    }

    @Test(expected = IllegalArgumentException.class)
    public void addDeepWaterDiverTwoCopies(){
        Diving diving = new Diving("Diving1", 2);
        DeepWaterDiver deepWaterDiver = new DeepWaterDiver("Pesho", 10);
        DeepWaterDiver deepWaterDiver1 = new DeepWaterDiver("Pesho", 10);


        diving.addDeepWaterDiver(deepWaterDiver);
        diving.addDeepWaterDiver(deepWaterDiver1);

    }

    @Test
    public void testRemoveDeepWaterDriver(){
        Diving diving = new Diving("Diving1", 2);
        DeepWaterDiver deepWaterDiver = new DeepWaterDiver("Pesho", 10);
        DeepWaterDiver deepWaterDiver1 = new DeepWaterDiver("Gosho", 10);

        diving.addDeepWaterDiver(deepWaterDiver);
        diving.addDeepWaterDiver(deepWaterDiver1);

        Assert.assertEquals(2, diving.getCount());

        diving.removeDeepWaterDiver("Pesho");

        Assert.assertEquals(1, diving.getCount());
    }

}
