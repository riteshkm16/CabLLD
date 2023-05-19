package io.riteshkm16.lld.cab;

import io.riteshkm16.lld.cab.controller.CabController;
import io.riteshkm16.lld.cab.controller.RideController;
import io.riteshkm16.lld.cab.controller.UserController;
import io.riteshkm16.lld.cab.model.Cab;
import io.riteshkm16.lld.cab.model.Ride;
import io.riteshkm16.lld.cab.model.User;
import io.riteshkm16.lld.cab.model.dto.Location;
import io.riteshkm16.lld.cab.model.enums.Role;
import io.riteshkm16.lld.cab.repository.CabRepository;
import io.riteshkm16.lld.cab.repository.RideRepository;
import io.riteshkm16.lld.cab.repository.UserRepository;
import io.riteshkm16.lld.cab.service.CabService;
import io.riteshkm16.lld.cab.service.RideService;
import io.riteshkm16.lld.cab.service.UserService;
import io.riteshkm16.lld.cab.service.impl.CabServiceImpl;
import io.riteshkm16.lld.cab.service.impl.RideServiceImpl;
import io.riteshkm16.lld.cab.service.impl.UserServiceImpl;

import java.util.HashMap;

public class Application {
    /*
    //user
    1.Register
    2.Book for Ride

    //Driver
    1.start Ride
    2.end Ride
    3.list my ride


    */
    public static void main(String []args){
        System.out.println("init start");

        //init user
        UserRepository userRepository = new UserRepository(new HashMap<>(),0);
        UserService userService = new UserServiceImpl(userRepository);
        UserController userController = new UserController(userService);

        //init cab
        CabRepository cabRepository = new CabRepository(new HashMap<>(),0);
        CabService cabService = new CabServiceImpl(cabRepository);
        CabController cabController = new CabController(cabService);

        //init ride
        RideRepository rideRepository = new RideRepository(new HashMap<Integer, Ride>(),0);
        RideService rideService = new RideServiceImpl(rideRepository,cabService);
        RideController rideController = new RideController(rideService);


        System.out.println("init end");

        //register user

        User user1=User.builder()
                .name("Driver1")
                .email("ram@test.com")
                .contact("9199199999")
                .role(Role.DRIVER)
                .build();

        User user2=User.builder()
                .name("Driver2")
                .email("ram@test.com")
                .contact("9199199999")
                .role(Role.DRIVER)
                .build();


        User user3=User.builder()
                .name("Rider1")
                .email("ram@test.com")
                .contact("9199199999")
                .role(Role.RIDER)
                .build();

        User user4=User.builder()
                .name("Rider2")
                .email("ram@test.com")
                .contact("9199199999")
                .role(Role.RIDER)
                .build();


        //register users
        User driver1 = userController.registerUser(user1);
        User driver2 = userController.registerUser(user2);
        User rider1 = userController.registerUser(user3);
        User rider2 = userController.registerUser(user4);

        System.out.println(driver1);
        System.out.println(driver2);
        System.out.println(rider1);
        System.out.println(rider2);
        //register cabs
        Cab cabMarutiSwift = Cab.builder()
                .location(new Location(1,1,"location1"))
                .modelNo("Swift")
                .registrationNumber("KA01")
                .driverId(driver1.getId())
                .isAvailable(true)
                .build();
        Cab cabMahindraThar = Cab.builder()
                .location(new Location(4,1,"location2"))
                .modelNo("Thar")
                .registrationNumber("KA02")
                .isAvailable(true)
                .driverId(driver2.getId())//todo raise exception on assigment of save driver
                .build();

        Cab cab1 = cabController.registerCab(cabMarutiSwift);
        Cab cab2 = cabController.registerCab(cabMahindraThar);


        System.out.println(cab1);
        System.out.println(cab2);


        Ride ride = rideController.bookRide(new Location(0,0,""),new Location(10,10,""),user3);
        Ride ride2 = rideController.bookRide(new Location(0,0,""),new Location(10,10,""),user4);
        Ride ride3 = rideController.bookRide(new Location(0,0,""),new Location(10,10,""),user4);
        System.out.println("Ride :: "+ride);
        System.out.println("Ride :: "+ride2);
        System.out.println("Ride :: "+ride3);

        //










    }

}
