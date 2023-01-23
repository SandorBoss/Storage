package org.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileStorage implements VehicleDataAccessInterface {
    @Override
    public VehicleEntity getVehicleByRegNumber(String regNumber) {
        VehicleEntity vehicleEntity = new VehicleEntity();
        vehicleEntity.setVehicleRegister("x hivatal");
        vehicleEntity.setVehicle("y jármű");
        vehicleEntity.setVehicleType("m1");
        vehicleEntity.setRegNumber("AB:CD-123");
        vehicleEntity.setFirstRegistration("2023-01-23");
        vehicleEntity.setMake("Suzuki");
        vehicleEntity.setModel("Swift");
        vehicleEntity.setSeatNumber("5");
        vehicleEntity.setEngineNumber("[ik260 2200 55445]");
        vehicleEntity.setColour("blue");
        vehicleEntity.setMassInService("1350");
        vehicleEntity.setMaxMass("2000");
        vehicleEntity.setBrakedTrailer("750");
        vehicleEntity.setUnbrakedTrailer("1500");
        vehicleEntity.setEmissionType("euro0");
        vehicleEntity.setFirstName("Firstname");
        vehicleEntity.setLastName("Lastname");
        vehicleEntity.setAddress("xfalva, y tér 1.");
//        vehicleEntity.setRegNumber("dummy-123");
//        vehicleEntity.setVehicle("Lada");
//        vehicleEntity.setVehicleRegister("Abcd");
//        vehicleEntity.setMake("asdf");
//        vehicleEntity.setSeatNumber("5");
//        vehicleEntity.setModel("Samara");
//        vehicleEntity.setVehicleType("van");
        System.out.println("filestorage get() called");
        return vehicleEntity;
    }

    @Override
    public void save(VehicleEntity vehicleEntity) {
        String filename = vehicleEntity.regNumber.replace(":", "");
        try {
            File fileToWrite = new File("../vehicles/" + filename + ".txt");
            fileToWrite.createNewFile();
            FileWriter dataWriter = new FileWriter("../vehicles/" + filename + ".txt");

            dataWriter.write("jármű nyilvántartó: " + vehicleEntity.vehicleRegister);
            dataWriter.write("jármű: " + vehicleEntity.vehicle);
            dataWriter.write("jármű kategória: " + vehicleEntity.vehicleType);
            dataWriter.write("rendszám: " + vehicleEntity.regNumber);
            dataWriter.write("első nyilvántartásba vétel: " + vehicleEntity.firstRegistration);
            dataWriter.write("gyártmány: " + vehicleEntity.make);
            dataWriter.write("típus: " + vehicleEntity.model);
            dataWriter.write("ülőhelyek száma vezetővel: " + vehicleEntity.seatNumber);
            dataWriter.write("motor azonosító száma: " + vehicleEntity.engineNumber);
            dataWriter.write("jármű színe: " + vehicleEntity.colour);
            dataWriter.write("saját tömeg: " + vehicleEntity.massInService);
            dataWriter.write("össztömeg: " + vehicleEntity.maxMass);
            dataWriter.write("fékezett vontatmány: " + vehicleEntity.brakedTrailer);
            dataWriter.write("fékezetlen vontatmány: " + vehicleEntity.unbrakedTrailer);
            dataWriter.write("környezetvédelmi besorolás: " + vehicleEntity.emissionType);
            dataWriter.write("utónév: " + vehicleEntity.firstName);
            dataWriter.write("családnév: " + vehicleEntity.lastName);
            dataWriter.write("cím: " + vehicleEntity.address);
            dataWriter.close();

            System.out.println("File has successfully updated");
        } catch (IOException exception) {
            System.out.println("An error occurred.");
            exception.printStackTrace();
        }
    }
}
